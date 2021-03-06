import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * InverseDatastore faz a tarefa inversa do Datastore do cliente,
 * escrevendo no arquivo que o cliente lê e lendo do arquivo on e ler mensagens que
 * foram, respectivamente, transmitidas e recebidas pelo servidor.
 * 
 * @author ari
 *
 */
public class InverseDatastore {
	public final static String FROM = "/Users/ari/Documents/tmp/no1/channel_from.txt";
	public final static String TO = "/Users/ari/Documents/tmp/no1/channel_to.txt";
	
	public void write(String msg){
		try {
			//
			File file = new File(FROM);
			//
			if (!file.exists()) file.createNewFile();
			//
			FileOutputStream stream = new FileOutputStream(file, true);
			stream.write((msg + "\n").getBytes());
			stream.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String read(){
		//
		StringBuffer sb = new StringBuffer("");
		try {
			File file = new File(TO);
			if (file.exists()){
				//
				FileInputStream stream = new FileInputStream(file);
				//
				byte[] b = new byte[1024];
				stream.read(b);
				stream.close();
				//
				String response = new String(b);
				sb.append(response.trim());
				sb.append("\n");
				//
				file.delete();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
