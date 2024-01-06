package ut2II;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamarEjercicio3 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe un texto: ");
		String resp = sc.nextLine();

		File f = new File(
				"D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Ejercicios_Practica_Multiproceso_II\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "ut2II.Ejercicio3");

		pb.directory(f);
		// Es ejecuta.
		Process p = pb.start();

		resp += "\n";
		OutputStream ops = p.getOutputStream();
		ops.write(resp.getBytes());
		ops.flush();

		int exitValor = -1;

		try {
			exitValor = p.waitFor();
			System.out.println("Valor de Salida: "+exitValor);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
