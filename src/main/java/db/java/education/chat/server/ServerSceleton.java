package db.java.education.chat.server;

import javax.sql.rowset.spi.SyncProvider;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSceleton {
    public static List<ClientHandler> clientList = new ArrayList<>();
    public static List<String> journal = new ArrayList<>();

    public static void main(String[] args) {
        Socket client = null;
        try(ServerSocket serverSocket = new ServerSocket(8080)){
            while(true){
                client = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                new Thread(clientHandler).start();
                clientList.add(clientHandler);
            }
        }catch (IOException e){
            if(client!=null)
                clientList.remove(client);
            e.printStackTrace();
        }
    }

    public static String journalToString(){
        StringBuilder history = new StringBuilder();
        for(String s:journal){
            history.append(s);
            history.append(System.lineSeparator());
        }
        return history.substring(0,history.length()-2);
    }
}
