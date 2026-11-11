package ejemploProductorConsumidor;

public class Paquete {

	private static int numeroPaquetes = 0;
	private int codigo;
	
	public Paquete() {
		this.codigo = ++numeroPaquetes;
	}

	@Override
	public String toString() {
		return "Paquete [codigo=" + codigo + "]";
	}
}
