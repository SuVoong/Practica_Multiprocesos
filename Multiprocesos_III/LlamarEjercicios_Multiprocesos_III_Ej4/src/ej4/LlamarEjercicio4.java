package ej4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LlamarEjercicio4 {
	public static void main(String [] args) throws IOException {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Dime como se llama la asigantura.");
		String asignatura = sc.nextLine();
		
		Process p = fichero().start();
		
		OutputStream ops = p.getOutputStream();
		ops.flush();
		
		int valExit = -1;
		
		try {
			valExit = p.waitFor();
			System.out.println("Resultado: "+valExit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		escribir(p, asignatura);
		sc.close();
	}
	
	public static void escribir(Process p, String asignatura) {
		System.out.println("En la asignatura "+asignatura);
		try {
			InputStream is = p.getInputStream();
			int c;
			 while((c = is.read()) != -1) {
				 System.out.print((char) c);
			 }
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static ProcessBuilder fichero(){
		File f = new File("D:\\B3. PSP + PMDM\\PSP\\Pr Tr\\PSP1_Programación\\Ejercicios_Multiprocesos_III_Ej4\\bin");

		ProcessBuilder pb = new ProcessBuilder("java", "ej4.Ejercicio4");
		
		File fInp = new File("notas.txt");
		File fErr = new File("error.txt");
		
		pb.redirectInput(fInp);
		pb.redirectError(fErr);
		pb.directory(f);
		
		return pb;
	}
}
