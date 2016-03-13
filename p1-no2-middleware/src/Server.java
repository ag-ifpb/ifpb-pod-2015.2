import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private final static String ADDR = "localhost";
	private final static int PORT = 9999;
	
	private boolean exit = false;
	
	private void send(Socket socket, String msg){
		//
		System.out.println("[ARI] enviando mensagem: " + msg);
		//
		try {
			String m = msg + "\n";
			socket.getOutputStream().write(m.getBytes());
			socket.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String recv(Socket socket){
		//
		System.out.println("[ARI] recebendo mensagem ");
		//
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
	
	private void disconn(Socket socket){
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void start(){
		try {
			//
			DatastoreMemory datastoreMemory = new DatastoreMemory();
			//
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(ADDR, PORT));
			while(!exit){
				//
				System.out.println("[ARI] esperando conexão ");
				//
				Socket socket = serverSocket.accept();
				//socket.setSoTimeout(10000);
				//
				String req = recv(socket);
				//
				datastoreMemory.writeToFile(req);
				//
				String resp = "";
				//
				while(!datastoreMemory.hasMessages()){
					datastoreMemory.readFromFile();
					Thread.sleep(10000);
				}
				//
				resp = datastoreMemory.recoverAndRemoveMessagesOfMemory();
				//
				send(socket, resp);
				//
				disconn(socket);
			}
			serverSocket.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
