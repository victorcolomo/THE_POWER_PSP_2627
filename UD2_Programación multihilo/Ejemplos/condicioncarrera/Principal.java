package condicioncarrera;

public class Principal {

	private static final int NUMERO_HILOS = 5;
	
	public static void main(String[] args) {
		
		Contador contador = new Contador();
		Thread[] hilos = new Thread[NUMERO_HILOS];
		
		for(int i=0 ; i < NUMERO_HILOS ; i++) {
			HiloContador h = new HiloContador(contador, "Hilo"+i);
			h.start();
			hilos[i] = h;
		}
		
		for(Thread h : hilos) {	
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("=== CUENTA FINALIZADA ===");
		System.out.println("Contador "+contador.getCuenta());
		
		
		
	}
	
}
