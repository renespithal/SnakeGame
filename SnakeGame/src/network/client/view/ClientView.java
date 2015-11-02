package network.client.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import network.client.model.ClientModel;

public class ClientView extends Tab {
	// Controls
	private Label serverPortLabel;
	private TextField serverPortTxtField;

	private Label serverIPLabel;
	private TextField serverIPTxtField;

	private Label clientNickNameLabel;
	private TextField clientNickNameTxtField;

	private TextArea infoTxtArea;
	private Button connectButton;
	private Button disconnectButton;
	private ClientModel model;

	public ClientView(ClientModel model) {
		super("Client");
		this.model = model;
		serverPortLabel = new Label("Server Port: ");
		serverPortTxtField = new TextField();

		serverIPLabel = new Label("Server IP: ");
		serverIPTxtField = new TextField();

		clientNickNameLabel = new Label("ClientInfo Nickname: ");
		clientNickNameTxtField = new TextField();

		infoTxtArea = new TextArea();
		connectButton = new Button("Connect");
		disconnectButton = new Button("Disconnect");
		
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

		gridPane.add(connectButton, 0, 3);
		gridPane.add(disconnectButton, 1, 3);
		
		Pane textPane = new Pane(infoTxtArea);

		vBox.getChildren().addAll(gridPane,textPane);
		vBox.setMaxHeight(430);
		this.setContent(vBox);
		bindViewComponentsToModel();
	}
	
	private void bindViewComponentsToModel() {
        serverIPTxtField.textProperty().bindBidirectional(model.serverIPProperty());
        serverPortTxtField.textProperty().bindBidirectional(model.serverPortProperty(), new NumberStringConverter());
        clientNickNameTxtField.textProperty().bindBidirectional(model.clientNicknameProperty());
    }

}
