import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * EJERCICIO 1) Lanzar un proceso de Java que ejecute un comando incorrecto,
 * obtenga el stream de entrada conectado con la salida de error del proceso y
 * muéstrelo por pantalla.
 * 
 */
public class Ejercicio1 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("cmd","/C","dirrrr");
		
		try {
			Process p = pb.start();
			
			InputStream is = p.getErrorStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea = br.readLine();
			
			while(  linea != null ) {
				System.out.println(linea);
				
				linea = br.readLine();
			}
			
			
		} catch (IOException e) {
			System.out.println("[ERROR] Al ejecutar el proceso");
		}
		

	}

}
