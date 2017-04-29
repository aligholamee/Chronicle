# Chronicle
![alt tag](http://uupload.ir/files/xx1k_chronicle_project.png)

Learn how to create a new programming language and write your own compiler.

# Learning Phases
In this project, I'll show you how to build a new programming language with any desired grammer. This project is a phasic project which means it is divided into some parts. In the first part I'll cover Lexical Analyser creating and other phases will be described more in the future.

## Starting Point
In this section I'll provide a quick tutorial on how a grammer is written and how everything goes together to build a compiler.

## How a compiler works?
The procedure that takes place in order to build a executable file from a written program in an specific programming language is provided here:
![alt tag](http://uupload.ir/files/8oi6_target.png)
In the first phase, I'll Implement a Lexical Analyser. Building a lexical analyser which is fully executable can take weeks to complete, so there are some softwares that provide some GUI for us to simply declare the desired grammer for the language we are going to build, and then passing this grammer to that software, and finally the output of that software is that Lexical Analyser.
We can use any programming language to write our grammer code and pass it to that software. But the most common programming languages are Java and C. The software which is used for each is JFlex and Flex respectively. You can download Flex or JFlex from the directories above.

## Phase 1 - Lexical Analyzer
The very first code we'll work on is PH1_Lexical_Analyzer which it's name stands for "Phase 1 - Lexical Analyzer". This code will consist of three parts, or it's better to say that the JFlex which is reading our .lex code (written in java language) will look for these three parts and they must exist! Each of these parts are separated from each other by "%%" (Double Percentage Sign). The first part is the "User Code" part which we'll discuss later. The second part is the declaration of our grammer and the third part is the rules for the grammer we have written and shows "What is being done" by each expression.

## Notes to Consider
In the first phase, the only job we need to get done is specifying *KEYWORDS* and *TOKENS* and define some rules to do something if any of these keywords or tokens are met. Specification of these keywords and tokens is in the *DECLARATION* entry and the rules are in the *RULES* entry.
Example:
		ID = [a-zA-Z]+

The above code will create the ID token.

## Phase 2 - Syntax Analyzer
In this section, we'll create a syntax analyzer in order to be able to match the input with the grammar. The matching process starts where the Syntax Analyzer builds a table called **Shift-Reduce**. In this table, the tokens and everything which is recognized in the previous section(**Lexical Analyser**) will be included. We also need to include the full grammar of our language here. What makes this part a bit tricky is that

## What is the .yac source file and what are the contents?
The .yac file is the main source program used by **YACC** tool to create a syntax analyzer. This file will be sent to the **YACC** tool and will be integrated with the **main program** and the **syntax analyser** and will produce the whole **Lexical-Syntax-Analyser** together.

## Phase 3 - Intermediate Code Generation
This is the last main section of this project. The more we get closer to the end, the more we need to focus on more important things. In this section we have to generate the code for the machine in order to convert it into the machine code.
A source code can directly be translated into its target machine code, then why at all we need to translate the source code into an intermediate code which is then translated to its target code?
