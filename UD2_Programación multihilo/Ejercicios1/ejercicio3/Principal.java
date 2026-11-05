package ejercicio3;

public class Principal {

	public static void main(String[] args) {
		
		int casillaFin = 20;
		HiloTortuga t = new HiloTortuga(casillaFin, "Tortuga");
		t.start();
		
		HiloLiebre l = new HiloLiebre(casillaFin, "Liebre");
		
		// Hacemos que el hilo principal finalice
		try {
			t.join();
			l.getHilo().join();
		} catch (InterruptedException e) {
			System.out.println("[ERROR] Hilo interrumpido");
		}
		
		System.out.println("Fin de la carrera!!!");
		
		
	}
}
