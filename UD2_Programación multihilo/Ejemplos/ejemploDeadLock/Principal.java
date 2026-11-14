package ejemploDeadLock;

public class Principal {

	public static void main(String[] args) {
		
		Object recursoA = new Object();
		Object recursoB = new Object();
		
		Thread hilo1 = new Thread(() -> {
			System.out.println("Intentamos obtener el recurso A");
			synchronized (recursoA) {
				System.out.println("Tiene el recurso A");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Intentamos obtener el recurso B");
				synchronized (recursoB) {
					System.out.println("Tiene el recurso B");	
					// Acciones
				}
			}
		});
		
		Thread hilo2 = new Thread(() -> {
			System.out.println("Intentamos obtener el recurso B");
			synchronized (recursoB) {
				System.out.println("Tiene el recurso B");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Intentamos obtener el recurso A");
				synchronized (recursoA) {
					System.out.println("Tiene el recurso A");	
					// Acciones
				}
			}
		});
		
		hilo1.start();
		hilo2.start();
		
		try {
			hilo1.join();
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hilos finalizados");

	}

}
