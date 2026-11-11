package ejemploProductorConsumidor;

public class Transportista extends Thread{
	
	private final Almacen almacen;
	
	public Transportista(Almacen almacen, String nombre) {
		super(nombre);
		this.almacen = almacen;
	}
	
	@Override
	public void run() {
		for(int i=1; i <= 5 ; i++) {
			Paquete p = new Paquete();
			almacen.dejarPaquete(p);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
