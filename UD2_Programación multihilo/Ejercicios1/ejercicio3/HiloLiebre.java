package ejercicio3;

import java.util.concurrent.ThreadLocalRandom;

public class HiloLiebre implements Runnable {

	private int casillaActual;
	private int casillaFin;
	private Thread hilo;

	public HiloLiebre(int casillaFin, String nombre) {
		this.hilo = new Thread(this, nombre);
		this.casillaFin = casillaFin;
		this.casillaActual = 1;
		hilo.start();
	}

	/*
	 * Liebre Duerme 40% No hace nada Gran 
	 * Salto 20% Avanza 9 casillas 
	 * Resbaló 20% Retrocede 8 casillas 
	 * Pequeño salto 20% Avanza 3 casillas
	 */

	@Override
	public void run() {
		do {
			int aleatorio = ThreadLocalRandom.current().nextInt(0, 100);
			if (aleatorio < 40) {
				System.out.println(hilo.getName() + " No hace nada ");
			} else if (aleatorio < 60) {
				System.out.println(hilo.getName() + " Avanza 9 casillas ");
				this.casillaActual += 9;
				
			} else if(aleatorio < 80){
				System.out.println(hilo.getName() + " Retrocede 8 casillas ");
				this.casillaActual -= 8;
				if (this.casillaActual < 1) {
					this.casillaActual = 1;
				}
			} else {
				System.out.println(hilo.getName() + " Avanza 3 casillas ");
				this.casillaActual += 3;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} while (this.casillaActual < this.casillaFin);
		System.out.println(hilo.getName() + " ha terminado!!");

	}

	public Thread getHilo() {
		return hilo;
	}

}
