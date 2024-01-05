package ut2II;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamarEjercicio1 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe un número entero positivo:");
		String resp = sc.nextLine();

		File directorio = new File(
				"D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Ejercicios_Practica_Multiproceso_II\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "ut2II.Ejercicio1");

		pb.directory(directorio);

		Process p = pb.start();

		resp = resp + "\n";
		OutputStream os = p.getOutputStream();
		os.write(resp.getBytes());
		os.flush();

		int exitVal = -1;

		try {
			exitVal = p.waitFor();
			System.out.println("Valor de salida: " + exitVal);
		} catch (Exception e) {
			e.printStackTrace();
		}

		escribir(p);

		sc.close();
	}

	public static void escribir(Process p) {
		try {
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
