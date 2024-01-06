package ej4;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Scanner;

import escribir_ej4_2.Escribir;

public class LlamarEjercicio4_2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Map<String, String> asig_nomFich = Escribir.escribir_asignatura_fichero(sc);

		for (Map.Entry<String, String> entry : asig_nomFich.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			Process p = llamarEjercicio4(key, val);
			valExit(p);
			Escribir.escribir(p);
		}
		sc.close();
	}

	public static void valExit(Process p) {
		int valExit = -1;
		try {
			valExit = p.waitFor();
			System.out.println("Resultado: " + valExit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Process llamarEjercicio4(String asignatura, String fichero) throws IOException {
		File f = new File("D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Ejercicios_Multiprocesos_III_Ej4\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "ej4.Ejercicio4");

		File fInp = new File(
				"D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\LlamarEjercicios_Multiprocesos_III_Ej4\\bin\\"
						+ fichero);
		File fErr = new File("error.txt");

		pb.redirectInput(fInp);
		pb.redirectError(fErr);
		pb.directory(f);
		System.out.println("En la asignatura " + asignatura);
		Process p = pb.start();
		OutputStream ops = p.getOutputStream();
		ops.flush();
		return p;
	}
}
