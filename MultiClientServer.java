import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiClientServer {

	public class Connection implements Runnable {
		
		public Socket socket;
		private PrintWriter writer;
		private Scanner subscriber;

		public Connection(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
		
			try {
				writer = new PrintWriter(socket.getOutputStream(),true);
				subscriber = new Scanner(socket.getInputStream());
				System.out.println("Connection established");
				writer.println("Argh! I smell pirates!!!");
			} catch (IOException e) {
				System.out.println("Failure establishing connection");
				e.printStackTrace();
			}
			while (!socket.isClosed()) {
				System.out.println(subscriber.nextLine());
			}
		}
	}
	
	private boolean hasConnections;
	public ServerSocket listener;
	private int port = 6000;

	public MultiClientServer() {
		this.hasConnections = true;
		try {
			listener = new ServerSocket(port);
			System.out.println("Attempting connection on port " + port);
			while (!listener.isClosed()) {
				Socket socket = listener.accept();
				ExecutorService threadPool = Executors.newFixedThreadPool(3);
				threadPool.execute(new Connection(socket));
				System.out.println("Connected to a client");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void write(String msg) {
//		
//		if (hasConnections) {
//			System.out.println("Writing data to client");
//			writer.println(msg);			
//		} else {
//			System.out.println("No client to write data");
//		}
//	}
	
	public static void main(String[] args) {
		new MultiClientServer();
	}
}
