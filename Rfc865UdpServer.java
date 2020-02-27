import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Rfc865UdpServer {
	static DatagramSocket socket;
	static int offset=0;
	public static void main(String[] args) {
		System.out.println("Server side");
		// TODO Auto-generated method stub
		try {
			socket= new DatagramSocket(17);
			while(true) {
				try {
					 //
					 // 2. Listen for UDP request from client
					 //
					byte[] buffer= new byte[255];
					
					 DatagramPacket request = new DatagramPacket(buffer,buffer.length);
					 socket.receive(request);
					 //
					 // 3. Send UDP reply to client
					 //
					 InetAddress clientAddress= request.getAddress();
					 int clientPort= request.getPort();
					 byte[] message= "OK".getBytes();
					 DatagramPacket reply = new DatagramPacket(message, message.length,clientAddress,clientPort);
					 socket.send(reply); 
					 } catch (IOException e1) {}

			}
		} catch(SocketException e) {
		}
		
	}
}
