package EjemploExecutorService;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		Runnable tarea = () -> {
			String nombre = Thread.currentThread().getName();
			System.out.println("Inicio tarea: "+nombre);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Fin tarea: "+nombre);
		};
		
		for(int i=1; i <= 5 ; i++) {
			executor.submit(tarea);
		}
		
		executor.shutdown();

	}

}
