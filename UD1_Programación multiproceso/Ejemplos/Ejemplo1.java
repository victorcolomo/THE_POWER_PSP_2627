import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class Ejemplo1 {

	public static void main(String[] args) {
		
		try {
			
			// ProcessBuilder permite crear y configurar un proceso externo.
			ProcessBuilder proceso = new ProcessBuilder("notepad.exe","datos.txt");
		
			// environment() devuelve un Map con las variables de entorn
			Map<String, String> env = proceso.environment();
			for( Entry<String, String> entrada  : env.entrySet() ) {
				System.out.println("Clave "+entrada.getKey() + " - " + entrada.getValue());
			}
			
			 // start() crea y lanza el proceso.
			Process p = proceso.start();
			System.out.println("Se ha lanzado el proceso");
			
			// pid() devuelve el identificador del proceso (PID).
			long pid = p.pid();
			System.out.println("PID del proceso: "+pid);
			
			// isAlive() permite comprobar si el proceso sigue ejecutándose.
			if(p.isAlive()) {
				System.out.println("Esta vivo...");
			}else {
				// exitValue() devuelve el código de salida del proceso.
                //   0 -> finalización correcta
                //   otro valor -> puede indicar algún tipo de error
				int salida = p.exitValue();
				System.out.println("El proceso ha finalizado con el codigo: "+salida);
			}
			
			// Esperamos como máximo 5 segundos a que termine el proceso.
			p.waitFor(5, TimeUnit.SECONDS);
			
			/*try {
				p.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */
			
			int salida = p.exitValue();
			System.out.println("El proceso ha finalizado con el codigo: "+salida);
			System.out.println("FIN DEL MAIN");
			
		} catch (IOException | InterruptedException e) {
			System.out.println("[ERROR] En la ejecución del proceso");
			e.printStackTrace();
		}
		
	}

}
