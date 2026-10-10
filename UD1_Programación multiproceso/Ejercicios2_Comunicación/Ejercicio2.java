import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * EJERCICIO 2) Crea un programa al que se le pase como argumento de línea de
 * comandos la ruta o path de un directorio. El path introducido debe ser el de
 * un directorio, y si no existe, debe mostrarse un mensaje de error, y también
 * si existe, pero no es un directorio. Para ello, debe utilizarse la clase
 * File. Si existe, debe mostrarse el resultado del comando dir sobre ese
 * directorio, pero las líneas deben ir numeradas, teniendo la primera el número
 * 1. El programa debe obtener un stream asociado a la salida estándar del
 * proceso y después leer línea a línea de él. Para ejecutar el proceso puedes
 * utilizar la clase ProcessBuilder
 * 
 */

// javac Ejercicio2.java
// java Ejercicio2 c:/PSP
public class Ejercicio2 {

	public static void main(String[] args) {

		// 1º Comprobar que sólo se le pasa un argumentos
		if (args.length != 1) {
			System.out.println("[ERROR] El programa necesita un solo argumento");
			System.exit(1);
		}

		// 2º Comprobar que el argumento es la ruta de un directorio
		String ruta = args[0];
		File fichero = new File(ruta);

		if (fichero.isDirectory()) {
			// 3º Si es un directorio, ejecutamos el comando dir sobre ese directorio
			ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "dir",ruta);
			try {
				Process p = pb.start();
				// 4º Obtener la salida standar
				InputStream is = p.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String linea = br.readLine();
				int contador=1;
				System.out.println("== SALIDA STANDAR ==");
				System.out.println(" Ruta: "+fichero.getAbsolutePath());
				while (linea != null) {
					System.out.println(contador+": "+linea);
					linea = br.readLine();
					contador++;
				}
			} catch (IOException e) {
				System.out.println("[ERROR] Al ejecutar el proceso");
			}
		} else {
			System.out.println("[ERROR] La ruta " + ruta + " no es un directorio");
			System.exit(1);
		}

	}

}
