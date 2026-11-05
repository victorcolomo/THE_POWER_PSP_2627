
public class HiloCorredorRunnable implements Runnable{

	private Thread hilo;
	private long tiempoTotal;
	
	public HiloCorredorRunnable(String name) {
		hilo = new Thread(this,name);
		hilo.start();
	}
	
	@Override
	public void run() {
		long inicio = System.nanoTime();
		System.out.println(hilo.getName()+ " ha empezado la carrera");
		for(int i=1; i<=5 ; i++) {
			try {
				hilo.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(hilo.getName()+ " va por el km: "+i);
		}
		System.out.println(hilo.getName()+ " ha finalizado la carrera");
		long fin = System.nanoTime();
		tiempoTotal = fin - inicio;
	}

	public long getTiempoTotal() {
		return tiempoTotal;
	}

	public Thread getHilo() {
		return hilo;
	}

	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}
	
	public void join() throws InterruptedException {
		this.hilo.join();
	}
	

}
