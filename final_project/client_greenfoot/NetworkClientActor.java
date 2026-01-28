import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Write a description of class NetworkClientActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NetworkClientActor extends Actor 
{
    private Socket socket;

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public String username;
    private boolean nameSent = false;
    
    public NetworkClientActor(Socket s, String username){
    //make invisible
    GreenfootImage img = new GreenfootImage(1, 1);
    img.setTransparency(0);
    setImage(img);

    System.out.println("Network actor constructed");

        try {
            this.socket = s;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        }
        catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public static NetworkClientActor startClient (String username){
        try    {
            Socket s = new Socket("localhost", 4999);
            NetworkClientActor client = new NetworkClientActor(s, username);
            
            client.listenForMessage();
            
            return client;
        }
        catch (IOException e){
            System.out.println("couldnt get the socket");
            e.printStackTrace();
            return null;
        }
    }
    
    public void act()
    {   
        
    }
    
    public void sendMessage(String msg){
        if(!nameSent){
            try {
                bufferedWriter.write(username);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                nameSent = true;
            }
            catch (IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }

        try {
            msg = username + ": " + msg;
            bufferedWriter.write(msg);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;

                while(socket.isConnected()){
                    try {
                        msgFromGroupChat = bufferedReader.readLine();
                        System.out.println(msgFromGroupChat);
                    }
                    catch (IOException e){
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if(bufferedReader != null){
                bufferedWriter.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
