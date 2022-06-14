import java.net.*;
import java.io.*;
import java.util.*;
class TCPServer
{
	public static void main(String args[])throws IOException
	{
		ServerSocket servSock=new ServerSocket(2345);
		while(true)
		{
			Socket clientSock=servSock.accept();
			BufferedReader in=new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
			String strInUp=in.readLine().toUpperCase()+"\n";
			DataOutputStream out=new DataOutputStream(clientSock.getOutputStream());
			out.writeBytes(strInUp);
		}
	}
}