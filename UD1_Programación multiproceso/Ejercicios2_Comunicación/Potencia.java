
/**
 * Crea un programa Potencia.java que reciba dos argumentos enteros: la base y
 * el exponente, que calcule la potencia y muestre el resultado por pantalla
 * 
 */
public class Potencia {

	// Potencia 4 2  -> 4^2
	public static void main(String[] args) {
		// Comprobar que recibe exactamente 2 parámetros
		if(args.length != 2) {
			System.out.println("[ERROR] Debe recibir 2 argumentos");
			System.exit(1);
		}
		int base = 0;
		int exponente = 0;
		try {
			base = Integer.parseInt(args[0]);
			exponente = Integer.parseInt(args[1]);
		} catch(NumberFormatException e) {
			System.out.println("[ERROR] Los parámetros debe de ser enteros");
			System.exit(2);
		}
		double resultado = Math.pow(base, exponente);
		System.out.println(resultado);
	}

}
