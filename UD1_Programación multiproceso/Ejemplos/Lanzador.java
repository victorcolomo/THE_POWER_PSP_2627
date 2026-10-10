import java.io.File;
import java.io.IOException;

public class Lanzador {

	public static void main(String[] args) {
		
		ProcessBuilder pB = new ProcessBuilder("java","Principal");
		// Podemos cambiar el directorio de trabajo a la carpeta
		// donde este el .class
		pB.directory(new File("bin"));
		pB.redirectOutput(new File("salida.txt"));
		pB.redirectError(new File("error.txt"));
		pB.redirectInput(new File("entrada.txt"));
		
		ProcessBuilder pB1 = new ProcessBuilder("java","Principal");
		// Podemos cambiar el directorio de trabajo a la carpeta
		// donde este el .class
		pB1.directory(new File("bin"));
		pB1.redirectOutput(new File("salida1.txt"));
		pB1.redirectError(new File("error1.txt"));
		pB1.redirectInput(new File("entrada1.txt"));
		
		try {
			Process p = pB.start();
			Process p1 = pB1.start();
			
			p.waitFor();
			p1.waitFor();
			
			System.out.println("Revisa los ficheros de salida");
			
		} catch (IOException e) {
			System.out.println("[ERROR] Al ejecutar el proceso");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("[ERROR] Proceso interrumpido");
			e.printStackTrace();
		}
		
		

	}

}
