package options.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OptionsView extends BorderPane {

	//Controls
	private Label titleLabel;
	private Label speedLabel;
	private Button backButton;
	private ComboBox<String> speedBox = new ComboBox<String>();    //Geschwindigkeit
	private ComboBox<String> colorBox = new ComboBox<String>();    //Farbe der Schlange
	/*
	 *private ComboBox<String> StageBox = new ComboBox<String>();  // Hintergrund aussuchen (brauchen wir nicht unbedingt)
	 */
	/*ChoiceBox music = new ChoiceBox();
	 music.getItems().addAll("on", "off"); */
	
	public OptionsView()
	{

		//Images
		Image logo1 = new Image("file:src/images/yin.png", 50, 50, true, true);
		ImageView ivlogo1 = new ImageView();
		ivlogo1.setImage(logo1);

		Image logo2 = new Image("file:src/images/yin.png", 50, 50, true, true);
		ImageView ivlogo2 = new ImageView();
		ivlogo2.setImage(logo2);

		//Create Controls
		titleLabel = new Label("Welcome to Options");
		//titleLabel.setAlignment(Pos.TOP_CENTER);
		titleLabel.setFont(new Font(32));
		titleLabel.setTextFill(Color.CORNFLOWERBLUE);
		Border border = new Border(new BorderStroke(Color.CORNFLOWERBLUE, BorderStrokeStyle.DOTTED, null, null));
		titleLabel.setBorder(border);
		//titleLabel.setFil;

		speedLabel = new Label ("Choose Speed:");
		speedLabel.setFont(new Font(13));
		
		backButton = new Button("back to menu");
		//backButton.setAlignment(Pos.BOTTOM_CENTER);

		//Create Options
		speedBox.getItems().addAll("Slow","Normal","Fast");	
        speedBox.setValue("Normal");

        colorBox.getItems().addAll("Green","Red","Blue","Black"); // Farbe der Schalnge
        colorBox.setValue("Green");

		//add Boxes to Border Pane
		HBox hBox1 = new HBox(ivlogo1,titleLabel,ivlogo2);
		hBox1.setAlignment(Pos.CENTER);

		VBox vBox2 =new VBox (speedLabel,speedBox);
		vBox2.setAlignment(Pos.CENTER);

		VBox vBox = new VBox(hBox1,vBox2,backButton);
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(10);

		this.setCenter(vBox);


		
	}
	
	public Button getBackButton()
	{
		return backButton;
	}

	public ComboBox<String> getSpeedBox() {
		return speedBox;
	}
}
