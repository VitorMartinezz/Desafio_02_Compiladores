package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static final String colorRESET = "\u001B[0m";
    public static final String colorRED = "\u001B[31m";
    public static final String colorGREEN = "\u001B[32m";

    public static void main(String[] args) {
        Boolean isRunning = true;
        while(isRunning) {
            System.out.println("0 - Sair");
            System.out.println("1 - Validar palavra");

            Scanner scMenu = new Scanner(System.in);
            int isExit = scMenu.nextInt();
            if(isExit == 0)
                System.exit(0);

            System.out.println("Digite a palavra para validação");
            System.out.println("Alfabeto da linguagem: <{[( )]}>");

            Scanner sc = new Scanner(System.in);
            String value = sc.nextLine();
            Stack<Character> stack = new Stack<Character>();

            for (char item : value.toCharArray()) {
                if (item == '[' || item == '{' || item == '(' || item == '<') {
                    stack.push(item);
                } else if (item == ']' || item == '}' || item == ')' || item == '>') {
                    if(stack.empty()){
                        stack.push(item); //Adiciona apenas para passar como invalido na validação final
                        break;
                    }
                    if (stack.peek() == '[' && item == ']') {
                        stack.pop();
                    } else if (stack.peek() == '{' && item == '}') {
                        stack.pop();
                    } else if (stack.peek() == '(' && item == ')') {
                        stack.pop();
                    } else if (stack.peek() == '<' && item == '>') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
            if (stack.empty())
                System.out.println(value+" --> "+colorGREEN+"Palavra válida"+colorRESET);
            else
                System.out.println(value+" --> "+colorRED+"Palavra inválida"+colorRESET);
        }
    }
}

