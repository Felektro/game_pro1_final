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

    private String username;
    
    public NetworkClientActor(Socket socket, String username){
        //make invisible
        GreenfootImage img = new GreenfootImage(1, 1);
        img.setTransparency(0);
        setImage(img);
        
        startClient();

        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        }
        catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void startClient (){
        try    {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your username for the group chat: ");
            String username = scanner.nextLine();

            Socket socket = new Socket("localhost", 4999);
            NetworkClientActor client = new NetworkClientActor(socket, username);

            client.listenForMessage();
            client.sendMessage();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void act()
    {   
        /*
        String serverAns = null;
        
        if(Greenfoot.isKeyDown("space")){

            
             System.out.println("we just pressed space on the client");
            
            sendToServer(s, "WE JUST PRESSED SPACE");
            
            try {
                s.setSoTimeout(1000);
                serverAns = receiveFromServer(s);
                System.out.println("Server: "+ serverAns);
            } catch (Exception e) {
                System.err.println(e.fillInStackTrace());

                reconnectToServer(s);
            }
        }*/
    }

    public void sendMessage(){
        try {
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);

            while(socket.isConnected()){
                String messageToSend = scanner.nextLine();
                bufferedWriter.write(username+": " + messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
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
