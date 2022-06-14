import java.net.*;
import java.io.*;
import java.util.*;
class TCPClient
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a string in lowercase: ");
		String s=br.readLine();
		Socket clientSock=new Socket("localhost",2345);
		DataOutputStream out=new DataOutputStream(clientSock.getOutputStream());
		BufferedReader in=new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
		out.writeBytes(s+"\n");
		String modStr=in.readLine();
		System.out.println("String in uppercase: "+modStr);
		clientSock.close();
	}
}