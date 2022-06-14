import java.net.*;
import java.util.Date;
import java.io.*;
class DateClient
{
	public static void main(String args[])throws IOException
	{
		Socket clientSock=new Socket("localhost",1313);
		ObjectInputStream timeIn=new ObjectInputStream(clientSock.getInputStream());
		try
		{
			Date d=(Date)timeIn.readObject();
			System.out.println("Date is "+d);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		clientSock.close();
	}
}