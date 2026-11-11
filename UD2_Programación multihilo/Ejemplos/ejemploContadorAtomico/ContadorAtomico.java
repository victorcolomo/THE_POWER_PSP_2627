package ejemploContadorAtomico;

import java.util.concurrent.atomic.AtomicInteger;

public class ContadorAtomico {

	private AtomicInteger contador = new AtomicInteger(0);

	public synchronized void incrementar() {
		contador.incrementAndGet();
	}
	public int getCuenta() {
		return contador.get();
	}
	
}
