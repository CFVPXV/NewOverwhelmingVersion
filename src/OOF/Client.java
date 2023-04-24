package OOF;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.RuleBasedCollator;
import java.util.Random;
import java.util.Scanner;

public class Client implements Runnable {

    private String ip;
    private int port;
    private String name;
    Socket con;
    DataInputStream in;
    DataOutputStream out;
    Scanner scnr;
    public Client(String i, int p, String n)
    {
        name = n;
        ip = i;
        port = p;
        scnr = new Scanner(System.in);
        try
        {
            System.out.println("Connecting to Server.");
            con = new Socket(ip,port);
            in = new DataInputStream(con.getInputStream());
            out = new DataOutputStream(con.getOutputStream());
            System.out.println(con);
        }
        catch (IOException e)
        {
            System.out.println("ERROR CONNECTING AS A CLIENT! "+e.getMessage());
        }
    }
    @Override
    public void run()
    {
        while(con.isConnected())
        {
            try
            {
                System.out.println("Got anything to say?");
                String message = scnr.next();
                String card = in.readUTF();
                System.out.println(card);
                out.writeUTF(message);

            }
            catch(IOException e)
            {
                System.out.println("ERROR with client! "+e.getMessage());
            }
        }
    }

}
