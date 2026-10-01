import java.io.File;
import java.io.IOException;

/**
 * EJERCICIO 2) Escribe un programa que: ▪ Establezca el directorio de trabajo
 * de ProcessBuilder ▪ Recupere y muestre la ruta del directorio de trabajo ▪
 * Cree un proceso y muestre su PID. ▪ Detenga la ejecución del proceso durante
 * 2 segundos utilizando, puedes utilizar Thread. sleep(int tiempo ms). ▪
 * Compruebe si el proceso está vivo con el método isAlive(): Si está vivo lo
 * finalizará y se mostrará el mensaje "Terminamos el proceso de forma manual",
 * Si ya ha finalizado, mostrará el mensaje "El proceso ha finalizado".
 */
public class Ejercicio2 {

	public static void main(String[] args) {

		ProcessBuilder pB = new ProcessBuilder("notepad");
		// Establecemos directorio de trabajo
		pB.directory(new File("C:/PSP"));
		try {
			Process p = pB.start();
			// Obtenemos la ruta de trabajo y el PID
			System.out.println("RUTA TRABAJO: " + pB.directory().getAbsolutePath());
			System.out.println("PID: " + p.pid());
			// Detenemos la ejecucicón del hilo principal durante 2 segundo
			Thread.sleep(2000);
			// Comprobamos si ha finalizado el proceso
			if (p.isAlive()) {
				System.out.println("Terminamos el proceso de forma manual");
				p.destroyForcibly();
			} else {
				System.out.println("El proceso ha finalizado");
			}
		} catch (IOException e) {
			System.out.println("[ERROR] Al ejecutar el proceso");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("[ERROR] Proceso interrumpido");
			e.printStackTrace();
		}

	}

}
