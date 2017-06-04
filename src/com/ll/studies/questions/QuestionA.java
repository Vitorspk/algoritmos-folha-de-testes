package com.ll.studies.questions;

public class QuestionA {
	/**
		Dada uma imagem de raio-x dos dentes de um paciente, representada como um bitmap em escala de
		Cavidades que o paciente tem. 
		Uma cavidade é definida como uma região contígua onde todos os pixels são mais escuros do que Algum valor de limiar fixo.
		A entrada é uma matriz 2D de inteiros. 
		Dois pixels no bitmap são adjacentes se um é imediatamente acima, abaixo,Para a esquerda ou para a direita da outra 
		(isto é, não consideramos pixels que tocam diagonalmente para serem contíguos).
	 */
	public static void question() {
		int[][] matrix = new int[][]{
			new int[]{1, 0, 1, 1, 1, 0, 1, 1, 1, 0},
			new int[]{1, 0, 1, 1, 0, 0, 0, 1, 1, 0},
			new int[]{1, 1, 0, 0, 0, 1, 1, 0, 1, 1},
			new int[]{1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
			new int[]{0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
			new int[]{1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
			new int[]{0, 0, 0, 1, 0, 1, 0, 0, 1, 1},
			new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0},
			new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 1},
			new int[]{1, 0, 0, 1, 1, 0, 1, 1, 0, 1}
		};
		print(matrix, 10, 10);
		int cavities = solution(matrix, 10, 10);
		System.out.println("Number of cavities: " + cavities);
	}

	public static int solution(int[][] matrix, int rows, int columns) {
		int cavities = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] == 1) {
					markAdjacents(matrix, i, j, rows, columns);
					cavities++;
				}
			}
		}
		return cavities;
	}

	public static void markAdjacents(int[][] matrix, int i, int j, int rows, int columns) {
		int left = i - 1;
		int right = i + 1;
		int top = j - 1;
		int bottom = j + 1;
		matrix[i][j] = -1;

		if (left >= 0 && left < columns && matrix[left][j] == 1) {
			markAdjacents(matrix, left, j, rows, columns);
		}

		if (right >= 0 && right < columns && matrix[right][j] == 1) {
			markAdjacents(matrix, right, j, rows, columns);
		}

		if (top >= 0 && top < rows && matrix[i][top] == 1) {
			markAdjacents(matrix, i, top, rows, columns);
		}

		if (bottom >= 0 && bottom < rows && matrix[i][bottom] == 1) {
			markAdjacents(matrix, i, bottom, rows, columns);
		}
	}

	public static void print(int[][] matrix, int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(String.format("%d ", matrix[i][j]));
			}
			System.out.print("\n");
		}
	}

}

