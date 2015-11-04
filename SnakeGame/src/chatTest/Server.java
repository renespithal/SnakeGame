package chatTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Rusty on 04.11.2015.
 */

public class Server {

    ServerSocket server;
    ArrayList<PrintWriter> list_clientWriter;



    public static void main(String[] args) {
        Server s = new Server();
        //if server runs listen to clients
        if (s.runServer()) {
            s.listenToClients();
        } else {
            // Do nothing
        }
    }

    public class ClientHandler implements Runnable {

        Socket client;
        BufferedReader reader;

        public ClientHandler(Socket client) {
            try {
                this.client = client;
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;

            try {
                while((message = reader.readLine()) != null) {
                    System.out.println("Client: \n" + message);
                    sendToAllClients(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void listenToClients() {
        while(true) {
            try {
                Socket client = server.accept();

                PrintWriter writer = new PrintWriter(client.getOutputStream());
                list_clientWriter.add(writer);

                Thread clientThread = new Thread(new ClientHandler(client));
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean runServer() {
        try {
            server = new ServerSocket(8888);
            System.out.println("Server started");

            list_clientWriter = new ArrayList<PrintWriter>();
            return true;
        } catch (IOException e) {
            System.out.println("Server start failed!");
            e.printStackTrace();
            return false;
        }
    }


    public void sendToAllClients(String message) {
        Iterator it = list_clientWriter.iterator();

        while(it.hasNext()) {
            PrintWriter writer = (PrintWriter) it.next();
            writer.println(message);
            writer.flush();
        }
    }
}