import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2 {

	public static void main(String[] args) {
		ProcessBuilder pB = new ProcessBuilder("cmd","/C","dir");
		//pB.directory(new File("C:\\"));
		try {
			Process p = pB.start();
			
			// Salida estandar
			InputStream is = p.getInputStream();
			// Salida de error
			// InputStream is = p.getErrorStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while( (linea=br.readLine()) != null ) {
				System.out.println(linea);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
