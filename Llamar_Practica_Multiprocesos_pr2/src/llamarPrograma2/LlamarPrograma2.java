package llamarPrograma2;
/**
 * @author SuShan Voong SUn
 */
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class LlamarPrograma2 {
	public static void main(String[] args) throws IOException {
		String direccion_pr1 = "D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Practica_Multiprocesos_Num_Alt_Imp\\bin";
		String clase_pr1 = "numAletImpr.NumAletImpar";
		String direccion_pr2 = "D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Practica_Multiprocesos_Ord_Num\\bin";
		String clase_pr2 = "ordenarNumAletrImpr.OrdenarNumAletrImpr";
		String fich_Impar = "impares.txt";
		String fich_Orden = "orden.txt";

		Process p1 = llamarPrograma1(direccion_pr1, clase_pr1, fich_Impar);
		System.out.println("Valor de la Salida programa 1: " + valExit(p1));

		Process p2 = llamarPrograma2(direccion_pr2, clase_pr2, fich_Impar, fich_Orden);
		System.out.println("Valor de la Salida programa 2: " + valExit(p2));

	}

//	El metodo llamarPrograma1() recoge el String direccion, clase y impares.txt, escribiendo los impares.
//	Llamando programa 1 y de vuelve un process

	public static Process llamarPrograma1(String direccion, String clase, String strOut) throws IOException {
		File f = new File(direccion);
		ProcessBuilder pb = new ProcessBuilder("java", clase);

		File fOut = new File(strOut);
		File fErr = new File("errores.txt");

		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.directory(f);

		Process p = pb.start();

		OutputStream ops = p.getOutputStream();
		ops.flush();
		return p;
	}

//	El metodo llamarPrograma2() recoge el String direccion, clase, impares.txt y orden.txt (ordenando los impares).
//	Llamando programa 2 y de vuelve un process

	public static Process llamarPrograma2(String direccion, String clase, String strInp, String strOut)
			throws IOException {
		File f = new File(direccion);
		ProcessBuilder pb = new ProcessBuilder("java", clase);

		File fInp = new File(strInp);
		File fOut = new File(strOut);
		File fErr = new File("errores.txt");

		pb.redirectInput(fInp);
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.directory(f);

		Process p = pb.start();

		OutputStream ops = p.getOutputStream();
		ops.flush();
		return p;
	}

//	El metodo valExit() muestra si funciona el programa con un 0 y si no funciona con un 1.

	public static Integer valExit(Process p) {
		int valExit = -1;
		try {

			valExit = p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valExit;
	}
}
