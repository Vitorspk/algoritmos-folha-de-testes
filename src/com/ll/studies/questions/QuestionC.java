package com.ll.studies.questions;

public class QuestionC {
    /**
     * C.
     * Dada uma matriz de inteiros A, encontre três índices x, y, z tais que
     * x < y < z and A[x] < A[y] < A[z].
     * Por Exemplo dado
     * A = {40, 30, 31, 20, 18, 14, 16, 8, 19}
     * Entao
     * 3 números crescentes são:
	 *	{14, 16, 19}
	 *	Assim os 3 índices são:
	 * x=5
     * y=6
     * z=8
     * Exemplo: A = {6, 2, 7, 3, 1, 5}, solution is {1, 3, 5}
     */
    public static void question(int... numbers) {
        System.out.print("Input: [");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }
        System.out.println("]");
        if (numbers.length == 0) {
            System.out.println("Empty array!");
            return;
        }

        int[] indexes = new int[3];
        int current = 0;
        int temp = -1;

        indexes[0] = 0;

        for (int i = 1; i < numbers.length; i++) {
            switch (current) {
                case 0:
                    if (numbers[i] < numbers[indexes[0]]) {
                        indexes[0] = i;
                    } else if (numbers[i] > numbers[indexes[0]]) {
                        indexes[++current] = i;
                    }
                    break;
                case 1:
                    if (numbers[i] < numbers[indexes[0]]) {
                        if (temp != -1) {
                            if (numbers[i] > numbers[temp]) {
                                indexes[0] = temp;
                                indexes[1] = i;
                                temp = -1;
                            } else if (numbers[i] < numbers[temp]) {
                                temp = i;
                            }
                        }
                    } else if (numbers[i] > numbers[indexes[0]] && numbers[i] < numbers[indexes[1]]) {
                        indexes[current] = i;
                    } else if (numbers[i] > numbers[indexes[1]]) {
                        indexes[++current] = i;
                        System.out.println(String.format("R: {%d, %d, %d}", indexes[0], indexes[1], indexes[2]));
                        return;
                    }

                    break;
            }
        }
        System.out.println("R: Don't have solution!");
    }
    public static void main(String args[]){
    	QuestionC c = new QuestionC();
    	c.question(6, 2, 7, 3, 1, 5);
    }
}
