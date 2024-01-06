package ej3;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;


public class LlamarEj3 {
	public static void main(String[] args) throws IOException {

		File f = new File(
				"D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Ejercicios_Multiprocesos_II_Ej3\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "ej3.Ejercicio3");
		
		File fInp = new File("texto.txt");
		File fOut = new File("palindromo.txt");
		File fErr = new File("error.txt");
		
		pb.redirectInput(fInp);
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.directory(f);

		Process p = pb.start();

		OutputStream ops = p.getOutputStream();
		ops.flush();
		
	}

}
