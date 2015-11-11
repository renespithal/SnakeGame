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

    /**
     * connects to the Server
     * client: new socket with Server IP and Port
     * reader: BufferedReader, gets InputStream from client
     * writer: gets OutputStream from client
     *
     */


    public void connectToServer(){

        if(model.getClientNickname().length() > 2 && model.getClientNickname().length() <11){

        try {

            client = new Socket(model.getServerIP(), model.getServerPort());
           // client = new Socket(serverIP, Integer.parseInt(serverPort));
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer = new PrintWriter(client.getOutputStream());
            Thread t = new Thread(new MessagesFromServerListener());
            t.start();
            System.out.println("Connected");
            appendText("Connected to Server");

        } catch (IOException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } }

        else appendText("pls enter nickname (between 3 and 10 characters)");

    }

    public void disconnectFromServer(){
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * sends message to server with writer
     * writer prints a new line with clientNickName and clientMessage
     * clears the Message TextField after send
     * sets Focus on TextField
     *
     */

    public void sendMessageToServer(){

        if (model.getClientMessage().length() > 0){

        this.clientNickName = view.getNickName().getText();
        this.clientMessage = view.getClientMessage().getText();


            writer.println(clientNickName + ": " + clientMessage);
            writer.flush();

            view.getClientMessage().setText("");
            view.getClientMessage().requestFocus();}
        else appendText("pls enter message");


    }

    /**
     * if new messages reach server print on TextArea
     *
     *
     */

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

    /**
     * prints the message on the TextArea
     *
     * @param message
     *       contains message for TextArea
     */

    public void appendText(String message) { view.getInfoTxtArea().appendText(message + "\n");
    }

    public String getClientIP(){
        return this.client.getInetAddress().getHostAddress();
    }

    }


