package ut2II;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamarEjercicio2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String resp = "";
		String resp3 = "";
		File f = new File(
				"D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Ejercicios_Practica_Multiproceso_II\\bin");
		
		ProcessBuilder pb = new ProcessBuilder("java", "ut2II.Ejercicio2");

		pb.directory(f);
		
		Process p = pb.start();
		
		while (!resp3.contains("*")) {
			System.out.println("Dime un número: ");
			resp3 = sc.nextLine();
			resp += (resp3 + " ");
		}
		
		
		resp += "\n";
		OutputStream ops = p.getOutputStream();
		ops.write(resp.getBytes());
		ops.flush();

		int exitValor = -1;
		try {
			exitValor = p.waitFor();
			System.out.println("Valor de salida: " + exitValor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (exitValor == 0) {
			escribir(p);
		}
		sc.close();
	}
	public static void escribir(Process p) {
		try {
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
