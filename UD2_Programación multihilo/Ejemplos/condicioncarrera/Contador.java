package condicioncarrera;

public class Contador {
	private int cuenta = 0;
	
	public synchronized void incrementar() {
		this.cuenta++;
	}
	public int getCuenta() {
		return cuenta;
	}
}
