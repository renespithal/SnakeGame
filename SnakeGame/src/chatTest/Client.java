package chatTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Rusty on 04.11.2015.
 */
public class Client extends Application {


    private Label serverPortLabel;
    private TextField serverPortTxtField;

    private Label serverIPLabel;
    private TextField serverIPTxtField;

    private Label clientNickNameLabel;
    private TextField clientNickNameTxtField;

    private Label clientMessageLabel;
    private TextField clientMessageTxtField;

    private TextArea infoTxtArea;
    private Button connectButton;
    private Button disconnectButton;
    private Button sendButton;


    Socket client;
    PrintWriter writer;
    BufferedReader reader;

    public static void main(String[] args) {


        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Chat");


        serverPortLabel = new Label("Server Port: ");
        serverPortTxtField = new TextField();
        serverPortTxtField.setText("8888");

        serverIPLabel = new Label("Server IP: ");
        serverIPTxtField = new TextField();
        serverIPTxtField.setText("localhost");

        clientNickNameLabel = new Label("ClientInfo Nickname: ");
        clientNickNameTxtField = new TextField();

        infoTxtArea = new TextArea();
        infoTxtArea.setEditable(false);
        connectButton = new Button("Connect");
        connectButton.setOnAction(e -> connectToServer());
        disconnectButton = new Button("Disconnect");
        disconnectButton.setOnAction(event1 -> disconnectFromServer());

        sendButton = new Button("send");
        sendButton.setOnAction(e -> sendMessageToServer());
        clientMessageLabel = new Label("Enter your message:");
        clientMessageTxtField = new TextField();
        clientMessageTxtField.setOnAction(event -> sendMessageToServer());

        VBox vBox = new VBox();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(serverIPLabel, 0, 0);
        gridPane.add(serverIPTxtField, 1, 0, 2, 1);

        gridPane.add(serverPortLabel, 0, 1);
        gridPane.add(serverPortTxtField, 1, 1, 2, 1);

        gridPane.add(clientNickNameLabel, 0, 2);
        gridPane.add(clientNickNameTxtField, 1, 2, 2, 1);

        gridPane.add(clientMessageLabel,0,4);
        gridPane.add(clientMessageTxtField, 1,4,2,1);
        gridPane.add(sendButton,2,5);

        gridPane.add(connectButton, 0, 3);
        gridPane.add(disconnectButton, 1, 3);

        Pane textPane = new Pane(infoTxtArea);

        vBox.getChildren().addAll(gridPane,textPane);
        vBox.setMaxHeight(430);


        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();


        }
    public void connectToServer(){

        try {
            client = new Socket(serverIPTxtField.getText(), Integer.parseInt(serverPortTxtField.getText()));
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

            writer.println(clientNickNameTxtField.getText() + ": " + clientMessageTxtField.getText());
            writer.flush();

            clientMessageTxtField.setText("");
            clientMessageTxtField.requestFocus();


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
    public void appendText(String message) {
        infoTxtArea.appendText(message + "\n");
    }


}
