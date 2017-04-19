import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;



class class_main
{
	int symbol_table_size = 100;
	public String [] symbol_table = new String[symbol_table_size];
	int entry_position = 0;
	boolean exists = false;

	public static void main(String args[])
	{
			FileReader fr = null;
	        String input = "C:\\Users\\Ali Gholami\\Documents\\Amirkabir\\COMPILER\\Chronicle\\PHASE1_LEXICAL_ANALYZER\Global_Test\\globalTest2.shl";
	        try {
	            fr = new FileReader(input);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        // System.out.println("Lexeme\tToken\tAttribute");
	        Yylex yylex = new Yylex(fr);
	        try {
	            yylex.yylex();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
%%
/* Declaration Section */
/* Identifier */
%byaccj
/* Tokens */
LETTER = [a-zA-Z]
NONZERO_DIGIT = [1-9]
DIGIT = "0"|{NONZERO_DIGIT}


/* Main & Program Keywords */
PROGRAM_KW = (program)
MAIN_KW = (main)

/* Variable Types Keywords */
INTEGER_KW = (int)
REAL_KW = (real)
CHARACTER_KW = (char)
BOOLEAN_KW = (bool)

PROCEDURE_KW = (procedure)

/* Condition Keywords */
IF_KW = (if)
THEN_KW = (then)
ELSE_KW = (else)
DO_KW = (do)
WHILE_KW = (while)
SWITCH_KW = (switch)
CASE_KW = (case)
DEFAULT_KW = (default)
END_KW = (end)
WHEN_KW = (when)

/* Utility Keywords */
FOR_KW = (for)
RETURN_KW = (return)
EXIT_KW = (exit)
UPTO_KW = (upto)
DOWNTO_KW = (downto)

/* Logical Operations Keywords */
AND_KW = (and)
OR_KW = (or)
NOT_KW = (not)

/* Separator Keywords */
SEMICOLON_KW = [;]
COLON_KW = [:]
ASSIGN_KW = (:=)
OPENBRACKET_KW = "["
CLOSEBRACKET_KW = "]"
OPENACCOLADE_KW = [{]
CLOSEACCOLADE_KW = [}]
OPENPARENTHESIS_KW = [(]
CLOSEPARENTHESIS_KW = [)]
COMMA_KW = [,]

/* Relational Operators */
LT_KW = [<]
GT_KW = [>]
EQ_KW = [=]
NEQ_KW = (<>)
GTE_KW = (>=)
LTE_KW = (<=)

/* Other Keywords */
DOT_KW = "\."
SINGLE_QUOTE_KW = "\u0027"

/* Arithmetic Operators */
ADD_KW = [+]
SUB_KW = [-]
MUL_KW = [*]
DIV_KW = [/]
MOD_KW = [%]
SHARP_KW = [#]


BOOLCONST = (true)|(false)
CHARCONST = {SINGLE_QUOTE_KW} ({LETTER} | {DIGIT}) {SINGLE_QUOTE_KW}
REALCONST = {SHARP_KW}((({DIGIT})|({NONZERO_DIGIT}({DIGIT})*))({DOT_KW})({DIGIT})*{NONZERO_DIGIT})
NUMCONST = {SHARP_KW}({DIGIT}|{NONZERO_DIGIT}{DIGIT}*)
ID = {LETTER}+
%%
/* Rules Section */

{PROGRAM_KW} {
	// System.out.println(yytext() + "\t" + "PROGRAM_KW\t" + '-');
	return YYParser.PROGRAM_KW;
}

{MAIN_KW} {
	// System.out.println(yytext() + "\t" + "MAIN_KW\t" + '-');
	return YYParser.MAIN_KW;
}

{PROCEDURE_KW} {
	// System.out.println(yytext() + "\t" + "PROCEDURE_KW\t" + '-');
	return YYParser.PROCEDURE_KW;
}

{INTEGER_KW} {
	// System.out.println(yytext() + "\t" + "INTEGER_KW\t" + '-');
	return YYParser.INTEGER_KW;
}

{REAL_KW} {
	// System.out.println(yytext() + "\t" + "REAL_KW\t" + '-');
	return YYParser.REAL_KW;
}

{CHARACTER_KW} {
	// System.out.println(yytext() + "\t" + "CHARACTER_KW\t" + '-');
	return YYParser.CHARACTER_KW;
}

{BOOLEAN_KW} {
	// System.out.println(yytext() + "\t" + "BOOLEAN_KW\t" + '-');
	return YYParser.BOOLEAN_KW;
}

{IF_KW} {
	// System.out.println(yytext() + "\t" + "IF_KW\t" + '-');
	return YYParser.IF_KW;
}

{THEN_KW} {
	// System.out.println(yytext() + "\t" + "THEN_KW\t" + '-');
	return YYParser.THEN_KW;
}

{ELSE_KW} {
	// System.out.println(yytext() + "\t" + "ELSE_KW\t" + '-');
	return YYParser.ELSE_KW;
}

{DO_KW} {
	// System.out.println(yytext() + "\t" + "DO_KW\t" + '-');
	return YYParser.DO_KW;
}

{WHILE_KW} {
	// System.out.println(yytext() + "\t" + "WHILE_KW\t" + '-');
	return YYParser.WHILE_KW;
}

{FOR_KW} {
	// System.out.println(yytext() + "\t" + "FOR_KW\t" + '-');
	return YYParser.FOR_KW;
}

{SWITCH_KW} {
	// System.out.println(yytext() + "\t" + "SWITCH_KW\t" + '-');
	return YYParser.SWITCH_KW;
}

{CASE_KW} {
	// System.out.println(yytext() + "\t" + "CASE_KW\t" + '-');
	return YYParser.CASE_KW;
}

{DEFAULT_KW} {
	// System.out.println(yytext() + "\t" + "DEFAULT_KW\t" + '-');
	return YYParser.DEFAULT_KW;
}

{END_KW} {
	// System.out.println(yytext() + "\t" + "END_KW\t" + '-');
	return YYParser.END_KW;
}

{RETURN_KW} {
	// System.out.println(yytext() + "\t" + "RETURN_KW\t" + '-');
	return YYParser.RETURN_KW;
}

{EXIT_KW} {
	// System.out.println(yytext() + "\t" + "EXIT_KW\t" + '-');
	return YYParser.EXIT_KW;
}

{WHEN_KW} {
	// System.out.println(yytext() + "\t" + "WHEN_KW\t" + '-');
	return YYParser.WHEN_KW;
}

{AND_KW} {
	// System.out.println(yytext() + "\t" + "AND_KW\t" + '-');
	return YYParser.AND_KW;
}

{OR_KW} {
	// System.out.println(yytext() + "\t" + "OR_KW\t" + '-');
	return YYParser.OR_KW;
}

{NOT_KW} {
	// System.out.println(yytext() + "\t" + "NOT_KW\t" + '-');
	return YYParser.NOT_KW;
}

{SEMICOLON_KW} {
	// System.out.println(yytext() + "\t" + "SEMICOLON_KW\t" + '-');
	return YYParser.SEMICOLON_KW;
}

{COLON_KW} {
	// System.out.println(yytext() + "\t" + "COLON_KW\t" + '-');
	return YYParser.COLON_KW;
}

{COMMA_KW} {
	// System.out.println(yytext() + "\t" + "COMMA_KW\t" + '-');
	return YYParser.COMMA_KW;
}

{SINGLE_QUOTE_KW} {
	// System.out.println(yytext() + "\t" + "SINGLE_QUOTE_KW\t" + '-');
	return YYParser.SINGLE_QUOTE_KW;
}
{UPTO_KW} {
	// System.out.println(yytext() + "\t" + "UPTO_KW\t" + '-');
	return YYParser.UPTO_KW;
}

{DOWNTO_KW} {
	// System.out.println(yytext() + "\t" + "DOWNTO_KW\t" + '-');
	return YYParser.DOWNTO_kW;
}

{ASSIGN_KW} {
	// System.out.println(yytext() + "\t" + "ASSIGN_KW\t" + '-');
	return YYParser.ASSIGN_KW;
}

{OPENPARENTHESIS_KW} {
	// System.out.println(yytext() + "\t" + "OPENPARENTHESIS_KW\t" + '-');
	return YYParser.OPENPARENTHESIS_KW;
}

{CLOSEPARENTHESIS_KW} {
	// System.out.println(yytext() + "\t" + "CLOSEPARENTHESIS_KW\t" + '-');
	return YYParser.CLOSEPARENTHESIS_KW;
}

{OPENBRACKET_KW} {
	// System.out.println(yytext() + "\t" + "OPENBRACKET_KW\t" + '-');
	return YYParser.OPENBRACKET_KW;
}

{CLOSEBRACKET_KW} {
	// System.out.println(yytext() + "\t" + "CLOSEBRACKET_KW\t" + '-');
	return YYParser.CLOSEBRACKET_KW;
}

{OPENACCOLADE_KW} {
	// System.out.println(yytext() + "\t" + "OPENACCOLADE_KW\t" + '-');
	return YYParser.OPENACCOLADE_KW;
}

{CLOSEACCOLADE_KW} {
	// System.out.println(yytext() + "\t" + "CLOSEACCOLADE_KW\t" + '-');
	return YYParser.CLOSEACCOLADE_KW;
}

{DOT_KW} {
	// System.out.println(yytext() + "\t" + "DOT_KW\t" + '-');
	return YYParser.DOT_KW;
}

{LT_KW} {
	// System.out.println(yytext() + "\t" + "LT_KW\t" + '-');
	return YYParser.LT_KW;
}

{GT_KW} {
	// System.out.println(yytext() + "\t" + "GT_KW\t" + '-');
	return YYParser.GT_KW;
}

{EQ_KW} {
	// System.out.println(yytext() + "\t" + "EQ_KW\t" + '-');
	return YYParser.EQ_KW;
}

{NEQ_KW} {
	// System.out.println(yytext() + "\t" + "NEQ_KW\t" + '-');
	return YYParser.NEQ_KW;
}

{GTE_KW} {
	// System.out.println(yytext() + "\t" + "GTE_KW\t" + '-');
	return YYParser.GTE_KW;
}

{LTE_KW} {
	// System.out.println(yytext() + "\t" + "LTE_KW\t" + '-');
	return YYParser.LTE_KW;
}

{ADD_KW} {
	// System.out.println(yytext() + "\t" + "ADD_KW\t" + '-');
	return YYParser.ADD_KW;
}

{SUB_KW} {
	// System.out.println(yytext() + "\t" + "SUB_KW\t" + '-');
	return YYParser.SUB_KW;
}
{MUL_KW} {
	// System.out.println(yytext() + "\t" + "MUL_KW\t" + '-');
	return YYParser.MUL_KW;
}

{DIV_KW} {
	// System.out.println(yytext() + "\t" + "DIV_KW\t" + '-');
	return YYParser.DIV_KW;
}

{MOD_KW} {
	// System.out.println(yytext() + "\t" + "MOD_KW\t" + '-');
	return YYParser.MOD_KW;
}

{SHARP_KW} {
	// System.out.println(yytext() + "\t" + "SHARP_KW\t" + '-');
	return YYParser.SHARP_KW;
}

{BOOLCONST} {
	// System.out.println(yytext() + "\t" + "BOOLCONST\t" + '-');
	return YYParser.BOOLCONST;
}

{CHARCONST} {
	// System.out.println(yytext() + "\t" + "CHARCONST\t" + '-');
	return YYParser.CHARCONST;
}

{REALCONST} {
	// System.out.println(yytext() + "\t" + "REALCONST\t" + '-');
	return YYParser.REALCONST;
}

{NUMCONST} {
	// System.out.println(yytext() + "\t" + "NUMCONST\t" + '-');
	return YYParser.NUMCONST;
}

{ID} {
	// System.out.println(yytext() + "\t" + "ID\t" + "Symbol Table Entry");
	return YYParser.ID;
}

"\s"|"\n"|"\r"|"\t" {
}

. {
}