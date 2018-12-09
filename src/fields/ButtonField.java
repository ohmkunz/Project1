package fields;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class ButtonField extends HBox {
	private Button button;
	private ImageView imageView;
	public ButtonField(String text,String colorCode) {
		//text = "Create a new account";
		setAlignment(Pos.CENTER);
		imageView = new ImageView(new Image(ClassLoader.getSystemResource("icons/"+text+".png").toString()));
		this.button = new Button(text,imageView);
		button.setContentDisplay(ContentDisplay.LEFT);
		setButton(this.button);
		btnLoop(colorCode,text);
		getChildren().add(button);
	}
	
	private Button setButton(Button b) {
		
		Font f = Font.loadFont(ClassLoader.getSystemResource("font/thaisanslite.ttf").toExternalForm(), 20);
		b.setFont(f);
		Rectangle shape = new Rectangle(250,25);
		shape.setArcWidth(30);
		shape.setArcHeight(30);
		b.setShape(shape);
		
		
		return b;
	}
	private void btnLoop(String colorCode,String text) {
		this.button.setStyle("-fx-pref-width: 250px;"
				+ "-fx-pref-height: 40px;"
				+ "-fx-background-color:#2A2E37;"
				+ "-fx-border-color:"+colorCode+";"
				+ "-fx-border-radius:5px;"
				+ "-fx-text-fill:#B2B2B2;");
		this.button.setOnMouseEntered(e -> this.button.setStyle("-fx-pref-width: 250px;"
				+ "-fx-pref-height: 40px;"
				+ "-fx-text-fill:#2A2E37;"
				+ "-fx-background-color:"+colorCode+";"
				+"-fx-graphic:url(icons/"+text.replaceAll(" ", "%20")+"-m"+".png);"));
		this.button.setOnMouseExited(e -> this.button.setStyle("-fx-pref-width: 250px;"
				+ "-fx-pref-height: 40px;"
				+ "-fx-background-color:#2A2E37;"
				+ "-fx-border-color:"+colorCode+";"
				+ "-fx-border-radius:5px;"
				+ "-fx-text-fill:#B2B2B2;"));
	}

	public Button getButton() {
		return button;
	}
	
	
	
	
}
