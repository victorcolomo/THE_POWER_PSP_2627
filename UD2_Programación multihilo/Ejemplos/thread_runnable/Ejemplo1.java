
public class Ejemplo1 {

	public static void main(String[] args) {
		Thread hiloPrincipal = Thread.currentThread();
		System.out.println("Nombre: "+hiloPrincipal.getName());
		System.out.println("PID: "+hiloPrincipal.getId());
		System.out.println("Prioridad: "+hiloPrincipal.getPriority());

	}

}
