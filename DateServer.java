import java.net.*;
import java.util.Date;
import java.io.*;
class DateServer
{
	public static void main(String args[])throws IOException
	{
		ServerSocket servSock=new ServerSocket(1313);
		while(true)
		{
			Socket clntSock=servSock.accept();
			ObjectOutputStream timeOut=new ObjectOutputStream(clntSock.getOutputStream());
			timeOut.writeObject(new Date());
			clntSock.close();
		}
	}
}