package ordenarNumAletrImpr;
/**
 * @author SuShan Voong SUn
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenarNumAletrImpr {
	public static void main(String [] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<Integer> arrayL = new ArrayList<Integer>();
		
//		Con el while recoge los numeros impares del programa 1 y los guarda en un ArrayList.
		
		while(br.ready()) {
			String str = br.readLine();
			arrayL.add(Integer.valueOf(str));
		}
//		Con el ArrayList lo ordeno de menor a mayor.
		
		Collections.sort(arrayL);
		
//		Lo muestro por pantalla.
		
		for (Integer integer : arrayL) {
			System.out.println(integer);
		}
		
	}
}
