import java.io.File;
import java.io.IOException;

public class Ejercicio6 {

	public static void main(String[] args) {
		//  tres procesos simultáneos lanzando tres veces el programa Triangulo con 
		// los parámetros 5, 7 y 9
		ProcessBuilder pb1 = new ProcessBuilder("java","Triangulo","hola");
		ProcessBuilder pb2 = new ProcessBuilder("java","Triangulo","7");
		ProcessBuilder pb3 = new ProcessBuilder("java","Triangulo","9");
		
		pb1.redirectOutput(new File("Triangulo5.txt"));
		pb2.redirectOutput(new File("Triangulo7.txt"));
		pb3.redirectOutput(new File("Triangulo9.txt"));
		
		pb1.redirectError(new File("ErrorTriangulo5.txt"));
		pb2.redirectError(new File("ErrorTriangulo7.txt"));
		pb3.redirectError(new File("ErrorTriangulo9.txt"));
		
		File bin = new File("bin");
		pb1.directory(bin);
		pb2.directory(bin);
		pb3.directory(bin);
		
		try {
			Process p1 = pb1.start();
			Process p2 = pb2.start();
			Process p3 = pb3.start();
			
			int codigo1 = p1.waitFor();
			p2.waitFor();
			p3.waitFor();
			
			System.out.println("Codigo salida proceso 1: "+codigo1);
			
		} catch (IOException e) {
			System.out.println("[ERROR] Al ejecutar el proceso");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("[INFO] Finaliza la ejecución revisa los fichero");
		
		
	}
	
}
