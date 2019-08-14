package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean isKeyword;

        System.out.println("Enter a word to see if it is a Java Keyword");
        String word = input.nextLine();

        switch (word) {
            case "char":
                isKeyword = true;
               break;
            case "abstract":
                isKeyword = true;
                break;
            case "double":
                isKeyword = true;
                break;
            case "for":
                isKeyword = true;
                break;
            case "int":
                isKeyword = true;
                break;
            case "package":
                isKeyword = true;
                break;
            case "static":
                isKeyword = true;
                break;
            case "throws":
                isKeyword = true;
                break;
            case "assert":
                isKeyword = true;
                break;
            case "boolean":
                isKeyword = true;
                break;
            case "class":
                isKeyword = true;
                break;
            case "else":
                isKeyword = true;
                break;
            case "goto":
                isKeyword = true;
                break;
            case "interface":
                isKeyword = true;
                break;
            case "private":
                isKeyword = true;
                break;
            case "super":
                isKeyword = true;
                break;
            case "transient":
                isKeyword = true;
                break;
            case "enum":
                isKeyword = true;
                break;
            case "break":
                isKeyword = true;
                break;
            case "const":
                isKeyword = true;
                break;
            case "extends":
                isKeyword = true;
                break;
            case "if":
                isKeyword = true;
                break;
            case "long":
                isKeyword = true;
                break;
            case "protected":
                isKeyword = true;
                break;
            case "switch":
                isKeyword = true;
                break;
            case "try":
                isKeyword = true;
                break;
            case "strictfp":
                isKeyword = true;
                break;
            case "byte":
                isKeyword = true;
                break;
            case "continue":
                isKeyword = true;
                break;
            case "final":
                isKeyword = true;
                break;
            case "implements":
                isKeyword = true;
                break;
            case "native":
                isKeyword = true;
                break;
            case "public":
                isKeyword = true;
                break;
            case "synchronized":
                isKeyword = true;
                break;
            case "void":
                isKeyword = true;
                break;
            case "case":
                isKeyword = true;
                break;
            case "default":
                isKeyword = true;
                break;
            case "finally":
                isKeyword = true;
                break;
            case "import":
                isKeyword = true;
                break;
            case "new":
                isKeyword = true;
                break;
            case "return":
                isKeyword = true;
                break;
            case "this":
                isKeyword = true;
                break;
            case "volatile":
                isKeyword = true;
                break;
            case "catch":
                isKeyword = true;
                break;
            case "do":
                isKeyword = true;
                break;
            case "float":
                isKeyword = true;
                break;
            case "instanceof":
                isKeyword = true;
                break;
            case "null":
                isKeyword = true;
                break;
            case "short":
                isKeyword = true;
                break;
            case "throw":
                isKeyword = true;
                break;
            case "while":
                isKeyword = true;
                break;
            default:
                isKeyword = false;
        }

        if (isKeyword) {
            System.out.println("This word is a java keyword");
        } else {
            System.out.println("This word is not a java keyword");
        }
    }
}
