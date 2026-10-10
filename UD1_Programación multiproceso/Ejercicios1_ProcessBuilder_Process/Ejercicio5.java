import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {

	/**
	 * EJERCICIO 5) Escribe un programa que:
	 *  ▪ Reciba una lista de comandos a ejecutar. 
	 *  ▪ Cree un proceso hijo por cada comando de manera concurrente. 
	 *  ▪ Espere a que todos los procesos hijos terminen. 
	 * ▪ Al finalizar, muestre un mensaje indicando qué procesos terminaron 
	 * correctamente y cuáles no.
	 * 
	 */
	public static void main(String[] args) {
		// Estructura para guardar los Process
		List<Process> procesos = new ArrayList<>();
		// Contador para la finalizacion de los proceso
		int totalOk=0;
		int totalError=0;
		// Creamos procesos
		for(String comando : args) {
			ProcessBuilder pB = new ProcessBuilder(comando);
			try {
				Process proceso = pB.start();
				procesos.add(proceso);
			} catch (IOException e) {
				System.out.println("[ERROR] Al crear el proceso");
				e.printStackTrace();
			}
		}
		// Esperamos a que todos terminen
		for(Process p : procesos) {
			try {
				int codigo =p.waitFor();
				
				if(codigo == 0) {
					totalOk++;
				}else {
					totalError++;
				}
			} catch (InterruptedException e) {
				System.out.println("[ERROR] proceso interrumpido");
				e.printStackTrace();
			}
		}
		System.out.println("Procesos terminados correctamente: "+totalOk);
		System.out.println("Procesos terminados incorrectamente: "+totalError);
	}

}
