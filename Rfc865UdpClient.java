import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Rfc865UdpClient {
	static DatagramSocket socket;
	public static void main(String[] args) {
		System.out.println("Start client");
		// TODO Auto-generated method stub
		try {
			socket= new DatagramSocket();
		} catch(SocketException e) {}
		
		try {
			InetAddress localhost= InetAddress.getByName("localhost");
			byte[] buffer= ("Nguyen Duy Khanh, TS5, "+InetAddress.getLocalHost().getHostAddress()).getBytes();
			InetAddress ip= InetAddress.getByName("172.21.150.19");
			 DatagramPacket request = new DatagramPacket(buffer,buffer.length,ip,17);
			 socket.send(request);
			 //
			 // 3. Send UDP reply to client
			 //
			 byte[] res= new byte[255];
			 DatagramPacket reply = new DatagramPacket(res,255) ;
			 socket.receive(reply);
			 String message= new String(reply.getData());
			 System.out.println(message);
			 } catch (IOException e1) {}
		
	}

}
