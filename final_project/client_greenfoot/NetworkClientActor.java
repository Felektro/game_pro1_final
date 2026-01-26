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
    private String serverMsg = "default_message";
    boolean readyToSend = false;
    
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

    public static void startClient (String username){
        try    {
            /*
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your username for the group chat: ");
            String username = scanner.nextLine();
            */
            
           
            System.out.println("1");
            Socket s = new Socket("localhost", 4999);
            System.out.println("2");
            NetworkClientActor client = new NetworkClientActor(s, username);
            System.out.println("3");
            
            client.listenForMessage();
            //client.sendMessage();
        }
        catch (IOException e){
            System.out.println("couldnt get the socket");
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

    public void sendToServer(String msg){
        serverMsg = msg;
        readyToSend = true;
    }
    
    public void sendMessage(){
        try {
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            while(socket.isConnected()){
                //String messageToSend = scanner.nextLine();
                //bufferedWriter.write(username+": " + messageToSend);
                if(readyToSend){
                    bufferedWriter.write(serverMsg);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    readyToSend = false;
                }
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
