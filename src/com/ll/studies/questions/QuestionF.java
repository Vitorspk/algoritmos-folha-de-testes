package com.ll.studies.questions;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class QuestionF {
    /**
      Uma estrada c�clica cont�m n postos de gasolina colocados em v�rios pontos
������o percurso. Cada esta��o tem algum n�mero de gal�es de g�s dispon�vel.
������Algumas esta��es t�m mais g�s do que o necess�rio para chegar ao pr�ximo
������Esta��o, mas outras esta��es n�o t�m g�s suficiente para
������pr�xima esta��o. No entanto, a quantidade total de g�s nas esta��es n �
������Exatamente o suficiente para transportar um carro ao redor da rota exatamente uma vez. Seu
������Tarefa: Encontrar uma esta��o em que um driver pode come�ar com um tanque vazio
������E dirigir todo o caminho ao redor da estrada sem nunca ficar sem
������g�s. A entrada para o seu algoritmo � uma lista de n inteiros, um para cada
������esta��o. O n�mero inteiro indica o n�mero de quil�metros que um carro pode
������Viajar no g�s dispon�vel na esta��o i-�simo. Para simplificar, vamos
������Suponha que as esta��es est�o a 10 milhas de dist�ncia. Isto significa que a soma de
������Os n inteiros ser�o exatamente 10n.A sa�da de seu algoritmo
������Deve ser o �ndice da esta��o em que o condutor deve
������Begin.Note: Tente obter um algoritmo com o (n) complexidade
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