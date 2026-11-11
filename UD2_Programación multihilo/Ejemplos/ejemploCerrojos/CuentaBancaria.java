package ejemploCerrojos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CuentaBancaria {

	private static int saldo = 500;
	// Declaramos el cerrojo
	private static final Lock cerrojo = new ReentrantLock();

	private static void retirarDinero(int cantidad) {
		// Intentamos adquirir el bloque
		cerrojo.lock();
		try {
			if(saldo >= cantidad) {
				saldo -= cantidad;
				System.out.println("== Retirado dinero "+cantidad);
			}else{
				System.out.println("== No hay saldo suficiente...");
			}
		} finally {
			// Liberar el bloque
			// Dentro de finally para asegurarnos que se libere aunque
			// el hilo tenga una excepción
			cerrojo.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Creamos los hilos
		Thread hilo1 = new Thread(() -> retirarDinero(100));
		Thread hilo2 = new Thread(() -> retirarDinero(300));
		// Lanzamos los hilos
		hilo1.start();
		hilo2.start();
		
		hilo1.join();
		hilo2.join();
		
		System.out.println("== Saldo final "+saldo);
		
	}

}
