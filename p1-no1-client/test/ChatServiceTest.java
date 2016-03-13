import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;


public class ChatServiceTest {

	@Test
	public void test() {
		Datastore service = new Datastore();
		//verificar se o arquivo from.txt existe
		File from = new File(Datastore.FROM);
		assertFalse(from.exists());
		//ler o arquivo (que não existe)
		String recvmsg = service.read();
		assertEquals("", recvmsg);
		//enviar dados
		service.write("Mensagem");
		//verificar se o arquivo foi criado
		File to = new File(Datastore.TO);
		assertTrue(to.exists());
		to.delete();
	}

}
