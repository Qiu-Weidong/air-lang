类型系统
强类型
类型分为简单类型和复合类型。
简单类型有整数、浮点数、布尔值、字符。
符合类型有数组、元组、对象(类)。

单继承
Dart 中的mixin？

Java 的互操作性

async await Promise

一、总体设计
1.1  背景与动机
软件产品能够从最初的面向专业用途，逐渐发展出如今广大的面向消费者的市场，友好美观的 UI 交互页面发挥了无可替代的作用。不仅软件开发工具在不断优化 UI 设计开发的功能，编程语言本身的发展也受到了其影响。
在 2014 年，苹果推出了新的编程语言 Swift 以取代 Objective-C，引入了更多的现代编程语言特性，并在 2019 年推出了基于 Swift 的声明式 UI 框架 SwiftUI。在 2016 年，Jetbrains 也发布了面向 JVM 的新语言 Kotlin，并在随后被谷歌选为安卓应用的首选开发语言。以 Kotlin 为基础，谷歌也推出了针对安卓平台的 UI 开发工具包 Jetpack Compose。在跨平台领域，谷歌设计了全新的 Dart 语言，作为 UI 框架的 Flutter 使用的主要语言活跃至今。
而对于老牌编程语言 Java 来说，其编写 UI 的体验早已被 iOS、安卓等平台下新的语言和框架拉开了差距。在基于 Java 的开发中，同样有诸多辅助包和工具：JavaFX 虽然以 Java 为平台，但选择了使用 XML 来定义 UI 页面；AWT、Swing 和 Eclipse SWT 都使用 Java 语言直接编写 UI，但都是命令式 UI 的实现方式，使得开发者在编写 UI 时并不能专注于 UI 本身的设计，而是将更多的精力花费在了实例化元件、组成完整页面以及 UI 更新变化的控制。这既是 UI 框架设计和技术选型带来的问题，也体现出了 Java 语言本身不够灵活的地方。
即使在 UI 编写上存在不便甚至不足，Java 仍然是跨平台、尤其是桌面平台开发的热门语言。本项目的目标是提升以 Java 为平台语言的 UI 编写功能，支持响应式 UI 风格的编写方式。项目设计一种新的简单编程语言「Air」，接管 UI 编写的部分，通过与 Java 语言程序之间的互操作功能，实现与 Java 项目的整合。
1.2  特性与取舍
「Air」编程语言专注于对 UI 编写的支持，通过与 Java 的整合，将复杂功能交由 Java 实现。因此「Air」语言的核心目标有二：
支持以声明式 UI 的形式清晰、简洁地表达 UI 设计
与 Java 间必要的互操作性
基于这两点核心目标，能够对一些特性做出取舍。
1.2.1  函数调用方式


1.2.2  不支持多进程 / 线程

1.2.3  不完全的面向对象


二、词法设计
2.1 关键字
关键字指编程语言中预先保留的单词，它们不能当做变量名、函数名和模块名使用。本语言使用的关键字如下所示。
// data type
INT : 'integer';
FLOAT : 'float';
CHAR : 'char';
BOOL : 'bool';
STRING : 'string';
LIST: 'list' ;
MAP: 'map' ;

// variable definition
LET : 'let';
CONST: 'const' ;
// function
FUNC : 'func';
RETURN : 'return';
// control statement
IF : 'if';
ELSE : 'else';
FOR : 'for';
WHILE : 'while';
LOOP: 'loop' ;

IN : 'in';
BREAK : 'break';
CONTINUE : 'continue';
// literal
TRUE : 'true';
FALSE : 'false';
// 异步操作
ASYNC: 'async' ;
AWAIT: 'await' ;

// 函数重载相关
OVERRIDE: 'override' ;
VIRTUAL: 'virtual' ;

// 类型判断
INSTANCEOF: 'instanceof' ;
// as
AS: 'as' ;
// self
SELF: 'self' ;

MATCH: 'match' ;
LAMBDA: 'lambda' ;

// 导出
EXPORT: 'export' ;

