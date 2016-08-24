package com.company;

import java.net.*;
import java.io.*;

public class Main
{
    public static void main(String [] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String serverName = "localhost";
        int port = 102;
        try
        {
            System.out.println("Connecting to " + serverName +
                    " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from "
                    + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in =
                    new DataInputStream(inFromServer);
            System.out.println("Server says " + in.readUTF());
            //client.close();
            while(true){
                String input = br.readLine();
                out.writeUTF(input);
                System.out.println(in.readUTF());
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }



    }
}