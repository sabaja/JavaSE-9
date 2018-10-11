package com.collections.streamAPI;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class ContaParole_StreamParallelo {

	private static final String PATH = "/home/sabaja/Scrivania/Dev-space/Java/Manuale_JAVA_8_9/Java8/Appendici/appendici/modulo_16/esempi/la-divina-commedia.txt";
	private static String wordToSearch = "";

	public static void main(String[] args) throws IOException {
		wordToSearch = getWordToSearch();
		while (!"ESCI".equals(wordToSearch)) {
			List<String> words = getWordsList();

			long startTime1 = System.currentTimeMillis();
			long count = 0;
			for (String word : words) {
				if (word.equals(wordToSearch)) {
					count++;
				}
			}
			System.out.printf("Tempo ciclo foreach    = \t%s  millisecondi \tcount = %s \n",
					(System.currentTimeMillis() - startTime1), count);

			count = 0;
			long startTime2 = System.currentTimeMillis();
			Iterator<String> iterator = words.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().equals(wordToSearch)) {
					count++;
				}
			}
			System.out.printf("Tempo oggetto Iterator = \t%s millisecondi \t\tcount = %s \n",
					(System.currentTimeMillis() - startTime2), count);

			long startTime3 = System.currentTimeMillis();
			int[] countArray = { 0 };
			words.forEach(word -> {
				if (word.equals(wordToSearch))
					countArray[0]++;
			});
			System.out.printf("Tempo metodo forEach() = \t%s millisecondi \tcount = %s \n",
					(System.currentTimeMillis() - startTime3), count);

			long startTime4 = System.currentTimeMillis();
			count = words.stream().filter(word -> word.equals(wordToSearch)).count();
			System.out.printf("Tempo stream ordinario = \t%s millisecondi \tcount = %s \n",
					(System.currentTimeMillis() - startTime4), count);

			long startTime5 = System.currentTimeMillis();
			count = words.parallelStream().filter(word -> word.equals(wordToSearch)).count();
			System.out.printf("Tempo stream parallelo = \t%s millisecondi \tcount = %s \n",
					(System.currentTimeMillis() - startTime5), count);
			wordToSearch = getWordToSearch();
		}
		System.out.println("Ciao!");
	}

	public static String getWordToSearch() {
		System.out.println("Scrivi la parola da ricercare (scrivi ESCI per uscire): ");
		Scanner scanner = new Scanner(System.in);
		String wordToSearch = scanner.nextLine();
		return wordToSearch;
	}

	public static List<String> getWordsList() throws IOException {
		String contents = new String(Files.readAllBytes(Paths.get(PATH)), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split(" "));
		return words;
	}
}