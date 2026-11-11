package ejemploContadorAtomico;

public class HiloContador extends Thread{

	private final ContadorAtomico contador;
	
	public HiloContador(ContadorAtomico contador, String nombre) {
		super(nombre);
		this.contador = contador;
	}
	
	@Override
	public void run() {
		for(int i=1 ; i <= 10000 ; i++) {
			contador.incrementar();
		}
		System.out.println(this.getName()+ " ha terminado!!!");
	}
}
