package ejemploProductorConsumidor;

public class Cliente extends Thread{
	private final Almacen almacen;
	
	public Cliente(Almacen almacen, String nombre) {
		super(nombre);
		this.almacen = almacen;
	}
	
	@Override
	public void run() {
		for(int i=1; i <= 5 ; i++) {
			Paquete p = almacen.recogerPaquete();
			System.out.println("Paque recogido "+p);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
