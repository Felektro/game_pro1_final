import java.net.*;
import java.io.*;

class Server {


    private ServerSocket ss;

    public Server(ServerSocket serverSocket){
        this.ss = serverSocket;
    }

    public void StartServer(){
        try {

            while(!ss.isClosed()){

                Socket socket = ss.accept();

                System.out.println("A new client has connected");

                ClientHandler ch = new ClientHandler(socket);

                Thread thread = new Thread(ch);
                thread.start();

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void closeServerSocket(){
        try {
            if(ss != null){
                ss.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException{

        ServerSocket ss = new ServerSocket(4999);
        System.out.println("Server listening on 4999");

        Server server = new Server(ss);
        server.StartServer();
    }
}