2.2 数值类型
数值类型包括整型、浮点型、布尔型、字符型等，下面给出它们的产生式。
digit : ['0' - '9'];
letter : ['a'-'z'] | ['A'-'Z'];
INT : ('+' | '-') digit+;
FLOAT : digit+ '.' digit+;
BOOL : 'true' | 'false';
CHAR : digit | letter | ...;  //包括其他任意字符

2.3 变量
变量采用一般语言的设计规则，以字母或者下划线开头，后面是字母、数字和下划线的任意组合。下面是变量VARIABLE的产生式。
digit : ['0'-'9'];
letter : ['a'-'z'] | ['A'-'Z'];
VARIABLE : [letter| '_'] [letter | digit | '_' ]*；

2.4 运算符
运算符包括算数运算符、关系运算符、赋值运算符、逻辑运算符等，下面给出运算符的定义。
// arithmetic
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
POW : '**';
MOD : '%';
// relational
EQUAL : '==';
UNEQUAL : '!=';
GT : '>';
GE : '>=';
LT : '<';
LE : '<=';
// assignment
ASSIGN : '=';
// logical
AND : '&&';
OR : '||';
NOT : '!'; 

三、语法设计

注释
注释以  // 开始，至行末结束，与C语言相同。如下所示: 产生式
// 这是一条注释
其产生式如下所示:
 Comment: '//' ~[\r\n]* '\r'? '\n' ;
 
变量定义
变量定义参考了rust语法，变量定义的语法规则如下所示：
variable_define:
   ('let' | 'const') Identify (':' type)? ('=' initialize_expr) ';' ;
type:
   'interger'
   | 'float'
   | 'char'
   | 'bool'
   | 'string'
   | 'list' '<' type '>'
   | 'map' '<' type '>'
   | '(' type (',' type)* ')'
   | Identify
   ;
  
initialize_expr: expression  
其中，expression 的产生式见下文，Identify 的表达式见词法分析。

