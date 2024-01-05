package llamar_Fecha_de_Nacimiento;
//SuShan Voong Sun
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamarFechaDeNacimiento {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String direccion = "D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\EXAMEN_Ej1_Fecha_de_Nacimiento\\bin";
		String clase = "fecha_de_Nacimiento.FechaDeNacimiento";
		String mensaje = "";
		System.out.println("Recibir fecha de nacimiento: ");
		System.out.print("Dime el dia numérico: ");
		mensaje += sc.nextLine()+"\n";
		System.out.print("Dime el mes numérico (1-12): ");
		mensaje += sc.nextLine()+"\n";
		System.out.print("Dime el año numérico: ");
		mensaje += sc.nextLine()+"\n";
		Process p = llamarPrograma(direccion, clase, mensaje);
		escribir(p);

		sc.close();
	}

	public static Process llamarPrograma(String direccion, String clase, String mensaje) throws IOException{
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
