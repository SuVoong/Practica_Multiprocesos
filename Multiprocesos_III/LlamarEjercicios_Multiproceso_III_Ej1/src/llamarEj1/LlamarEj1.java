package llamarEj1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LlamarEj1 {
		public static void main(String[] args) throws IOException {

			File directorio = new File(
					"D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Ejercicios_Multiprocesos_II_Ej1\\bin");

			ProcessBuilder pb = new ProcessBuilder("java", "ej1.Ejercicio1");
			
			File fInp = new File("dato.txt");
			File fErr = new File("errorEj1.txt");
			
			pb.redirectInput(fInp);
			pb.redirectError(fErr);
			pb.directory(directorio);
			Process p = pb.start();

			OutputStream os = p.getOutputStream();
			os.flush();

			int exitVal = -1;

			try {
				exitVal = p.waitFor();
				System.out.println("Valor de salida: " + exitVal);
			} catch (Exception e) {
				e.printStackTrace();
			}

			escribir(p);
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
