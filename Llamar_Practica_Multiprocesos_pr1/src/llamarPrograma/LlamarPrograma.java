package llamarPrograma;
/**
 * @author SuShan Voong SUn
 */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LlamarPrograma {
	public static void main(String[] args) throws IOException {
		String direccionp1 = "D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Practica_Multiprocesos_Num_Alt_Imp\\bin";
		String clase1 = "numAletImpr.NumAletImpar";
		String direccionp2 = "D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Practica_Multiprocesos_Ord_Num\\bin";
		String clase2 = "ordenarNumAletrImpr.OrdenarNumAletrImpr";
		String mensaje = "";

		Process p1 = llamarPrograma1(direccionp1, clase1);
		System.out.println("Valor de la Salida programa 1: " + valExit(p1));
		System.out.println("Pintando la salida del programa de generación de impares");
		mensaje = escribirString(p1);
		System.out.println("Fin de la salida del programa de generación de impares");

		Process p2 = llamarPrograma2(direccionp2, clase2, mensaje);
		System.out.println("Valor de la Salida programa 2: " + valExit(p2));
		System.out.println("Salida Ordenada del Segundo programa");
		escribir(p2);
		System.out.println("Fin Ordenada del Segundo programa");
	}

//	El metodo llamarPrograma1() recoge el String direccion y clase. Llamando programa 1 y de vuelve un process

	public static Process llamarPrograma1(String direccion, String clase) throws IOException {
		File f = new File(direccion);
		ProcessBuilder pb = new ProcessBuilder("java", clase);
		pb.directory(f);
		Process p = pb.start();
		OutputStream ops = p.getOutputStream();
		ops.flush();
		return p;
	}

//	El metodo llamarPrograma2() recoge el String direccion, clase y mensaje del programa 1. 
//	Llamando programa 2 y de vuelve un process.

	public static Process llamarPrograma2(String direccion, String clase, String mensaje) throws IOException {
		File f = new File(direccion);
		ProcessBuilder pb = new ProcessBuilder("java", clase);
		pb.directory(f);
		Process p = pb.start();
		OutputStream ops = p.getOutputStream();
		ops.write(mensaje.getBytes());
		ops.flush();
		return p;
	}

//	El metodo escribir() recoge process y lo muestra por consola el programa 

	public static void escribir(Process p) {
		try {
			InputStream is = p.getInputStream();
			int c;
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	El metodo escribir() recoge process y lo muestra por consola el programa y de vuele un String
//	todo el lo que ha mostrado por consola.

	public static String escribirString(Process p) {
		InputStream is = p.getInputStream();
		int c;
		String str = "";
		try {
			while ((c = is.read()) != -1) {
				System.out.print((char) c);
				str += String.valueOf((char) c);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
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
