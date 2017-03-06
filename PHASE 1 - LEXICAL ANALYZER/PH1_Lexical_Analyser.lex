

%%
/* Declaration Section */
/* Tokens */
LETTER = [a-zA-Z]
NONZERO_DIGIT = [1-9]
DIGIT = "0"|{NONZERO_DIGIT}
NUMCONST = "#"{DIGIT}+
REALCONST = "#"{DIGIT}+({"\."}{DIGIT})?
CHARCONST = {LETTER}+
BOOLCONST = (true)|(false)

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

/* Arithmetic Operators */
ADD_KW = [+]
DIF_KW = [-]
MUL_KW = [*]
DIV_KW = [/]
MOD_KW = [%]

%%
/* Rules Section */


