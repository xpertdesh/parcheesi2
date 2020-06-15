import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		}
		catch (IOException e) {
			System.out.println("Failure establishing connection");
			e.printStackTrace();
		}
		while (!socket.isClosed()) {
			System.out.println(subscriber.nextLine());
		}
	}
}
