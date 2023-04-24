package OOF;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Server implements Runnable
{
    private Socket clientCon;
    private int servPOC;
    private String[] gameDeck;
    public Server(Socket c, String[] game)
    {
        servPOC = 0;
        clientCon = c;
        gameDeck = game;
    }
    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                DataInputStream in = new
                        DataInputStream(clientCon.getInputStream());
                DataOutputStream out = new
                        DataOutputStream(clientCon.getOutputStream());
                out.writeUTF(gameDeck[0]);
                System.out.println(clientCon.getPort());
                String s = in.readUTF();
                servPOC++;
                System.out.println(clientCon.getPort() + " increments: " + servPOC);
                if(s.compareTo("Quit")==0)
                {
                    break;
                }
            }
            clientCon.close();
        }
        catch(IOException e)
        {
            System.out.println("ERROR ON CLIENT SOCKET: "+e.getMessage());
        }
    }
}

