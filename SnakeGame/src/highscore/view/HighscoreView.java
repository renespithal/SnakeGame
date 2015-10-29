package highscore.view;

import javafx.beans.binding.StringBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos; 
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import highscore.model.HighscoreModel;


public class HighscoreView extends BorderPane{
	
	private HighscoreModel model;
		
	private Label titleLabel;
    TextField namefield;
    TextField txtname;
	private Button getbackButton;
	private Button clearButton;
	private Button saveButton;
	//TextArea writename;
	
	TableView<HighscoreModel> highscoreTable;
	TableColumn<HighscoreModel, String> name ;
	TableColumn<HighscoreModel, Integer> highscore ;
	
	public HighscoreView ()
	{
		titleLabel = new Label("Highscore");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.GOLD);
		Border border = new Border(new BorderStroke(Color.GOLD, BorderStrokeStyle.DOTTED,null, null));
		titleLabel.setBorder(border);
		
		TextField namefield = new TextField("Enter Name: ");
		namefield.setAlignment(Pos.TOP_CENTER);
		
		txtname = new TextField();
		txtname.setAlignment(Pos.CENTER);
		txtname.setMaxWidth(200);
		
		//writename = new TextArea();
		
	    saveButton = new Button("Save");
	    saveButton.setAlignment(Pos.CENTER);
		saveButton.setMaxWidth(200);
		
	    clearButton = new Button("Clear");
	    clearButton.setAlignment(Pos.CENTER);
		clearButton.setMaxWidth(200);
			
		getbackButton = new Button("back to menu");
		getbackButton.setAlignment(Pos.CENTER);
		getbackButton.setMaxWidth(200);
		
		/*GridPane gridPane = new GridPane();
	    gridPane.setHgap(10);
	    gridPane.setVgap(5);
	    gridPane.add(namefield, 1, 1);
	    gridPane.add(txtname, 1, 0, 10, 1);
	    gridPane.add(saveButton, 0, 2);
	    gridPane.add(clearButton,1, 2);
	    gridPane.add(getbackButton, 2, 2);*/
	    
	    highscoreTable = new TableView<HighscoreModel>();

	    name = new TableColumn<HighscoreModel, String>("Name");
	    name.setMaxWidth(100);
	    name.setCellValueFactory(new PropertyValueFactory<HighscoreModel, String>("Name"));

	    highscore = new TableColumn<HighscoreModel, Integer>("Highscore");
	    highscore.setMinWidth(100);
	    highscore.setCellValueFactory(new PropertyValueFactory<HighscoreModel, Integer>("Highscore"));
	    
	    /*VBox vBox = new VBox(); 
		Label highscore = new Label();
		highscore.textProperty().bind(new StringBinding() {
			{ bind(model.getHighscore().getValueProperty()); }
			
			@Override
			protected String computeValue() {
				return "Highscore: "+model.getHighscore().getValue();
			}*/

	    highscoreTable.getColumns().addAll(name, highscore);
	   
	    VBox vBox = new VBox();
        vBox.getChildren().addAll(highscoreTable);
	    
	    HBox hBox = new HBox();
        hBox.getChildren().addAll(namefield, txtname, saveButton, clearButton,vBox);
	    
  
       /* Label label1 = new Label("Name:");
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);*/
        
        
        // Add the HBox and GridPane to the BorderPane
        this.setTop(titleLabel);
        this.setCenter(vBox);
        this.setBottom(getbackButton);
        

	}
		
	public TableView<HighscoreModel> gethighscoreTable() 
	{
	    return highscoreTable;
    }
	
	public Button saveButton()
	{
		return saveButton;
	}
	 
	public Button clearButton()
	{
		return clearButton;
	}
	
	public Button getBackButton()
	{
		return getbackButton;
	}
		
}

