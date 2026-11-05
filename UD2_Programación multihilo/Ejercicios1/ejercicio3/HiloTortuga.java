package ejercicio3;

import java.util.concurrent.ThreadLocalRandom;

public class HiloTortuga extends Thread {

	private int casillaActual;
	private int casillaFin;
	
	public HiloTortuga(int casillaFin, String nombre) {
		super(nombre);
		this.casillaFin = casillaFin;
		this.casillaActual = 1;
	}
	
	@Override
	public void run() {
		do {
			int aleatorio = ThreadLocalRandom.current().nextInt(0, 100);
			if(aleatorio < 50) {
				System.out.println(this.getName()+ " Avanza 3 casillas ");
				this.casillaActual += 3;
			} else if (aleatorio < 70) {
				System.out.println(this.getName()+ " Retrocede 6 casillas ");
				this.casillaActual -= 6;
				if(this.casillaActual < 1) {
					this.casillaActual = 1;
				}
			}else {
				System.out.println(this.getName()+ " Avanza 1 casillas ");
				this.casillaActual += 1;
			}
			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}while(this.casillaActual < this.casillaFin);
		System.out.println(this.getName()+ " ha terminado!!");
	}
	


}
