import java.util.LinkedList;
import java.util.Queue;


/**
 * Representa a lista de mensagens em memória.
 * 
 * @author ari
 *
 */
public class DatastoreMemory {
	private Queue<String> queue = new LinkedList<String>();
	private InverseDatastore inverseDatastore = new InverseDatastore();
	
	public void readFromFile(){
		System.out.println("[Ari] enfileirando mensagens a serem enviadas (se houver).");
		String messages = inverseDatastore.read();
		if (!"".equals(messages)) queue.offer(messages);
	}
	
	public void writeToFile(String msg){
		System.out.println("[Ari] escrevendo resposta recebida: " + msg);
		inverseDatastore.write(msg);
	}
	
	public boolean hasMessages(){
		if (queue.size() > 0){
			System.out.println(String.format("[Ari] existe(m) %d mensagen(s) para envio.", queue.size()));
			return true;
		}
		else {
			System.out.println("[Ari] não existem mensagens para envio.");
			return false;
		}
	}
	
	public String recoverAndRemoveMessagesOfMemory(){
		System.out.println("[Ari] recuperando e removendo mensagens da fila e armazenando em uma variável.");
		StringBuffer sb = new StringBuffer();
		while(!queue.isEmpty()){
			sb.append(queue.poll());
		}
		return sb.toString();
	}
	
}
