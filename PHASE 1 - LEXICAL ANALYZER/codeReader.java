public static void main(String args[])
{
		FileReader fr = null;
        String input = ".\\files\\Code.shl";
        try {
            fr = new FileReader(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Lexeme\tToken\tAttribute");
        Yylex yylex = new Yylex(fr);
        try {
            yylex.yylex();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}