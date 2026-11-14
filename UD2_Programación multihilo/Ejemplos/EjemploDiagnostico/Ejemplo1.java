package EjemploDiagnostico;

public class Ejemplo1 {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable tarea = () -> {
			String nombre = Thread.currentThread().getName();
			System.out.println("Inicio de "+nombre);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Fin de: "+ nombre);
		};	
		// Darle nombre a los hilos
		Thread hilo1 = new Thread(tarea,"Hilo-Pepe");
		Thread hilo2 = new Thread(tarea,"Hilo-Juan");
		hilo1.start();
		hilo2.start();
		// Consultar estado del hilo
		System.out.println(hilo1.getState());
		
		// Esperar a que los hilos terminen
		hilo1.join();
		hilo2.join();
		System.out.println("Hilos terminados...");
		// Consultar estado del hilo cuando finalice
		System.out.println(hilo1.getState());
		
	}
}
