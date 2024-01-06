package ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Integer n;
		String p = br.readLine();
		try {
			n = Integer.parseInt(p);
			if (n == 0) {
				System.out.println("Has escrito 0");
				System.exit(-4);
			} else if (n > 0) {
				System.out.println("Has escrito un entero positivo.");
				System.exit(-3);
			} else {
				System.out.println("El entero debe ser positivo.");
				System.exit(0);
			}
		} catch (NumberFormatException e2) {
			if (p.isEmpty()) {
				System.out.println("Esta vacio.");
				System.exit(-1);

			} else {
				System.out.println("No has escrito un entero.");
				System.exit(-2);
			}

		}
		isr.close();
	}
}
