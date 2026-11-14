package ejemploColaPreparada;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Almacen {

	private BlockingQueue<Paquete> paquetes;
	private final static int CAPACIDAD_MAXIMA = 5;
	
	public Almacen() {
		this.paquetes = new ArrayBlockingQueue<Paquete>(CAPACIDAD_MAXIMA);
	}
	// Metodo para que el hilo transportista deje un paquete
	public void dejarPaquete(Paquete paquete) throws InterruptedException {
		// Se queda a la espera si se alcanza la capacidad maximo
		paquetes.put(paquete);;
		System.out.println("Transportista deja paquete");
	}
	// Metodo para que el hilo cliente recoja un paquete
	public Paquete recogerPaquete() throws InterruptedException {
		// Se queda a la espera si LinkenList está vacío
		Paquete p = paquetes.take();
		// Despertamos a los hilos transportistas que estén a la espera por almacen lleno
		return p;
	}
}
