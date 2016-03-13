import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		//
		System.out.println("=============   MIDLEWARE CLIENTE    =================");
		//memory datastore
		DatastoreMemory memoryDatastore = new DatastoreMemory();
		//client
		Client client = new Client();
		//criar um executor de tarefas
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//tarefas de ...
		//...verificar se existe mensagem e ler
		service.scheduleAtFixedRate(new ReadMessagesTask(memoryDatastore), 1000, 10000, TimeUnit.MILLISECONDS);
		//...enviar mensagens que devem ser enviadas
		service.scheduleAtFixedRate(new SendMessageTask(memoryDatastore, client), 1000, 10000, TimeUnit.MILLISECONDS);
	}
}
