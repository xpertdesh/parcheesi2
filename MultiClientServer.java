import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MultiClientServer {

	public Socket socket;
	private PrintWriter writer;
	private Scanner subscriber;
	private boolean hasConnections;
	public ServerSocket listener;
	private int port = 6000;
	String name;

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


				InputStream inputStream = socket.getInputStream();
				DataInputStream dataInputStream = new DataInputStream(inputStream);
				name = dataInputStream.readUTF();
				listener.close();


			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getName(){
		return this.name;
	}
}
