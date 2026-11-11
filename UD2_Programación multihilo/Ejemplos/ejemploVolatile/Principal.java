package ejemploVolatile;

public class Principal {

	private static volatile boolean activo = true;
	
	public static void main(String[] args) throws InterruptedException {
		// Declaramos el hilo
		Thread servicio = new Thread(()->{
			while(activo) {
				System.out.println("Hilo funcionando...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		// Iniciamos hilo
		servicio.start();
		// Dormimos hilo principal 2 segundos
		Thread.sleep(2000);
		System.out.println("== Solicitamos detener el servicio");
		activo = false;
		// Esperamos a que el hilo termine
		servicio.join();
		System.out.println("== Programa finalizado ==");	
	}
	
}
