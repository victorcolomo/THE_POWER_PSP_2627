
public class PrincipalHiloRunnable {

	public static void main(String[] args) {
		
		HiloCorredorRunnable c1 = new HiloCorredorRunnable("Pepe");
		HiloCorredorRunnable c2 = new HiloCorredorRunnable("Ana");
		
		try {
			//c1.join();
			//c2.join();
			c1.getHilo().join();
			c2.getHilo().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Carrera finalizada");
		
		System.out.println("Tiempo Corredor1: "+c1.getTiempoTotal());
		System.out.println("Tiempo Corredor2: "+c2.getTiempoTotal());
	}

}
