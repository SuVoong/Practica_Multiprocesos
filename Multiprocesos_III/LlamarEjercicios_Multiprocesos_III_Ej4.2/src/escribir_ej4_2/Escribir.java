package escribir_ej4_2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.TreeMap;

public class Escribir {
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

	public static void escribirFichero(String nomFich) throws IOException {
		String filePath = "D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\LlamarEjercicios_Multiprocesos_III_Ej4\\bin\\"
				+ nomFich;
		FileWriter fw = new FileWriter(filePath, true);
		String str = "";
		for (int i = 0; i < 5; i++) {

			int nota = (int) (Math.random() * (10 - 1));
			str += String.valueOf(nota) + "\n";

//			No funciona meter decimales. Hay que utilizar un replase para cambiar , por .
//			Sige sin funcionar

//			double nota = (double) Math.random() * (10 - 1);
//			str += String.format("%.1f", nota)+ "\n";
//			str = str.replaceAll(",", ".");

		}
//		str = str.replaceAll(",", ".");
		fw.write(str);
		fw.close();
	}

	public static TreeMap<String, String> escribir_asignatura_fichero(Scanner sc) throws IOException {
		TreeMap<String, String> asig_nomFich = new TreeMap<String, String>();
		String asignatura = "";
		String nomFich = "";

		while (!asignatura.contains("*")) {
			System.out.println("Dime como se llama la asigantura: ");
			asignatura = sc.nextLine();
			if (!asignatura.contains("*")) {
				System.out.println("Escribe el nombre del fichero: ");
				nomFich = sc.nextLine();
				asig_nomFich.put(asignatura, nomFich);
				escribirFichero(nomFich);
			}
		}
		return asig_nomFich;
	}

}
