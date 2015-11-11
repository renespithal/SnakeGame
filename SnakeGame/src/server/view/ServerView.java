package server.view;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import server.model.ServerModel;
import server.model.ClientInfo;

/**
 * Created by Rusty on 09.11.2015.
 */
public class ServerView extends GridPane {

    private Label serverPortLabel;
    private TextField serverPortTxtField;

    private Button startButton;
    private Button terminateButton;

    private ServerModel model;

    public ServerView(ServerModel model){
        this.model = model;

        serverPortLabel = new Label("Server Port: ");
        serverPortTxtField = new TextField();
        serverPortTxtField.setText("");
        startButton = new Button("Start");
        terminateButton = new Button("Terminate");


        VBox vBox = new VBox();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);


        gridPane.add(serverPortLabel, 0, 1);
        gridPane.add(serverPortTxtField, 1, 1, 2, 1);


        gridPane.add(startButton, 0, 3);
        gridPane.add(terminateButton, 1, 3);

        TableView<ClientInfo> clientInfoTable;
        TableColumn<ClientInfo, String> clientIPColumn ;
        TableColumn<ClientInfo, Integer> clientPortColumn ;
        TableColumn<ClientInfo, String> clientNicknameColumn ;

        clientInfoTable = new TableView<ClientInfo>();

        clientIPColumn = new TableColumn<ClientInfo, String>("Client IP");
        clientIPColumn.setMinWidth(100);
        clientIPColumn.setCellValueFactory(new PropertyValueFactory<ClientInfo, String>("clientIP"));


        clientPortColumn = new TableColumn<ClientInfo, Integer>("Client Port");
        clientPortColumn.setMinWidth(100);
        clientPortColumn.setCellValueFactory(new PropertyValueFactory<ClientInfo, Integer>("clientPort"));


        clientNicknameColumn = new TableColumn<ClientInfo, String>("Client Nickname");
        clientNicknameColumn.setMinWidth(300);
        clientNicknameColumn.setCellValueFactory(new PropertyValueFactory<ClientInfo, String>("clientNickname"));
        // Create the Table:

        clientInfoTable.getColumns().addAll(clientIPColumn, clientPortColumn, clientNicknameColumn);

        vBox.getChildren().addAll(gridPane, clientInfoTable);
        vBox.setMaxHeight(430);
        this.getChildren().addAll(vBox);





    }
    public TextField getServerPort(){

        return this.serverPortTxtField;
    }
    public Button getStartButton(){
        return this.startButton;
    }

    public Button getTerminateButton(){
        return this.terminateButton;
    }
}
