package ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Scanner sc = new Scanner(System.in);
		try {
			int suma = 0;

			String str = br.readLine();
			String st1 = "";
			char arrayC[] = str.toCharArray();
			for (char c : arrayC) {
				String st = String.valueOf(c);
				if(st.contains("*")){
					System.out.println("Suma: " + suma);
					System.exit(0);
				}
				else if (st.contains(" ")) {
					int n = Integer.valueOf(st1);
					System.out.println("Escrito " + n);
					suma += n;
					st1 = "";
				} else {
					st1 += st;
				}
			}
			System.out.println("Suma: " + suma);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		sc.close();
		isr.close();
	}
}
