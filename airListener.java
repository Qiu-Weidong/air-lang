// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link airParser}.
 */
public interface airListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link airParser#compilation_unit}.
	 * @param ctx the parse tree
	 */
	void enterCompilation_unit(airParser.Compilation_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#compilation_unit}.
	 * @param ctx the parse tree
	 */
	void exitCompilation_unit(airParser.Compilation_unitContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(airParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(airParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(airParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(airParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#call_expression}.
	 * @param ctx the parse tree
	 */
	void enterCall_expression(airParser.Call_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#call_expression}.
	 * @param ctx the parse tree
	 */
	void exitCall_expression(airParser.Call_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(airParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(airParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#match_expression}.
	 * @param ctx the parse tree
	 */
	void enterMatch_expression(airParser.Match_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#match_expression}.
	 * @param ctx the parse tree
	 */
	void exitMatch_expression(airParser.Match_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#match_arms}.
	 * @param ctx the parse tree
	 */
	void enterMatch_arms(airParser.Match_armsContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#match_arms}.
	 * @param ctx the parse tree
	 */
	void exitMatch_arms(airParser.Match_armsContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#match_arm_expression}.
	 * @param ctx the parse tree
	 */
	void enterMatch_arm_expression(airParser.Match_arm_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#match_arm_expression}.
	 * @param ctx the parse tree
	 */
	void exitMatch_arm_expression(airParser.Match_arm_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#match_arm}.
	 * @param ctx the parse tree
	 */
	void enterMatch_arm(airParser.Match_armContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#match_arm}.
	 * @param ctx the parse tree
	 */
	void exitMatch_arm(airParser.Match_armContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#lambda_expression}.
	 * @param ctx the parse tree
	 */
	void enterLambda_expression(airParser.Lambda_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#lambda_expression}.
	 * @param ctx the parse tree
	 */
	void exitLambda_expression(airParser.Lambda_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(airParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(airParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(airParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(airParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(airParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(airParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(airParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(airParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(airParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(airParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#empty_stmt}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_stmt(airParser.Empty_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#empty_stmt}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_stmt(airParser.Empty_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#expression_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpression_stmt(airParser.Expression_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#expression_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpression_stmt(airParser.Expression_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#block_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlock_stmt(airParser.Block_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#block_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlock_stmt(airParser.Block_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(airParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(airParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(airParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(airParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(airParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(airParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void enterLoop_stmt(airParser.Loop_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void exitLoop_stmt(airParser.Loop_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(airParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(airParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinue_stmt(airParser.Continue_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinue_stmt(airParser.Continue_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak_stmt(airParser.Break_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak_stmt(airParser.Break_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#variable_define}.
	 * @param ctx the parse tree
	 */
	void enterVariable_define(airParser.Variable_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#variable_define}.
	 * @param ctx the parse tree
	 */
	void exitVariable_define(airParser.Variable_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(airParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(airParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#function_define}.
	 * @param ctx the parse tree
	 */
	void enterFunction_define(airParser.Function_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#function_define}.
	 * @param ctx the parse tree
	 */
	void exitFunction_define(airParser.Function_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(airParser.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(airParser.Import_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(airParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(airParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#import_item}.
	 * @param ctx the parse tree
	 */
	void enterImport_item(airParser.Import_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#import_item}.
	 * @param ctx the parse tree
	 */
	void exitImport_item(airParser.Import_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#enumeration_define}.
	 * @param ctx the parse tree
	 */
	void enterEnumeration_define(airParser.Enumeration_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#enumeration_define}.
	 * @param ctx the parse tree
	 */
	void exitEnumeration_define(airParser.Enumeration_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#enum_items}.
	 * @param ctx the parse tree
	 */
	void enterEnum_items(airParser.Enum_itemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#enum_items}.
	 * @param ctx the parse tree
	 */
	void exitEnum_items(airParser.Enum_itemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#enum_item}.
	 * @param ctx the parse tree
	 */
	void enterEnum_item(airParser.Enum_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#enum_item}.
	 * @param ctx the parse tree
	 */
	void exitEnum_item(airParser.Enum_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#enum_suffix}.
	 * @param ctx the parse tree
	 */
	void enterEnum_suffix(airParser.Enum_suffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#enum_suffix}.
	 * @param ctx the parse tree
	 */
	void exitEnum_suffix(airParser.Enum_suffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#class_define}.
	 * @param ctx the parse tree
	 */
	void enterClass_define(airParser.Class_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#class_define}.
	 * @param ctx the parse tree
	 */
	void exitClass_define(airParser.Class_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#class_body}.
	 * @param ctx the parse tree
	 */
	void enterClass_body(airParser.Class_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#class_body}.
	 * @param ctx the parse tree
	 */
	void exitClass_body(airParser.Class_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#class_member_define}.
	 * @param ctx the parse tree
	 */
	void enterClass_member_define(airParser.Class_member_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#class_member_define}.
	 * @param ctx the parse tree
	 */
	void exitClass_member_define(airParser.Class_member_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#method_define}.
	 * @param ctx the parse tree
	 */
	void enterMethod_define(airParser.Method_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#method_define}.
	 * @param ctx the parse tree
	 */
	void exitMethod_define(airParser.Method_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#static_method_define}.
	 * @param ctx the parse tree
	 */
	void enterStatic_method_define(airParser.Static_method_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#static_method_define}.
	 * @param ctx the parse tree
	 */
	void exitStatic_method_define(airParser.Static_method_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#member_method_define}.
	 * @param ctx the parse tree
	 */
	void enterMember_method_define(airParser.Member_method_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#member_method_define}.
	 * @param ctx the parse tree
	 */
	void exitMember_method_define(airParser.Member_method_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#field_define}.
	 * @param ctx the parse tree
	 */
	void enterField_define(airParser.Field_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#field_define}.
	 * @param ctx the parse tree
	 */
	void exitField_define(airParser.Field_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#interface_define}.
	 * @param ctx the parse tree
	 */
	void enterInterface_define(airParser.Interface_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#interface_define}.
	 * @param ctx the parse tree
	 */
	void exitInterface_define(airParser.Interface_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#interface_body}.
	 * @param ctx the parse tree
	 */
	void enterInterface_body(airParser.Interface_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#interface_body}.
	 * @param ctx the parse tree
	 */
	void exitInterface_body(airParser.Interface_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#interface_member_define}.
	 * @param ctx the parse tree
	 */
	void enterInterface_member_define(airParser.Interface_member_defineContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#interface_member_define}.
	 * @param ctx the parse tree
	 */
	void exitInterface_member_define(airParser.Interface_member_defineContext ctx);
	/**
	 * Enter a parse tree produced by {@link airParser#method_declare}.
	 * @param ctx the parse tree
	 */
	void enterMethod_declare(airParser.Method_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link airParser#method_declare}.
	 * @param ctx the parse tree
	 */
	void exitMethod_declare(airParser.Method_declareContext ctx);
}