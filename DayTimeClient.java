import java.io.*;
import java.util.*;
import java.net.*;
class DayTimeClient
{
    public static void main(String args[])
    {
        String hostname;
        if(args.length>0)
        hostname=args[0];
        else
        hostname="localhost";
        try
        {
            Socket theSocket=new Socket(hostname,13);
            DataInputStream theTimeStream=new DataInputStream(theSocket.getInputStream());
            String theTime=theTimeStream.readLine();
            System.out.println("It is "+theTime+" at "+hostname);
        }
        catch(UnknownHostException e)
        {
            System.out.println(e);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
