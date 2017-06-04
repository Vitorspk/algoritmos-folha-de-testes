package com.ll.studies.questions;

import java.util.*;


public class QuestionG {
    /**
     * G.
     * G.1. Escreva uma função que toma uma string e retorna true se o parêntese nela estiver equilibrado:
     * Exemplo:
     * Equilibrado:
     * ()
     * (())
     * ()()
     * (())()
     * Desequilibrado:
     * (()
     * )(
     * ())(
     * G.2. Escreva uma função que leva uma cadeia de tipos de chaves múltiplas e retorna true se elas estiverem equilibradas e
     * devidamente aninhado
     * Quatro tipos de chaves para suportar:
     * () {} <> []
     * Exemplo:
     * Equilibrado:
     * (<>)
     * ([]{})<>
     * Desequilibrado:
     * [>
     * (<)>
     * G.3. Escreva uma função que imprime todas as seqüências possíveis de parênteses balanceados para um determinado tamanho
     */
    public static void question() {
        System.out.println("----- G1 -----");
        String parenthesis = "()()()()()(())";
        System.out.println(String.format("Input: %s", parenthesis));
        System.out.println("Balanced: " + question1(parenthesis));

        parenthesis = "()()()()))))((((";
        System.out.println(String.format("Input: %s", parenthesis));
        System.out.println("Balanced: " + question1(parenthesis));

        System.out.println("----- G2 -----");

        parenthesis = "(<>)";
        System.out.println(String.format("Input: %s", parenthesis));
        System.out.println("Balanced: " + question2(parenthesis));

        parenthesis = "([]{})<>";
        System.out.println(String.format("Input: %s", parenthesis));
        System.out.println("Balanced: " + question2(parenthesis));

        parenthesis = "[>";
        System.out.println(String.format("Input: %s", parenthesis));
        System.out.println("Balanced: " + question2(parenthesis));

        parenthesis = "(<)>";
        System.out.println(String.format("Input: %s", parenthesis));
        System.out.println("Balanced: " + question2(parenthesis));

        System.out.println("----- G3 -----");
        question3();

    }

    public static boolean question1(String parenthesis) {
        int balance = 0;
        for (int i = 0; i < parenthesis.length(); i++) {
            switch (parenthesis.charAt(i)) {
                case '(':
                    balance++;
                    break;
                case ')':
                    balance--;
                    break;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    public static boolean question2(String parenthesis) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < parenthesis.length(); i++) {
            char character = parenthesis.charAt(i);
            switch (character) {
                case '(':
                case '{':
                case '<':
                case '[':
                    stack.push(character);
                    break;
                case ')':
                    if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case '>':
                    if (stack.pop() != '<') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public static void question3() {
        printBalancedParenthesis(5);
    }

    public static HashMap<String, Boolean> marked = new HashMap();

    public static List<String> printBalancedParenthesis(int size) {
        if (size == 0) {
            System.out.println("empty");
            return new ArrayList();
        } else if (size == 1) {
            System.out.println("empty");
            System.out.println("()");
            return Arrays.asList("()");
        }
        List<String> parenthesisList = printBalancedParenthesis(size - 1);
        List<String> results = new ArrayList();

        for (String parenthesis : parenthesisList) {
            String[] keys = new String[]{String.format("()%s", parenthesis), String.format("(%s)", parenthesis), String.format("%s()", parenthesis)};
            for (String key : keys) {
                if (!marked.containsKey(key)) {
                    System.out.println(key);
                    marked.put(key, true);
                    results.add(key);
                }
            }
        }

        return results;
    }
}
