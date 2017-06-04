package com.ll.studies.questions;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


public class QuestionH {
    /**
    H. Há um total de n cursos que você tem que tomar, etiquetado a partir de 0
       A n - 1. Alguns cursos podem ter pré-requisitos, por exemplo para
       Curso 0 você tem que primeiro tomar o curso 1, que é expresso como um
       Par: [0,1]. Dado o número total de cursos e uma lista de
       Pré-requisito, é possível concluir todos os cursos?
       Por exemplo, dado 2 e [[1,0]], há um total de 2 cursos para
       levar. Para tomar o curso 1, você deve ter terminado o curso 0. Portanto, é
       possível.
       Para outro exemplo, dado 2 e [[1,0], [0,1]], há um total de 2
       Cursos a tomar. Para tomar o curso 1 você deve ter terminado o curso 0,
       E para tomar o curso 0 você também deve ter terminado o curso 1. Portanto, é
       impossível.
     */
    public static void question(int n, List<Point> prerequisites) {
        StringBuilder builder = new StringBuilder();
        for (Point prerequisite : prerequisites) {
            builder.append(String.format("[%d, %d], ", prerequisite.x, prerequisite.y));
        }
        System.out.println(String.format("Input: %s", builder.toString()));

        if (n < 2) {
            System.out.println("It is possible!");
            return;
        }

        // Structure used in dfs
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Boolean> markMap = new HashMap();
        HashMap<Integer, List<Integer>> dependenciesMap = new HashMap();
        List<Integer> roots = new ArrayList();

        // List of index of all roots, it will be used to start the dfs
        for (int i = 0; i < n; i++) {
            roots.add(new Integer(i));
        }

        while (!roots.isEmpty()) {
            // Initialize pre requisites
            for (Point prerequisite : prerequisites) {
                List<Integer> node = dependenciesMap.get(prerequisite.x);
                if (node == null) {
                    node = new ArrayList();
                }
                node.add(prerequisite.y);
                dependenciesMap.put(prerequisite.x, node);
            }

            Integer node = roots.get(0);

            while (node != null) {
                stack.push(node);
                roots.remove(node);
                markMap.put(node, true);

                List<Integer> dependencies = dependenciesMap.get(node);
                if (dependencies == null || dependencies.isEmpty()) {
                    markMap.remove(stack.pop());
                    if (stack.isEmpty()) {
                        break;
                    } else {
                        node = stack.pop();
                    }
                } else {
                    Integer parentNode = node;
                    node = dependencies.remove(0);
                    if (markMap.containsKey(node)) {
                        System.out.println("It is NOT possible!");
                        return;
                    } else {
                        dependenciesMap.put(parentNode, dependencies);
                    }
                }
            }
        }

        System.out.println("It is possible!");
    }
}