表达式
表达式的产生式如下所示：
expression
    : primary
    | expression '.'
        (
            Identifier
        | call_expression
        )
    | expression '[' expression ']'
    | call_expression
    | expression ('++' | '--')
    | ('+'|'-'|'++'|'--') expression
    | ('~'|'!') expression
    | expression ('*'|'/'|'%') expression
    | expression ('+'|'-') expression
    | expression ('<' '<' | '>' '>' '>' | '>' '>') expression
    | expression ('<=' | '>=' | '>' | '<') expression
    | expression isinstanceof type
    | expression ('==' | '!=') expression
    | expression '&' expression
    | expression '^' expression
    | expression '|' expression
    | expression '&&' expression
    | expression '||' expression
    | <assoc=right> expression '?' expression ':' expression
    | <assoc=right> expression
        ('=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '>>=' | '>>>=' | '<<=' | '%=')
        expression
    | lambda_expression 
    | match_expression 
    | expression 'as' type
    ;

primary: literal | Identifier | '(' expression ')';
call_expression: 'await'? Identifier '(' expression_list? ')' ;
expression_list
    : expression (',' expression)*
    ;

match_expression
    : 'match' expression '{' match_arms? '}'
    ;
match_arms
    : (match_arm '=>' match_arm_expression)* 
    ;
match_arm_expression
    : expression ','
    | '{' expression '}' ','?
    ;
match_arm
    : pattern
    ;
lambda_expression: 
    'lambda' '|' params '|' '->' 
    (block_stmt | expression ) 
    ;
其中 <assoc=right> 表示运算符是右结合的。表达式的大多数语法与java、C、C++等常见语言类似，同时也参考的rust等新型语言的设计得比较好的语法。
我们的语言支持的表达式有以下几种：
常见算数表达式，与C++、C、Java等类似
关系运算表达式
逻辑运算表达式
位运算表达式
lambda表达式
函数调用表达式
类型判断表达式
类型转换表达式
match匹配表达式，与rust类似
算数表达式
算数表达式就是基本的加减乘除运算，如下所示:
// 一条加法运算表达式，将变量a与常数30相加
a + 30
// 一条减法运算表达式，将90与7相减，结果为83
90 - 7
// 乘法表达式
var1 * var2
// 除法表达式，对整数来说是整除，对浮点数来说是小数除法
var1 / var2
// 取余表达式，只对整数有效
var1 % var2
// 自增表达式
x++
// 自减表达式
y--
关系运算表达式

逻辑运算表达式
该表达式的结果是为一个布尔值，两个运算数也是布尔值。

位运算表达式
使用  &、 | 、 ^ 分别对操作数进行按位与、按位或以及按位异或。
如:
// 将x与y按位与
x & y
// 将x与y按位或
x | y
// 将x与y按位异或
x ^ y
lambda表达式
 lambda 表达式可以捕获环境中的变量，并且可以为他提供参数。如下所示：
// 一个返回两数之和的lambda表达式
lambda |x, y| -> x + y
// 也可以用代码块表示
lambda |x, y| { return x + y; }
函数调用表达式
函数调用表达式和常规语言类似，如下所示：
// 以x和y为参数调用foo函数
foo(x, y)
类型判断表达式
使用  instanceof 关键字来进行类型判断，如：
// 判断x是否是类型y的一个示例
x instanceof y
类型转换表达式
类型转换表达式与  rust 语言类似，使用关键字  as 来进行类型转换，如：
// 将x转换为 float
x as float
match匹配表达式
我们的  Air 语言摒弃了C语言和java语言中的  switch 匹配，而选择了类似于  rust 语言的  match 匹配机制，如下所示：
match msg {
  "hello" => 3,
  "world" => 7,
  * => 0
}
上面的代码的意思是，如果 变量 msg 的值为  "hello" 那么，该表达式的值为 3 ，如果  msg 的值为  "world" 则表达式值为 7 ，否则，和最后的  * 匹配，表达式值为 0 。

语句
语句  stmt 的产生式如下所示:
stmt:
    empty_stmt
    | expression_stmt
    | block_stmt
    | if_stmt
    | while_stmt
    | for_stmt
    | loop_stmt
    | break_stmt
	| continue_stmt
	| return_stmt
    | varible_define_stmt
    | assign_stmt
    ;
空语句
空语句就是一个单独的分号，如下所示：
// 空语句
;
空语句的产生式如下：
empty_stmt: ';' ;
表达式语句
表达式语句就是一个表达式后面接一个分号，产生式如下：
expression_stmt: expression ';' ;
表达式语句的一个示例如下所示:
// 表达式语句
x + y ;
代码块语句
代码块语句由一对大括号  {} 包裹，中间有若干条语句。代码块语句最后的分号可以省略。
产生式如下：
block_stmt: '{' stmt* '}' ';'? ;
一个示例：
{
  x + 1;
  y * 3;
};
if语句
if 语句用于控制流。产生式如下所示：
if_stmt: 'if' '(' expression ')' stmt ('else' stmt)?;
下面是一个  if 表达式的示例：
if (true) { x - 5 } else if (true) { y + 7 } else { z - 6 }
循环语句
循环分为  for 循环和  while 循环，以及  loop 循环。现分别进行介绍。
 while 循环的产生式如下：
while_stmt: 'while' '(' expression ')' stmt;
和C语言一样，当  expression 表达式值为真时，就会重复执行  stmt 中的语句。
 for 循环的产生式如下：
for_stmt: 'for' '(' Identify 'in' expression ')' stmt ; 
其中， expression 中的返回值需要是一个列表，该语句会对列表中的元素进行遍历，并执行  stmt 中的语句。
 loop 循环的产生式如下:
loop_stmt: 'loop' '{' stmt* '}' ;
该语句会循环执行大括号中的语句，程序员需要在大括号内使用  break 来跳出循环。
变量定义语句
见上文  变量定义 部分。
break、continue和return
 return 语句用于返回，产生式如下：
return_stmt: 'return' expression? ;
 continue 和  break 语句产生式如下：
continue_stmt: 'continue' ';' ;
break_stmt: 'break' ';' ;
赋值语句
产生式如下：
assign_stmt: Identify '=' expression ';' ;

函数定义
 air 语言的函数分为普通函数和类方法，其中，类方法的介绍见类定义一节。
普通函数的产生式如下所示：
funcion_define:
    'export'? 'async'? 'func' Identify '(' params? ')' 
    ( ('->' | ':') type )?
    block_stmt;
params: Identify ':' type (',' Identify ':' type)? ;
 type  block_stmt 等产生式前文已经介绍，不在赘述。
下面是函数的一个示例：
// 一个函数的示例
func main(argc: interger, argv: list<string>) -> interger {
  
}
// 其中 '->' 可以替换为 ':'
func main(argc: interger, argv: list<string>) : interger {
  
}
// 如果需要在该文件外部使用此函数，则可以使用 `export` 导出，并
// 在使用他的文件中使用 'import' 导入
export func splink() {}
导包
导包语句与JavaScript和TypeScript类似，产生式如下：
import_stmt: 
    'from' path 'import' 
        ( import_item 
          | '{' import_item(',' import_item)* '}' 
        )
    | 'import' 
        ( import_item 
          | '{' import_item (',' import_item)* '}'
        ) 
      'from' path
    ;
path: '"'('./' | '../') Identify ('/' Identify)* '"';
import_item: Identify 'as' Identify ;
导入的对象需要使用  export 语句导出，这和JavaScript、TypeScript类似。支持用  as 来指定别名。
枚举定义
 air 语言支持枚举，枚举借鉴了  rust 语言的设计。
产生式如下：
enumeration_define
    : 'enum' Identifier '{' enum_items? '}'
    ;
enum_items
    : enum_item (',' enum_item)* ','?
    ;
enum_item 
    : Identify enum_suffix?
    ;
enum_suffix
    : '(' type (',' type)? ')'
    ;
如果只需要Java和C++风格的枚举，则可以这样定义：
// 简单枚举示例
enum Color { Red, Blue, Yellow }
如果要实现  C 和  C++ 语言的联合体类型，则可以这样定义:
// 实现联合体
enum IP {
  V4(interger, interger, interger, interger),
  V6(string)
}
可以使用  instanceof 运算符来确定当前变量属于枚举的哪一个变体，也可以用  match 来匹配，就像  rust 一样。
类定义
类定义与  java 类似，产生式如下：
class_define
    : 'export' 'class' Identifier
      ('extends' type)?
      ('implements' type (',' type)? )?
      class_body
    ;
class_body
    : 
        '{' 
            class_member_define* 
        '}'
    ;
class_member_define
    : 
        ('public' 
            | 'private' 
            | 'protected'
        )? 
        (method_define
            | field_define
            | interface_define
            | class_define
            | enumeration_define
        )
    ;
 以上是类的整体框架，在类中，可以定义类方法、类字段、接口、内部类和枚举。并且和java一样，使用  public  private  protected 来修饰。
类方法定义
类方法分为成员函数与非成员函数，这里借鉴了  rust 和  python ，成员函数要以  self 作为第一个参数。产生式如下：
method_define
    : 
      static_method_define 
      | ('virtual' | 'override')? member_method_define 
    ;
static_method_define : function_define ;
member_method_define 
    : 
        'async'? 'func' Identify 
        '(' 'self' (',' Identify ':' type)?  ')' 
        ( ('->' | ':') type )?
        block_stmt
    ;
类字段定义
产生式如下：
field_define:
    Identify ':' type ';' ;
类其他成员定义
类中还可以定义接口、枚举和内部类，见对应小节。
一个完整的类的示例
class Persion {
  enum Sex {
    Man, Women
  }
  
  private name: string;
  private sex: Sex;
  public func get_name(self) -> string { return self.name; }
  public func get_sex(self) -> Sex { return self.sex; }
   
}

export class Student extends Persion {
  private id: interger;
  
  public func study(self) -> void {}
  public func get_id(self) -> interger { return self.id; }  
}

接口定义
和  java 的接口类似，产生式如下：
interface_define
    : 'interface' Identifier 
      ('extends' type (',' type)? )? 
      interface_body
    ;
interface_body
    : 
        '{' 
            interface_member_define* 
        '}'
    ;
interface_member_define
    : 
        ('public' 
            | 'private' 
            | 'protected'
        )? 
        method_declare
    ;
method_declare:
    'func' Identifier 
    '(' 'self' (',' Identify ':' type)?  ')' 
    (('->' | ':') type )? ';' 
    | 'func' Identifier '(' params? ')' (('->' | ':') type )? ';' 
    ;
相对  java 来说，我们的  interface 比较简化，只能够定义方法。
异步操作
 air 语言的异步操作借鉴了  JavaScript 和 TypeScript 的特性，支持  async 和  await 关键字。
在函数前面加上  async 可以将函数声明为异步函数，异步函数的返回值是一个  future<T> 类型，表示在未来的某个时刻会具备值。
 future 是一个枚举，有  Ready 和  Wait  两个枚举变量，如下所示：
enum future {
  Ready(T),
  Wait
}
可以在调用函数的时候使用 await 关键字，此调用会阻塞当前线程，直到异步调用结束而获取到  future 中的值。
语法树示例
使用一个示例来展示语法树：
from "../BaseButton" import BaseButton as Button;


interface Drawable {
    protected virtual func draw(self);  
}

export class BeautifulButton extends Button implements Drawable {
    // rgba
    private color: (integer, integer, integer, integer);

    private text: string;

    public func get_text(self) -> string {
        return self.text;
    }

    public func get_color(self) -> (integer, integer, integer, integer) {
        return self.color;
    }

    public func set_text(self, text: string) {
        self.text = text;
    }

    public func set_color(self, color: (integer, integer, integer, integer)) {
        self.color = color;
    }


    // 实现接口中的方法
    protected override func draw(self) {  }

    enum Option {
        Some(integer),
        None
    }

    private children: list<Button>;

    // 定义一个非成员函数
    public func add(x: float, y: float) -> float {
        return x + y;
    }

    // for循环
    public func loop_test(self) {
        for (child in self.children) {
            child.draw();
        }
    }

    // async 测试
    public async func test_async(self) {

    } 
}

该示例尽可能地涵盖了尽可能多的语法分支。
该示例的语法树如下图所示。
图片: https://uploader.shimo.im/f/2aaev2gtUXlT0LPa.png!thumbnail?accessToken=eyJhbGciOiJIUzI1NiIsImtpZCI6ImRlZmF1bHQiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE2NzAzMTIyODgsImZpbGVHVUlEIjoibG9xZVdkTTRwcHVEMlhBbiIsImlhdCI6MTY3MDMxMTk4OCwiaXNzIjoidXBsb2FkZXJfYWNjZXNzX3Jlc291cmNlIiwidXNlcklkIjo4NjQwOTQ5MH0.woLm1xXP7bC6uuuMcEpLtSPalNPbQUuL6PeB7hoh8eM
一个补充示例，展示了上一个示例没有覆盖的语法特性：
func main() {
    let msg: string = "hello";

    let x: integer = match msg {
        "hello" => 5,
        "world" => 6,
        * => 7,
    };

    let f = lambda |x: float, y: float| -> x + y;
}

语法树如下：
图片: https://uploader.shimo.im/f/eXuLNQvlbkHLuogl.png!thumbnail?accessToken=eyJhbGciOiJIUzI1NiIsImtpZCI6ImRlZmF1bHQiLCJ0eXAiOiJKV1QifQ.eyJleHAiOjE2NzAzMTIyODgsImZpbGVHVUlEIjoibG9xZVdkTTRwcHVEMlhBbiIsImlhdCI6MTY3MDMxMTk4OCwiaXNzIjoidXBsb2FkZXJfYWNjZXNzX3Jlc291cmNlIiwidXNlcklkIjo4NjQwOTQ5MH0.woLm1xXP7bC6uuuMcEpLtSPalNPbQUuL6PeB7hoh8eM

四、语义设计

数据类型
基本数据类型
整形 固定 64 位   名字叫 int
浮点数 固定 64 位  名字叫 float
字符  固定 32 位 使用 UTF-8 参考 rust
布尔 bool
引用数据类型
Object
Enum
空安全
列表: list
字典: map
元组: Turple
字符串: String
环境域

存储域

指称语义