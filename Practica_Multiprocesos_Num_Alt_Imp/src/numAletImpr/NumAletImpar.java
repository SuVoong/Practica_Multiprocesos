package numAletImpr;
/**
 * @author SuShan Voong SUn
 */
public class NumAletImpar {
	public static void main(String [] args) {
		
//		10 Numeros aletorios impares
		
		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random()* (100-1));
			while(num % 2 != 1) {
				num = (int) (Math.random()* (100-1));
			}
			System.out.println(num);
		}
		
	}
}
