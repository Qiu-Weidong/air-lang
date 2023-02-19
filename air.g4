grammar air;
import airlex;

compilation_unit: 
    (import_stmt
    | class_define
    | function_define
    | interface_define
    | enumeration_define)*
    EOF
    ;

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
    | expression 'instanceof' type
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

primary: literal | Identifier | '(' expression ')' | 'self';
call_expression: 'await'? Identifier '(' expression_list? ')' ;
expression_list
    : expression (',' expression)*
    ;

match_expression
    : 'match' expression '{' match_arms '}'
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
type:
   'interger'
   | 'void'
   | 'float'
   | 'char'
   | 'bool'
   | 'string'
   | 'list' '<' type '>'
   | 'map' '<' type '>'
   | '(' type (',' type)* ')'
   | Identifier
   ;


literal:
	HexLiteral
	| DecimalLiteral
	| OctalLiteral
	| CharacterLiteral
	| StringLiteral
	| FloatingPointLiteral
	| BoolLiteral
	| 'null';

pattern:  literal | Identifier | '*';

params: Identifier ':' type (',' Identifier ':' type)? ;

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
    | variable_define
    | assign_stmt
    ;
empty_stmt: ';' ;
expression_stmt: expression ';' ;
block_stmt: '{' stmt* '}' ';'? ;
if_stmt: 'if' '(' expression ')' stmt ('else' stmt)?;
while_stmt: 'while' '(' expression ')' stmt;
for_stmt: 'for' '(' Identifier 'in' expression ')' stmt ; 
loop_stmt: 'loop' '{' stmt* '}' ;
return_stmt: 'return' expression? ;
continue_stmt: 'continue' ';' ;
break_stmt: 'break' ';' ;
variable_define:
   ('let' | 'const') Identifier (':' type)? ('=' expression  ) ';' ;
assign_stmt: expression '=' expression ';' ;



function_define:
    'export'? 'async'? 'func' Identifier '(' params? ')' 
    ( ('->' | ':') type )?
    block_stmt;


import_stmt: 
    'from' path 'import' 
        ( import_item 
          | '{' import_item(',' import_item)* '}' 
        ) ';'
    | 'import' 
        ( import_item 
          | '{' import_item (',' import_item)* '}'
        ) 
      'from' path ';'
    ;


path: StringLiteral;

import_item: Identifier 'as' Identifier ;

enumeration_define
    : 'enum' Identifier '{' enum_items? '}'
    ;
enum_items
    : enum_item (',' enum_item)* ','?
    ;
enum_item 
    : Identifier enum_suffix?
    ;
enum_suffix
    : '(' type (',' type)? ')'
    ;




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

method_define
    : 
      static_method_define 
      | ('virtual' | 'override')? member_method_define 
    ;
static_method_define : function_define ;
member_method_define 
    : 
        'async'? 'func' Identifier 
        '(' 'self' (',' Identifier ':' type)?  ')' 
        ( ('->' | ':') type )?
        block_stmt
    ;
field_define:
    Identifier ':' type ';' ;

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
    'virtual'? 'func' Identifier 
    '(' 'self' (',' Identifier ':' type)?  ')' 
    (('->' | ':') type )? ';' 
    | 'func' Identifier '(' params? ')' (('->' | ':') type )? ';' 
    ;
