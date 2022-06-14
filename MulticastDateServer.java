import java.io.*;
import java.net.*;
import java.util.*;
class MulticastDateServer
{
	public static void main(String args[])throws IOException,InterruptedException
	{
		DatagramSocket socket=new DatagramSocket(2345);
		InetAddress group=InetAddress.getByName("230.0.0.1");
		for(int i=0;i<10;i++)
		{
			byte[] buff=new Date().toString().getBytes();
			DatagramPacket packet=new DatagramPacket(buff,buff.length,group,1313);
			socket.send(packet);
			Thread.sleep(1500);
		}
		socket.close();
	}
}