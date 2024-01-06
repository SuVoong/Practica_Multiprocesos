package ej4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);

		BufferedReader br = new BufferedReader(isr);
		try {
			double total = 0;
			int aprobado = 0;
			double media = 0;
			while (br.ready()) {
				int num = Integer.valueOf(br.readLine());
				media = num + media;
				total++;
				if (num >= 5) {
					aprobado++;
				}
			}
			media = media / total;
			System.out.println("Han aprobado " + aprobado + " alumnos");
			System.out.println("La media es " + media);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
