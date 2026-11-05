
public class HiloCorredor extends Thread {

	private long tiempoTotal;
	
	public HiloCorredor(String nombre) {
		super(nombre);
	}
	
	@Override
	public void run() {
		long inicio = System.nanoTime();
		System.out.println(getName()+ " ha empezado la carrera");
		for(int i=1; i<=5 ; i++) {
			System.out.println(getName()+ " va por el km: "+i);
		}
		System.out.println(getName()+ " ha finalizado la carrera");
		long fin = System.nanoTime();
		tiempoTotal = fin - inicio;
	}

	public long getTiempoTotal() {
		return tiempoTotal;
	}
	
	
	
	
}
