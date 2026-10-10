
/**
 * Crea un programa EjecutorPotencia.java que: Lance dos procesos hijos
 * de Potencia La salida de dos procesos debe ser enviada a los archivos
 * potencia1.txt y potencia2.txt y los errores a errorPotencia1.txt, y
 * errorPotencia2.txt Al final, muestra un mensaje indicando que los archivos se
 * han generado correctamente.
 * 
 */
public class EjecutorPotencia {

	public static void main(String[] args) {
		// Creamos los processBuilder
		ProcessBuilder pb1 = new ProcessBuilder("java","Potencia","4","2");
		ProcessBuilder pb2 = new ProcessBuilder("java","Potencia","4","hola");
		// Redireccionamos la salida estandar y de error de los procesos
		
		// Lanzamos los procesos
		
		// Esperamos que terminen los hijos y mostramos sus código de salia
	}
}
