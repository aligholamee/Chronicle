

%%

/* Tokens */
LETTER = [a-zA-Z]
NONZERO_DIGIT = [1-9]
DIGIT = "0"|{NONZERO_DIGIT}
NUMCONST = "#"{DIGIT}+


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

/* Utility Keywords */
FOR_KW = (for)
RETURN_KW = (return)
EXIT_KW = (exit)
UPTO_KW = (upto)
DOWNTO_KW = (downto)




%%
