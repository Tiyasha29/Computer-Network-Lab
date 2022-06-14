import java.io.*;
import java.net.*;
import java.util.*;
class MulticastDateClient
{
	public static void main(String args[])throws IOException
	{
		MulticastSocket socket=new MulticastSocket(1313);
		InetAddress group=InetAddress.getByName("230.0.0.1");
		socket.joinGroup(group);
		for(int i=0;i<10;i++)
		{
			byte buff[]=new byte[256];
			DatagramPacket packet=new DatagramPacket(buff,buff.length);
			socket.receive(packet);
			String s=new String(packet.getData());
			System.out.println("Date is: "+s);
		}
		socket.leaveGroup(group);
		socket.close();
	}
}