package server.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import server.model.ServerModel;
import server.view.ServerView;

/**
 * Created by Rusty on 09.11.2015.
 */
public class ServerPresenter {


    private ServerModel model;
    @SuppressWarnings("unused")
	private ServerView view;
    ServerSocket serverSocket;
    ArrayList<PrintWriter> list_clientWriter;


    public ServerPresenter(ServerModel model, ServerView view) {
        this.model = model;
        this.view = view;


        view.getStartButton().setOnAction(e -> runServer());
        view.getTerminateButton().setOnAction(e -> terminateServer());


    }

    /**
     *
     * inner Class which handles threads
     *
     */



    public class ClientHandler implements Runnable {

        Socket client;
        BufferedReader reader;
        public ClientHandler(Socket client) {
            try {
                this.client = client;
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Client connected");
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

    /**
     *
     * new Socket client waits for client to connect to Server
     * PrintWriter writer takes OutputStream from client and saves in writer
     * Add writer in clientWriterList
     * For every client new thread (ClientHandler)
     *
     */




    public void listenToClients() {
        while(true) {
            try {
                Socket client = serverSocket.accept();
                PrintWriter writer = new PrintWriter(client.getOutputStream());
                list_clientWriter.add(writer);

                Thread clientThread = new Thread(new ClientHandler(client));
                clientThread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     *
     * starts server on ServerPort
     *
     */

    public boolean runServer() {
        try {

            this.serverSocket = new ServerSocket(model.getServerPort());
            System.out.println("Server started");
            list_clientWriter = new ArrayList<PrintWriter>();
            listenToClients();
            return true;

        } catch (IOException e) {
            System.out.println("Server start failed!");
            e.printStackTrace();
            return false;
        }

    }

    public void terminateServer() {


        try {
            serverSocket.close();
            System.out.println("Server closed");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void sendToAllClients(String message) {
        @SuppressWarnings("rawtypes")
		Iterator it = list_clientWriter.iterator();

        while(it.hasNext()) {
            PrintWriter writer = (PrintWriter) it.next();
            writer.println(message);
            writer.flush();
        }
    }
}
