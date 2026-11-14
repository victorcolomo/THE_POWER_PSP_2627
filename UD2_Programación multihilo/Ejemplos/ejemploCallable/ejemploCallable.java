package ejemploCallable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ejemploCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Callable<Integer> tarea = ()-> {
			System.out.println("Calculando resultando...");
			Thread.sleep(1000);
			return 10 + 30;
		};
		
		Future<Integer> resultado = executor.submit(tarea);
		Integer valor = resultado.get();
		System.out.println("Resultado = "+valor);
		executor.shutdown();
	}
	
}
