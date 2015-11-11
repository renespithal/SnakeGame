package client.presenter;

import client.model.ClientModel;
import client.view.ClientView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Rusty on 09.11.2015.
 */
public class ClientPresenter {

    private ClientModel model;
    private ClientView view;
    Socket client;
    PrintWriter writer;
    BufferedReader reader;

    private String serverPort;
    private String serverIP;
    private String clientNickName;
    private String clientMessage;


    public ClientPresenter(ClientModel model, ClientView view) {

        this.model = model;
        this.view = view;
        view.getConnectButton().setOnAction(e -> connectToServer());
        view.getDisconnectButton().setOnAction(e -> disconnectFromServer());
        view.getSendButton().setOnAction(e -> sendMessageToServer());
        view.getSendTxtField().setOnAction(e -> sendMessageToServer());

    }

    public void connectToServer(){

        try {
            this.serverPort = view.getServerPort().getText();
            this.serverIP = view.getServerIP().getText();
            client = new Socket(serverIP, Integer.parseInt(serverPort));
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream());
            Thread t = new Thread(new MessagesFromServerListener());
            t.start();
            System.out.println("Connected");

        } catch (IOException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }

    public void disconnectFromServer(){
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToServer(){

        this.clientNickName = view.getNickName().getText();
        this.clientMessage = view.getClientMessage().getText();


            writer.println(clientNickName + ": " + clientMessage);
            writer.flush();

            view.getClientMessage().setText("");
            view.getClientMessage().requestFocus();


    }

    public class MessagesFromServerListener implements Runnable {

        @Override
        public void run() {
            String message;

            try {
                while((message = reader.readLine()) != null) {
                    appendText(message);

                }
            } catch (IOException e) {
                appendText("Message failed to be received");
                e.printStackTrace();
            }
        }

    }
    public void appendText(String message) { view.getInfoTxtArea().appendText(message + "\n");
    }

    public String getClientIP(){
        return this.client.getInetAddress().getHostAddress();
    }

    }


