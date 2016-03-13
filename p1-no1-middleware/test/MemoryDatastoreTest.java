import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MemoryDatastoreTest {
	//
	private File to = new File(InverseDatastore.TO);
	private File from = new File(InverseDatastore.FROM);
	private String messageto = new String("Mensagem para servidor.\n");
	

	@Before
	public void setup() {
		try {
			to.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(to);
			outputStream.write(messageto.getBytes());
			outputStream.flush();
			outputStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void test(){
		//criando memoria de estocagem
		DatastoreMemory datastore = new DatastoreMemory();
		//ler a mensagem para envio, converte em 
		//texto e exclui o arquivo
		datastore.readFromFile();
		assertTrue(datastore.hasMessages());
		assertEquals(messageto, datastore.recoverAndRemoveMessagesOfMemory());
		assertFalse(to.exists());
		//escrever a resposta
		datastore.writeToFile("Mensagem");
		//verificar se o arquivo from.txt existe
		assertTrue(from.exists());
	}
	
	@After
	public void teardown(){
		from.delete();
	}
	
}
