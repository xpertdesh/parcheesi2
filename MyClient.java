import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyClient {

	private boolean hasConnections = false;
	private String serverIp;
	private int port;
	private Scanner listener;
	private PrintWriter publisher;
	private Socket socket;
	private String name;
	private String name1;
	
	private class Connection implements Runnable {


		@Override
		public void run() {
			System.out.println("Attempting to connect");
			if (hasConnections) {
				System.out.println("Connection already established");
			} else {
				//while (!hasConnections) {
					try {
						socket = new Socket(serverIp, port);
						hasConnections = true;
						listener = new Scanner(socket.getInputStream());
						publisher = new PrintWriter(socket.getOutputStream(),true);
						System.out.println("Connection established");

						OutputStream outputStream = socket.getOutputStream();
						DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
						dataOutputStream.writeUTF(name);
						dataOutputStream.flush();
						dataOutputStream.close();
						socket.close();
						System.exit(1);
						throw new InterruptedException("Oh no!");
						//while (true) {
							//Thread.sleep(2000);
							//publisher.println("Hi there, my name is " + name);
						//}
					}
					catch (IOException e) {
						System.out.println("Failure establishing connection on " + serverIp + ":" + port);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("Retrying connection");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				//}
				System.out.println("Test message received: " + listener.nextLine());
				while (!socket.isClosed()) {
					String data = listener.nextLine();
					System.out.println("Received Message: " + data);
				}
			}
		}
	}

	
	public MyClient(String serverIp, int port, String name) {
		this.serverIp = serverIp;
		this.port = port;
		if (name == null){
			this.name = "Bozo";
		}
		else{
			this.name = name;
		}
		this.hasConnections = false;
		ExecutorService threadPool = Executors.newFixedThreadPool(1);
		threadPool.execute(new Connection());
	}
	public String getName(){
		return this.name;
	}
	
	public static void main(String[] args) {
		
		new MyClient("127.0.0.1",6000,args[0]);
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
