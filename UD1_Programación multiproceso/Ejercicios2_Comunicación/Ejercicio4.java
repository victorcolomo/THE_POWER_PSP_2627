import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * EJERCICIO 4) Crear un programa para que se ejecute por consola. Debe tener
 * dos clases: ▪ Aleatorios: genera un número aleatorio del 0 al 10 y lo muestra
 * por pantalla ▪ Ejercicio04: pide al usuario por pantalla que introduzca un
 * texto, hasta que escriba “N”, cada vez que no escriba “N”, inicia un proceso
 * lanzando el programa Aleatorios y muestra el número generado por pantalla.
 * Ejemplo de ejecución: Generar aleatorio (N para finalizar): a Aleatorio: 8
 * Generar aleatorio (N para finalizar): s Aleatorio: 6
 * 
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Genarar aleatorio (N para finalizar");
		String opcion = entrada.nextLine();
		
		while(!opcion.equalsIgnoreCase("N")) {
			ProcessBuilder pb = new ProcessBuilder("java","Aleatorios");
			// Establecemos el directorio de trabajo donde esta el .class
			pb.directory(new File("bin"));
			try {
				Process p = pb.start();
				InputStream is = p.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String linea = br.readLine();
				while(linea != null) {
					System.out.println(linea);
					linea = br.readLine();
				}
			} catch (IOException e) {
				System.out.println("[ERROR] Al lanzar el proceso");
				e.printStackTrace();
			}
			
			System.out.println("Genarar aleatorio (N para finalizar");
			opcion = entrada.nextLine();
		}
		entrada.close();
	}
	
}
