import java .io.*;
import java.net.*;
import java.util.*;
class EchoClient
{
	public static void main(String args[])throws IOException
	{
		if(args.length<2 || args.length>3)
			throw new IllegalArgumentException("Parameter(s):<server><word>[<port>]");
		String server=args[0];
		byte buff[]=args[1].getBytes();
		int port;
		if(args.length==3)
			port=Integer.parseInt(args[2]);
		else
			port=7;
		Socket sock=new Socket(server,port);
		InputStream in=sock.getInputStream();
		OutputStream out=sock.getOutputStream();
		out.write(buff);
		int totalBytesRevd=0;
		int bytesRevd;
		while(totalBytesRevd<buff.length)
		{
			if((bytesRevd=in.read(buff,totalBytesRevd,buff.length-totalBytesRevd))!=-1)		
				totalBytesRevd+=bytesRevd;
		}
		System.out.println("Received from server: "+new String(buff));
		sock.close();
	}
}