import java.io.*;
import java.net.*;
import java.util.*;
class DayTimeServer
{
    public static void main(String args[])throws IOException
    {
        Socket theConnection;
        PrintStream p;
        try
        {
            ServerSocket theServer=new ServerSocket(13);
            try
            {
                while(true)
                {
                    theConnection=theServer.accept();
                    p=new PrintStream(theConnection.getOutputStream());
                    p.println(new Date());
                }
            }
            catch(IOException e)
            {
                theServer.close();
                System.out.println(e);
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}