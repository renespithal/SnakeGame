package network.server.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import network.server.model.ClientInfo;

public class ServerView extends Tab {
	// Controls
	private Label portLabel;
    private TextField portTxtField;
    private Button startButton;
    private Button interruptButton;
    private TextArea textArea;

    // Table
    private TableView<ClientInfo> clientInfoTable;
    private TableColumn<ClientInfo, String> clientIPColumn ;
    private TableColumn<ClientInfo, Integer> clientPortColumn ;
    private TableColumn<ClientInfo, String> clientNicknameColumn ;
    
    public ServerView()
    {
    	super("Server");
    	portLabel = new Label("Port: ");
        portTxtField = new TextField();
        startButton = new Button("Start");
        interruptButton = new Button("Interruptible");
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(portLabel, 0, 0);
        gridPane.add(portTxtField, 1, 0, 2, 1);
        gridPane.add(startButton, 0, 2);
        gridPane.add(interruptButton, 2, 2);

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

        Label studentTableLabel = new Label("ClientInfo Table");
        VBox vBox = new VBox(10, studentTableLabel, clientInfoTable);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        
        textArea = new TextArea();
        
        VBox vBoxLayout = new VBox(gridPane,vBox,textArea);
        vBoxLayout.setMaxHeight(430);
        this.setContent(vBoxLayout);
 
    }
    
    public Button getStartButton() {
		return startButton;
	}
    
    public Button getInterruptButton() {
		return interruptButton;
	}
	
    public TextField getPortTxtField() {
		return portTxtField;
	}
    
    public TextArea getTextArea() {
		return textArea;
	}
}