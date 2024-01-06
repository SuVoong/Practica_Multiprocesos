package ej4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio4_01 {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);

		BufferedReader br = new BufferedReader(isr);
		
//		String prueba = "PSP 3 8 2 JavaSript 9 5 4";
		try {
			String str = br.readLine();
			ArrayList<String> arrayL = new ArrayList<String>();
			String[] array = str.split(" ");
			int total = 0;
			int aprobado = 0;
			int media = 0;
//			String asigantura = "";

			for (String string : array) {
				arrayL.add(string);
			}
			for (Iterator<String> iterator = arrayL.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				if (string.matches("[0-9]")) {
					int num = Integer.valueOf(string);
					media = num + media;
					total++;
					if (num >= 5) {
						aprobado++;
					}
					if (!iterator.hasNext()) {
						media = media / total;
						System.out.println("Han aprobado " + aprobado + " alumnos");
						System.out.println("La media es " + media);
					}
				} else {
//					if (asigantura.matches("[a-zA-Z]") && !string.matches("[0-9]")) {
//						asigantura = asigantura + " " + string;
//					} else 
					if (!string.matches("[0-9]") && media != 0) {
//						System.out.println("En la asignatura " + string);
						media = media / total;
						System.out.println("Han aprobado " + aprobado + " alumnos");
						System.out.println("La media es " + media);
					}
					System.out.println("En la asignatura " + string);
//					asigantura = string;
					total = 0;
					aprobado = 0;
					media = 0;
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
