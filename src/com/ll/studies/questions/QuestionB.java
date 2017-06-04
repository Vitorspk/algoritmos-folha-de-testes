package com.ll.studies.questions;


public class QuestionB {
	/**
	 * 	Escreva uma função que recebe uma coleção de strings e
		Retorna a seqüência que é seu prefixo comum mais longo. Por exemplo,
		Dado [ "apple", "ape", "damasco"], retornar "ap".
	 */
	public static void question(String... words) {
		System.out.print("Input: [");
		for (String word : words) {
			System.out.print(word + ", ");
		}
		System.out.println("]");

		switch (words.length) {
		case 0:
			System.out.println(String.format("Don't have longest common prefix."));
			break;
		case 1:
			System.out.println(String.format("Longest common prefix: %s", words[0]));
			break;
		default:
			int prefixIndex = 0;
			char prefix;
			String firstWord = words[0];

			for (int i = 0; i < firstWord.length(); i++) {
				if (prefixIndex < firstWord.length()) {
					prefix = firstWord.charAt(prefixIndex);
				} else {
					if (prefixIndex == 0) {
						System.out.println(String.format("Don't have longest common prefix."));
					} else {
						System.out.println(String.format("Longest common prefix: %s", firstWord.substring(0, prefixIndex)));
					}
					return;
				}

				for (int j = 1; j < words.length; j++) {
					String word = words[j];
					if (prefixIndex >= word.length() || word.charAt(prefixIndex) != prefix) {
						if (prefixIndex == 0) {
							System.out.println(String.format("Don't have longest common prefix."));
						} else {
							System.out.println(String.format("Longest common prefix: %s", firstWord.substring(0, prefixIndex)));
						}
						return;
					}
				}
				prefixIndex++;
			}
		}
	}
}
