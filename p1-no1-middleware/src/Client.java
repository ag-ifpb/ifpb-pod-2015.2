import java.io.IOException;
import java.net.Socket;


public class Client {
	public final static String ERROR = "#ERRO: sem connexão.";
	private final static String NO2_ADDR = "localhost";
	private final static int NO2_PORT = 9999;
	
	private Socket socket = null;
	
	private void send(String msg){
		try {
			socket.getOutputStream().write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String recv(){
		try {
			byte[] b = new byte[1024];
			socket.getInputStream().read(b);
			String result = new String(b);
			return result.trim();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	private void disconn(){
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void conn(){
		//
		System.out.println("[Ari] tentando se conectar para realizar transmissão.");
		//
		try {
			socket = new Socket(NO2_ADDR, NO2_PORT);
		} 
		catch (IOException e) {
			//
		}
	}
	
	public boolean isConnected(){
		return socket != null;
	}
	
	public String process(String msg){
		//
		System.out.println("[Ari] executando a tramissão e recepção de dados");
		//result default
		String result;
		//
		if (socket != null){
			System.out.println("[Ari] .... enviando: " + msg.trim());
			send(msg);
			result = recv();
			System.out.println("[Ari] .... recebendo: " + result.trim());
			disconn();
			System.out.println("[Ari] .... conexão encerrada!");
		}
		else {
			result = ERROR;
		}
		//resulting
		return result;
	}
	
	
}
