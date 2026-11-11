package ejemploProductorConsumidor;

import java.util.LinkedList;
import java.util.List;

public class Almacen {

	private List<Paquete> paquetes;
	private final static int CAPACIDAD_MAXIMA = 5;
	
	public Almacen() {
		this.paquetes = new LinkedList<Paquete>();
	}
	// Metodo para que el hilo transportista deje un paquete
	public synchronized void dejarPaquete(Paquete paquete) {
		// Se queda a la espera si se alcanza la capacidad maximo
		while(paquetes.size() == CAPACIDAD_MAXIMA) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		paquetes.add(paquete);
		System.out.println("Transportista deja paquete");
		// Despertamos a los hilos clientes que estén a la espera por almacen vacío
		notifyAll();
	}
	// Metodo para que el hilo cliente recoja un paquete
	public synchronized Paquete recogerPaquete() {
		// Se queda a la espera si LinkenList está vacío
		while(paquetes.isEmpty()) {
			System.out.println("Cliente a la espera...");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Paquete p = paquetes.remove(0);
		// Despertamos a los hilos transportistas que estén a la espera por almacen lleno
		notifyAll();
		return p;
	}
}
