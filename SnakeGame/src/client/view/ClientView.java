package client.view;

import client.model.ClientModel;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;


/**
 * Created by Rusty on 09.11.2015.
 */
public class ClientView extends BorderPane {

    private Label titleLabel;

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

    private RotateTransition t1;
    private RotateTransition t2;

    private ClientModel model;


public ClientView(ClientModel model){

    this.model = model;


    //Button Color
    Background buttonbackgrd = new Background(new BackgroundFill(Color.DARKGREEN,CornerRadii.EMPTY, Insets.EMPTY));

    //Button Font
    Font buttonfont = new Font("AR DESTINE", 15);

    //Label Font
    Font labelfont = new Font("AR DESTINE", 18);

    //DropShadow for the buttons
    DropShadow dropShadow = new DropShadow();
    dropShadow.setOffsetY(3.5);
    dropShadow.setOffsetX(-3.5);
    dropShadow.setColor(Color.DARKGREEN);

    //Images
    Image logo1 = new Image("file:src/images/yinyan1.png", 50, 50,true,true);
    ImageView ivlogo1 = new ImageView();
    ivlogo1.setImage(logo1);

    Image logo2 = new Image("file:src/images/yinyan1.png", 50, 50,true,true);
    ImageView ivlogo2 = new ImageView();
    ivlogo2.setImage(logo2);

    //Animation
    rotate1(ivlogo1, Duration.millis(1500), Interpolator.LINEAR);
    rotate2(ivlogo2, Duration.millis(1500), Interpolator.LINEAR);

    //Title
    titleLabel = new Label("Chat");
    titleLabel.setFont(new Font("AR DESTINE", 40));
    titleLabel.setTextFill(Color.DARKGREEN);

    serverPortLabel = new Label("Server Port: ");
    serverPortLabel.setFont (labelfont);
    serverPortTxtField = new TextField();
    serverPortTxtField.setEffect(dropShadow);
    serverPortTxtField.setText("8888");

    serverIPLabel = new Label("Server IP: ");
    serverIPLabel.setFont (labelfont);
    serverIPTxtField = new TextField();
    serverIPTxtField.setEffect(dropShadow);
    serverIPTxtField.setText("localhost");

    clientNickNameLabel = new Label("Nickname: ");
    clientNickNameLabel.setFont(labelfont);
    clientNickNameTxtField = new TextField();
    clientNickNameTxtField.setEffect(dropShadow);

    infoTxtArea = new TextArea();
    infoTxtArea.setEditable(false);
    infoTxtArea.setMinHeight(200);
    infoTxtArea.setLayoutX(65);
    infoTxtArea.setEffect(dropShadow);

    connectButton = new Button("Connect");
    connectButton.setFont(buttonfont);
    connectButton.setEffect(dropShadow);
    connectButton.setBackground(buttonbackgrd);
    connectButton.setTextFill(Color.WHITE);
    connectButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            connectButton.setTextFill(Color.GOLD);
        }
    });
    connectButton.setOnMouseExited(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            connectButton.setTextFill(Color.WHITE);
        }
    });

    disconnectButton = new Button("Disconnect");
    disconnectButton.setFont(buttonfont);
    disconnectButton.setEffect(dropShadow);
    disconnectButton.setBackground(buttonbackgrd);
    disconnectButton.setTextFill(Color.WHITE);
    disconnectButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            disconnectButton.setTextFill(Color.GOLD);
        }
    });
    disconnectButton.setOnMouseExited(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            disconnectButton.setTextFill(Color.WHITE);
        }
    });


    sendButton = new Button("Send");
    sendButton.setFont(buttonfont);
    sendButton.setEffect(dropShadow);
    sendButton.setBackground(buttonbackgrd);
    sendButton.setTextFill(Color.WHITE);
    sendButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            sendButton.setTextFill(Color.GOLD);
        }
    });
    sendButton.setOnMouseExited(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            sendButton.setTextFill(Color.WHITE);
        }
    });


    clientMessageLabel = new Label("Enter your message:");
    clientMessageLabel.setFont (labelfont);
    clientMessageTxtField = new TextField();
    clientMessageTxtField.setEffect(dropShadow);


    //Create Boxes
    HBox hBox = new HBox(ivlogo1,titleLabel,ivlogo2);
    hBox.setAlignment(Pos.CENTER);
    hBox.setSpacing(10);

    VBox vBox = new VBox();

    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(10);

    gridPane.add(serverIPLabel, 2, 0);
    gridPane.add(serverIPTxtField, 3, 0, 2, 1);

    gridPane.add(serverPortLabel, 2, 1);
    gridPane.add(serverPortTxtField, 3, 1, 2, 1);

    gridPane.add(clientNickNameLabel, 2, 2);
    gridPane.add(clientNickNameTxtField, 3, 2, 2, 1);

    gridPane.add(connectButton, 5, 2);
    gridPane.add(disconnectButton, 6, 2);

    gridPane.add(clientMessageLabel,2,6);
    gridPane.add(clientMessageTxtField, 3,6,2,1);
    gridPane.add(sendButton,5,6);
    gridPane.setAlignment(Pos.BOTTOM_CENTER);

    Pane textPane = new Pane(infoTxtArea);

    //Background
    BackgroundImage backgrd = new BackgroundImage(new Image("file:src/images/ground2.jpg",850,700,false,false),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);

    vBox.getChildren().addAll(gridPane,textPane);
    vBox.setSpacing(20);
    this.setTop(hBox);
    this.setCenter(vBox);
    this.setBackground(new Background(backgrd));

    bindViewComponentsToModel();

}

    //Animation
    public void rotate1(ImageView logo1, Duration duration, Interpolator interpolator) {

        t1 = new RotateTransition(duration, logo1);
        t1.setFromAngle(0);
        t1.setToAngle(360);
        t1.setCycleCount(Transition.INDEFINITE);
        t1.setAutoReverse(false);
        t1.setInterpolator(interpolator);
        t1.play();

    }

    public void rotate2(ImageView logo2, Duration duration, Interpolator interpolator) {

        t2 = new RotateTransition(duration, logo2);
        t2.setFromAngle(0);
        t2.setToAngle(360);
        t2.setCycleCount(Transition.INDEFINITE);
        t2.setAutoReverse(false);
        t2.setInterpolator(interpolator);
        t2.play();

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

    private void bindViewComponentsToModel() {
        serverIPTxtField.textProperty().bindBidirectional(model.serverIPProperty());
        serverPortTxtField.textProperty().bindBidirectional(model.serverPortProperty(), new NumberStringConverter());
        clientNickNameTxtField.textProperty().bindBidirectional(model.clientNicknameProperty());
        clientMessageTxtField.textProperty().bindBidirectional(model.clientMessage());
    }

}
