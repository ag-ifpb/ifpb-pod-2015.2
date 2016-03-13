import java.util.Scanner;


public class Main {
	private static boolean exit = false;

	public static void main(String[] args) {
		//
		final Datastore datastore = new Datastore();
		final Scanner scanner = new Scanner(System.in);
		//
		System.out.println("=============   CLIENTE    =================");
		System.out.println("Iniciando a aplicação. Digite '#exit' se desejar sair ou tecle ENTER para continuar");
		//thread para leitura
		Thread tread = new Thread(){
			public void run() {
				while(!exit){
					String msg = scanner.nextLine();
					if("#exit".equals(msg)){						
						exit = true;
					}
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
					String msg = datastore.read();
					if (!"".equals(msg)) System.out.print(msg);
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
