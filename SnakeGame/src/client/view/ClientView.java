package client.view;

import client.model.ClientModel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * Created by Rusty on 09.11.2015.
 */
public class ClientView extends GridPane {

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

    private ClientModel model;


public ClientView(ClientModel model){

    this.model = model;

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
    disconnectButton = new Button("Disconnect");

    sendButton = new Button("send");

    clientMessageLabel = new Label("Enter your message:");
    clientMessageTxtField = new TextField();


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
    this.getChildren().addAll(vBox);


}

    public TextField getServerPort(){

        return this.serverPortTxtField;
    }

    public TextField getServerIP() {

        return this.serverIPTxtField;
    }

    public TextField getNickName() {

        return this.clientNickNameTxtField;
    }

    public TextField getClientMessage(){

        return this.clientMessageTxtField;
    }

    public TextArea getInfoTxtArea(){

        return this.infoTxtArea;
    }

    public Button getConnectButton(){
        return this.connectButton;
    }

    public Button getDisconnectButton(){
        return this.disconnectButton;
    }

    public Button getSendButton(){
        return this.sendButton;
    }

    public TextField getSendTxtField(){
        return this.clientMessageTxtField;
    }




}
