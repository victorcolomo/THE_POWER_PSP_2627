
import java.io.IOException;

/**
 * * EJERCICIO 3) Escribe un programa que: ▪ Cree un proceso. ▪ Compruebe cada 3
 * segundos si el proceso sigue ejecutándose, hasta que finalice. ▪ Tras cada
 * comprobación, muestre un mensaje indicando si el proceso está activo o ha
 * terminado. ▪ Para hacer una pausa con una duración determinada, se puede
 * utilizar Thread. sleep(int tiempo ms).
 */

public class Ejercicio3 {

	public static void main(String[] args) {
		ProcessBuilder pB = new ProcessBuilder("notepad");
		try {
			Process p = pB.start();
			while (p.isAlive()) {
				System.out.println("El proceso esta activo...");
				Thread.sleep(3000);
			}
		} catch (IOException e) {
			System.out.println("[ERROR] Al ejecutar el proceso");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
