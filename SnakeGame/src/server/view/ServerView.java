package server.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

        //DropShadow
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetY(3.5);
        dropShadow.setOffsetX(-3.5);
        dropShadow.setColor(Color.DARKGREEN);

        //Button Font
        Font buttonfont = new Font("AR DESTINE", 15);

        serverPortLabel = new Label("Server Port: ");
        serverPortLabel.setFont (new Font ("AR DESTINE", 18));
        serverPortTxtField = new TextField();
        serverPortTxtField.setEffect(dropShadow);
        serverPortTxtField.setText("");


        startButton = new Button("Start");
        startButton.setFont (buttonfont);
        startButton.setTextFill(Color.WHITE);
        startButton.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        startButton.setEffect(dropShadow);
        startButton.setMaxWidth(150);
        startButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startButton.setTextFill(Color.GOLD);
            }
        });
        startButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startButton.setTextFill(Color.WHITE);
            }
        });

        terminateButton = new Button("Terminate");
        terminateButton .setFont(buttonfont);
        terminateButton .setTextFill(Color.WHITE);
        terminateButton .setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        terminateButton .setEffect(dropShadow);
        terminateButton .setMaxWidth(150);
        terminateButton .setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                terminateButton.setTextFill(Color.GOLD);
            }
        });
        terminateButton .setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                terminateButton.setTextFill(Color.WHITE);
            }
        });


        VBox vBox = new VBox();

        HBox hBox = new HBox ();
        hBox.getChildren().addAll(serverPortLabel,serverPortTxtField,startButton,terminateButton);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

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

        BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/ground2.jpg",850,700,false,false),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        vBox.getChildren().addAll(hBox, clientInfoTable);
        vBox.setSpacing(10);
        vBox.setMaxHeight(430);
        this.getChildren().addAll(vBox);
        this.setAlignment(Pos.CENTER);
        this.setBackground(new Background(backgrd));



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
