import java.io.*;
class IP
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an IP address:");
        String ip=br.readLine();
        String cl="";
        int firstByte=Integer.parseInt(ip.substring(0,ip.indexOf(".")));
        int firstDotIndex=ip.indexOf(".");
        int secondDotIndex=ip.indexOf(".",firstDotIndex+1);
        int thirdDotIndex=ip.indexOf(".",secondDotIndex+1);
        if(firstByte>=0 && firstByte<=127)
        cl="A";
        else if(firstByte>=128 && firstByte<=191)
        cl="B";
        else if(firstByte>=192 && firstByte<=223)
        cl="C";
        else if(firstByte>=224 && firstByte<=239)
        cl="D";
        else
        cl="E";
        System.out.println("The IP address belongs to class "+cl+".");
        switch(cl)
        {
            case "A":System.out.println("Network address is "+firstByte+".0.0.0");break;
            case "B":System.out.println("Network address is "+firstByte+"."+ip.substring(firstDotIndex+1,secondDotIndex)+".0.0");break;
            case "C":System.out.println("Network address is "+firstByte+"."+ip.substring(firstDotIndex+1,secondDotIndex)+"."+ip.substring(secondDotIndex+1,thirdDotIndex)+".0");break;
            case "D":System.out.println("Class D does not have a network address.");break;
            case "E":System.out.println("Class E does not have a network address.");break;
            default:System.out.println("Invalid IP address.");break;
        }
    }
}