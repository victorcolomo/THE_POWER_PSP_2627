
public class PrincipalHilos {

	public static void main(String[] args) {
		
		HiloCorredor c1 = new HiloCorredor("Pepe");
		HiloCorredor c2 = new HiloCorredor("Ana");
		c1.start();
		c2.start();
		
		try {
			c1.join();
			c2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Carrera finalizada");
		
		System.out.println("Tiempo Corredor1: "+c1.getTiempoTotal());
		System.out.println("Tiempo Corredor2: "+c2.getTiempoTotal());
		
	}

}
