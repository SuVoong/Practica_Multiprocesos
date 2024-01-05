package fecha_de_Nacimiento;
//SuShan Voong Sun
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FechaDeNacimiento {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<Integer> arrayFecha = new ArrayList<Integer>();
		int cont = 0;
		int anio = 0;
		int mes = 0;
		int dia = 0;
		try {
	
			while(br.ready()) {
				String str = br.readLine();
				arrayFecha.add(Integer.valueOf(str));
			}
			for (Integer integer : arrayFecha) {
				cont++;
				if (cont == 1 && (integer < 0 || integer > 31)) {
					System.exit(-2);
				}
				else if (cont == 2 && (integer < 1 || integer > 12)) {
					System.exit(-2);
				}
			}
			for (Integer integer : arrayFecha) {
				cont++;
				if (cont == 1) {
					dia = integer;
				}
				else if (cont == 2) {
					mes = integer;
				} else {
					anio = integer;
				}
			}
			
			if(anio > (2023-18)) {
				System.out.println("Es menor de edad");
			} else if (anio == (2023-18) || mes >= 11 || dia > 14){
				System.out.println("Es menor de edad");
			} else {
				System.out.println("Es mayor de edad");
			}
		} catch (NumberFormatException e2) {

			System.exit(-1);

		}
		isr.close();
	}
}
