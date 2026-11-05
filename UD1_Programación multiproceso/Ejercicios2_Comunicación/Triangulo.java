import java.time.LocalDateTime;

public class Triangulo {

		public static void main(String[] args) {
			
			if(args.length != 1) {
				System.err.print("[ERROR] El programa requiere un argumento");
				System.exit(1);
			}
			System.out.println("Inicio: "+LocalDateTime.now());
			int base = 0;
			try {
				base = Integer.parseInt(args[0]);
			}catch (NumberFormatException e) {
				System.err.print("[ERROR] El argumento debe ser un numero entero");
				System.exit(2);
			}
			
			if(base <= 0) {
				System.err.print("[ERROR] El argumento debe ser un numero entero positivo");
				System.exit(3);
			}
			
			for(int i=base; i >= 1 ; i--) {
				for(int j=1; j <= i ; j++) {
					System.out.print(j);
				}
				System.out.println();
			}
			System.out.println("Fin: "+LocalDateTime.now());
		}
}
