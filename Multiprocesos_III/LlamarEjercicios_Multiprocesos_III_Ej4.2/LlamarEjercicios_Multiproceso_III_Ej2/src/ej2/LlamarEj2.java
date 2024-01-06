package ej2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LlamarEj2 {
	public static void main(String[] args) throws IOException {
		File f = new File(
				"D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Ejercicios_Multiprocesos_II_Ej2\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "ej2.Ejercicio2");
		
		File fInp = new File("datos.txt");
		File fOut = new File("suma.txt");
		File fErr = new File("error.txt");
		
		pb.redirectInput(fInp);
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.directory(f);

		Process p = pb.start();
		OutputStream ops = p.getOutputStream();
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
