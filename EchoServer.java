import java .io.*;
import java.net.*;
import java.util.*;
class EchoServer
{
	public static void main(String args[])throws IOException
	{
		if(args.length!=1)
			throw new IllegalArgumentException("Parameter:<port>");
		int port=Integer.parseInt(args[0]);
		ServerSocket servSock=new ServerSocket(port);
		byte buff[]=new byte[256];
		int recvMsgSize;
		while(true)
		{
			Socket clntSock=servSock.accept();
			InputStream in=clntSock.getInputStream();
			OutputStream out=clntSock.getOutputStream();
			while((recvMsgSize=in.read(buff))!=-1)
			{
				out.write(buff,0,recvMsgSize);
			}
			clntSock.close();
		}
	}
}