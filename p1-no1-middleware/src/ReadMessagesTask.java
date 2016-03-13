


public class ReadMessagesTask implements Runnable{
	private final DatastoreMemory datastore;
	
	public ReadMessagesTask(DatastoreMemory ds) {
		datastore = ds;
	}

	@Override
	public void run() {
		datastore.readFromFile();
	}
	
}
