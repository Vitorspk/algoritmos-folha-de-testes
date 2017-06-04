package com.ll.studies.questions;

import java.util.HashMap;

public class QuestionD {
	/**
      D. Eu sou um aspirante a supervilão, então eu quero invadir sua casa para seqüestrar seu cachorro! 
      Quero deixar uma nota de resgate e, como não quero que você reconheça minha caligrafia,
      planejo cortar cartas de uma revista e colá-las em uma folha de papel.
      A questão é, dado o texto da nota de resgate, eo texto da revista posso fazer a mensagem desejada com as letras disponíveis?
	 */
	public static void question(String magazine, String note) {
		magazine = magazine.replace(" ", "").toLowerCase();
		note = note.replace(" ", "").toLowerCase();
		HashMap<Character, Integer> cache = new HashMap();
		char mletter, nletter;
		Integer value;
		int index = 0;
		int nSize = note.length();
		int mSize = magazine.length();

		for (int i = 0; i < nSize; i++) {
			nletter = note.charAt(i);
			if (cache.containsKey(nletter)) {
				value = cache.get(nletter) - 1;
				if (value == 0) {
					cache.remove(nletter);
				} else if (value > 0) {
					cache.put(nletter, value);
				}
			} else {
				if (index == mSize) {
					System.out.println("NOT available!");
					return;
				}
				while (index < mSize) {
					mletter = magazine.charAt(index++);
					if (mletter != nletter) {
						if (cache.containsKey(mletter)) {
							cache.put(mletter, cache.get(mletter) + 1);
						} else {
							cache.put(mletter, 1);
						}
						if (index == mSize) {
							System.out.println("NOT available!");
							return;
						}
					} else {
						break;
					}
				}
			}
		}
		System.out.println("Available!");
	}

	// Another solution
	public static void question1(String magazine, String note) {
		magazine = magazine.replace(" ", "").toLowerCase();
		note = note.replace(" ", "").toLowerCase();
		HashMap<Character, Integer> cache = new HashMap();
		char key;
		int value;

		for (int i = 0; i < magazine.length(); i++) {
			key = magazine.charAt(i);
			if (cache.containsKey(key)) {
				cache.put(key, cache.get(key) + 1);
			} else {
				cache.put(key, 1);
			}
		}

		for (int i = 0; i < note.length(); i++) {
			key = note.charAt(i);
			if (cache.containsKey(key)) {
				value = cache.get(key);
				if (value == 1) {
					cache.remove(key);
				} else {
					cache.put(key, value - 1);
				}
			} else {
				System.out.println("NOT available!");
				return;
			}
		}

		System.out.println("Available!");
	}
}
