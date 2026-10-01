
import java.io.IOException;

/**
 * Ejercicio 1) Escribe un programa que : 
 * ▪ Reciba como argumentos el comando y las opciones del comando que se quiere ejecutar. 
 * Si el programa no recibe ningún argumento, se mostrará un mensaje de error. 
 * ▪ Cree un proceso hijo que ejecute el comando con las opciones correspondientes. 
 * ▪ Si la ejecución falla, debe mostrar un mensaje de error 
 * ▪ El proceso padre debe esperar a que el hijo termine y mostrar: 
 * ❑ El comando ejecutado. 
 * ❑ El código definalización
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		// Comprobamos si se le pasa algún argumento
		if (args.length == 0) {
			System.out.println("[ERROR] Falta argumentos");
			System.exit(1);
		}
		// ProcessBuilder permite crear y configurar un proceso externo.
		ProcessBuilder pb = new ProcessBuilder(args);

		try {
			// start() crea y lanza el proceso.
			Process p = pb.start();
			// Obtenemos el PID
			System.out.println("PID: " + p.pid());
			// Esperamos a que el proceso termine
			int exit = p.waitFor();
			// Mostramos el código de salida y el comando
			System.out.println("Codigo de salida: " + exit);
			System.out.println(pb.command());
			System.exit(0);

		} catch (IOException | InterruptedException e) {
			System.out.println("ERROR." + e.getMessage());
			throw new RuntimeException(e);
		}
	}

}