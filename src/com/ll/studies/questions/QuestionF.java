package com.ll.studies.questions;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class QuestionF {
    /**
      Uma estrada cíclica contém n postos de gasolina colocados em vários pontos
      o percurso. Cada estação tem algum número de galões de gás disponível.
      Algumas estações têm mais gás do que o necessário para chegar ao próximo
      Estação, mas outras estações não têm gás suficiente para
      próxima estação. No entanto, a quantidade total de gás nas estações n é
      Exatamente o suficiente para transportar um carro ao redor da rota exatamente uma vez. Seu
      Tarefa: Encontrar uma estação em que um driver pode começar com um tanque vazio
      E dirigir todo o caminho ao redor da estrada sem nunca ficar sem
      gás. A entrada para o seu algoritmo é uma lista de n inteiros, um para cada
      estação. O número inteiro indica o número de quilômetros que um carro pode
      Viajar no gás disponível na estação i-ésimo. Para simplificar, vamos
      Suponha que as estações estão a 10 milhas de distância. Isto significa que a soma de
      Os n inteiros serão exatamente 10n.A saída de seu algoritmo
      Deve ser o índice da estação em que o condutor deve
      Begin.Note: Tente obter um algoritmo com o (n) complexidade
     */
    public static void question(int range, int... values) {
        System.out.print("Input: ");
        for (int value : values) {
            System.out.print(String.format("%d, ", value));
        }
        System.out.println(String.format("\nRange: %d", range));

        int amount = 0;
        for (int i = 0; i < values.length; i++) {
            amount += values[i] - range;
            if (amount < 0) {
                System.out.println(String.format("Starting by: %d", i + 1));
                return;
            }
        }
        System.out.println(String.format("Starting by: everywhere"));
    }
}