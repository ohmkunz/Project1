package fields;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MakeHead extends VBox {
	
	private ImageView icon;
	private Label headTitle; 
	
	public MakeHead(String iconName,String title) {
		setAlignment(Pos.CENTER);
		setSpacing(30);
		icon = new ImageView(new Image(ClassLoader.getSystemResource("icons/"+iconName+".png").toString()));
		getChildren().add(icon);
		
		
		Font f = Font.loadFont(ClassLoader.getSystemResource("font/thaisanslite.ttf").toExternalForm(), 60);
		this.headTitle = new Label(title);
		this.headTitle.setFont(f);
		this.headTitle.setStyle("-fx-text-fill:#B2B2B2;");

		getChildren().add(headTitle);
		

		
	}
	
}
