package View;

import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class OptionWindow{
	
	Stage stage;
	Label titleLabel;
	Button backButton;
	VBox vBox;
	BorderPane borderPane;
	Scene scene;
	
	
	ComboBox<String> SpeedBox = new ComboBox<String>();    //Geschwindigkeit
	
	ComboBox<String> ColorBox = new ComboBox<String>();    //Farbe der Schlange
	
	/*ComboBox<String> LifeBox = new ComboBox<String>();   // Leben der Schlange (brauchen wir nicht unbedingt)
	 * 
	 *ComboBox<String> StageBox = new ComboBox<String>();  // Hintergrund aussuchen (brauchen wir nicht unbedingt)
	 */
	/*ChoiceBox music = new ChoiceBox();
	 music.getItems().addAll("on", "off"); */
	
	public OptionWindow(Stage primaryStage)
	{
		this.stage = primaryStage;
		
		titleLabel = new Label("Welcome to Options");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.GREEN);
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, null));
		titleLabel.setBorder(border);
		
		backButton = new Button("back to menu");
		backButton.setAlignment(Pos.BOTTOM_CENTER);
		backButton.setOnAction(e->returnToWelcomeWindow());

		SpeedBox.getItems().addAll("Fast","Normal","Slow");	
        SpeedBox.setValue("Normal");
        
        ColorBox.getItems().addAll("Green","Red","Blue","Black"); // Farbe der Schalnge
        ColorBox.setValue("Green");
        
       /* LifeBox.getItems().addAll("1","2","3","4","5"); // brauchen wir nicht unbedingt
        LifeBox.setValue("3");
        
        
        
      /*  BorderPane border = new BorderPane();
        HBox hbox = addHBox()
        border.setTop(hbox);
        border.setLeft(addVBox());
       // addStackPane(hbox);         // Add stack to HBox in top region

        border.setCenter(add());
        border.setRight(addvBox());
        border.setBottom(node);*/
        
		vBox = new VBox(titleLabel,SpeedBox,ColorBox,backButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(30);
		
		scene = new Scene(vBox, 500, 500);	
		
		
		stage.setScene(scene);
		stage.setTitle("Option");
	}
	
	protected void showOptionStage()
	{
		stage.show();
	}
	
	private void closeGameWindow() {
		Stage stage = (Stage) scene.getWindow();
		stage.close();
	}
	
	private void returnToWelcomeWindow()
	{
		closeGameWindow();
		WelcomeWindow welWin = new WelcomeWindow(stage);
		welWin.showWelcomeWindow();
	}
	
	public String getSpeedBoxValue(){
		return SpeedBox.getValue();
	}
	
	public ComboBox<String> getSpeedBox(){
		return SpeedBox;
	}
	
	public String getColorBoxValue(){
		return ColorBox.getValue();
	}
	
	public ComboBox<String> getColorBox(){
		return ColorBox;
	}
	
	/*public String getLifeBoxValue(){
		return LifeBox.getValue();
	}
	
	public ComboBox<String> getLifeBox(){
		return LifeBox;
	}	
	
	public String getStageBoxValue(){
	return StageBox.getValue();
    }

    public ComboBox<String> getStageBox(){
	return StageBox;
    }*/
	
}
