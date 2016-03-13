


public class SendMessageTask implements Runnable {
	private final Object block = new Object();
	private final DatastoreMemory memoryDatastore;
	private final Client client;
	
	public SendMessageTask(DatastoreMemory ds, Client c) {
		System.out.println("[Ari] criando uma tarefa");
		memoryDatastore = ds;
		client = c;
	}

	@Override
	public void run() {
		synchronized (block) {
			//verificar se há mensagens
			if (memoryDatastore.hasMessages()){
				//tentando se conectar
				client.conn();
				//verificar se há conexão
				if (client.isConnected()){
					//enviando mensagens
					String resp = client.process(memoryDatastore.recoverAndRemoveMessagesOfMemory());
					//escrevendo resposta
					memoryDatastore.writeToFile(resp);
				}
			}
		}		
	}

}