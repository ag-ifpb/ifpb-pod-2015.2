import java.util.Scanner;


public class Main {
	private static Object block = new Object();
	private static boolean exit = false;

	public static void main(String[] args) {
		//
		final Datastore datastore = new Datastore();
		final Scanner scanner = new Scanner(System.in);
		//
		System.out.println("=============   SERVER    =================");
		System.out.println("Iniciando a aplicação. Digite '#exit' se desejar sair ou tecle ENTER para continuar");
		//thread para leitura
		Thread tread = new Thread(){
			public void run() {
				while(!exit){
					String msg = scanner.nextLine();
					if("#exit".equals(msg)) exit = true;
					else {
						datastore.write(msg);
					}
				}
			};
		};
		//thread para escrita
		Thread twrite = new Thread(){
			public void run() {
				while(!exit){
					System.out.print(datastore.read());
				}
			};
		};
		//
		tread.start();
		twrite.start();
		//
		while(!exit){
			//faz nada...
		}
		//
		tread.interrupt();
		twrite.interrupt();
		//
		scanner.close();
	}
	
}