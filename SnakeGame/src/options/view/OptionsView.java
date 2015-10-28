package options.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OptionsView extends VBox {
	
	private Label titleLabel;
	private Button backButton;
	private BorderPane borderPane;
	private ComboBox<String> speedBox = new ComboBox<String>();    //Geschwindigkeit
	private ComboBox<String> colorBox = new ComboBox<String>();    //Farbe der Schlange
	
	/*ComboBox<String> LifeBox = new ComboBox<String>();   // Leben der Schlange (brauchen wir nicht unbedingt)
	 * 
	 *ComboBox<String> StageBox = new ComboBox<String>();  // Hintergrund aussuchen (brauchen wir nicht unbedingt)
	 */
	/*ChoiceBox music = new ChoiceBox();
	 music.getItems().addAll("on", "off"); */
	
	public OptionsView()
	{
		titleLabel = new Label("Welcome to Options");
		titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.GREEN);
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, null, null));
		titleLabel.setBorder(border);
		
		backButton = new Button("back to menu");
		backButton.setAlignment(Pos.BOTTOM_CENTER);
//		backButton.setOnAction(e->returnToWelcomeWindow());

		speedBox.getItems().addAll("Fast","Normal","Slow");	
        speedBox.setValue("Normal");
        
        colorBox.getItems().addAll("Green","Red","Blue","Black"); // Farbe der Schalnge
        colorBox.setValue("Green");
        
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
        
		this.getChildren().addAll(titleLabel,speedBox,colorBox,backButton);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(30);
		
	}
	
	public Button getBackButton()
	{
		return backButton;
	}

}
