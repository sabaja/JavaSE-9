package com.miscellaneus;

public class AlgoritmoDiBergerCalendario {

	public static void main(String[] args) {
		String[] squadre = {"Pii","ddd","rrr","santo","5asdfa","6","7", "ciao"};
		
		algoritmoDiBerger(squadre);

	}

	public static void algoritmoDiBerger(String[] squadre) {

		int numero_squadre = squadre.length;
		int giornate = numero_squadre - 1;

		/* crea gli array per le due liste in casa e fuori */
		String[] casa = new String[numero_squadre / 2];
		String[] trasferta = new String[numero_squadre / 2];

		for (int i = 0; i < numero_squadre / 2; i++) {
			casa[i] = squadre[i];
			trasferta[i] = squadre[numero_squadre - 1 - i];
		}

		for (int i = 0; i < giornate; i++) {
			/* stampa le partite di questa giornata */
			System.out.printf("\n%d^ Giornata\n", i + 1);

			/* alterna le partite in casa e fuori */
			if (i % 2 == 0) {
				for (int j = 0; j < numero_squadre / 2; j++)
					System.out.printf("%d  %s - %s\n", j + 1, trasferta[j], casa[j]);
			} else {
				for (int j = 0; j < numero_squadre / 2; j++)
					System.out.printf("%d  %s - %s\n", j + 1, casa[j], trasferta[j]);
			}

			// Ruota in gli elementi delle liste, tenendo fisso il primo
			// elemento
			// Salva l'elemento fisso
			String pivot = casa[0];

			/*
			 * sposta in avanti gli elementi di "trasferta" inserendo all'inizio
			 * l'elemento casa[1] e salva l'elemento uscente in "riporto"
			 */

			String riporto = trasferta[trasferta.length - 1];
			trasferta = shiftRight(trasferta, casa[1]);

			/*
			 * sposta a sinistra gli elementi di "casa" inserendo all'ultimo
			 * posto l'elemento "riporto"
			 */

			casa = shiftLeft(casa, riporto);

			// ripristina l'elemento fisso
			casa[0] = pivot;
		}
	}

	private static String[] shiftLeft(String[] data, String add) {
		String[] temp = new String[data.length];
		for (int i = 0; i < data.length - 1; i++) {
			temp[i] = data[i + 1];
		}
		temp[data.length - 1] = add;
		return temp;
	}

	private static String[] shiftRight(String[] data, String add) {
		String[] temp = new String[data.length];
		for (int i = 1; i < data.length; i++) {
			temp[i] = data[i - 1];
		}
		temp[0] = add;
		return temp;
	}

}
