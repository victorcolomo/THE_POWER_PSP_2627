package ejemploColaPreparada;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		Almacen almacen = new Almacen();
		
		Transportista t = new Transportista(almacen, "Seur");
		Cliente c = new Cliente(almacen, "Ana");
		
		t.start();
		c.start();
		
		t.join();
		c.join();
		
		System.out.println("== Programa finalizado ==");
		
	}
	
}
