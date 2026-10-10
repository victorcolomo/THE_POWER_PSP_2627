import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println("TABLA DEL "+n);
		for(int a=1 ; a <= 10 ; a++) {
			System.out.println(n*a);
		}
		scan.close();
	}

}
