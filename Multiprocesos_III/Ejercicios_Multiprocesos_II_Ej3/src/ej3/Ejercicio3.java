package ej3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ejercicio3 {
	public static void main(String [] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			String str = br.readLine();
			char arrayC [] = str.toCharArray();
			boolean esPalindromo = true;
			for (int i = 0; i < (str.length()/2); i++) {
				if(!String.valueOf(arrayC[i]).contentEquals(String.valueOf(arrayC[(str.length()-i)-1]))) {
					esPalindromo = false;
				}
			}
			if(esPalindromo == true) {
				System.out.print("Es palíndromo.");
			} else {
				System.out.print("NO es palíndromo.");
			}
			System.exit(0);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
