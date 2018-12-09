package fields;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InputField extends HBox {
	
	private TextField textField;
	private PasswordField passwordField;
	private ImageView icon;
	private Group group = new Group();
	public InputField(String title, String promptText,String iconName) {
		setAlignment(Pos.CENTER);
		setPadding(new Insets(5));
		setSpacing(10);
		Font f = Font.loadFont(ClassLoader.getSystemResource("font/thaisanslite.ttf").toExternalForm(), 25);
		
		if (iconName!="") {
			icon = new ImageView(new Image(ClassLoader.getSystemResource("icons/"+iconName+".png").toString()));
			getChildren().add(icon);
			title = "  "+title;
		}
		
		Label label = new Label(title);
		label.setFont(f);
		label.setStyle("-fx-text-fill:#B2B2B2;"
				+ "fx-font-size:25px");
		
		
		if ((title.toLowerCase()).contains("password")) {
			passwordField = new PasswordField();
			
			passwordField.setPromptText(promptText);
			passwordField.setPrefWidth(250);
			passwordField.setStyle("-fx-background-color: transparent;"
					+ "-fx-text-fill:#B2B2B2;"
					+ "fx-font-size:25px;");
					
			passwordField.setFont(f);
			
			
			Line line = new Line(10,35,245,35);
			Color c = Color.web("#B2B2B2");
			line.setStroke(c);
			group.getChildren().addAll(line,passwordField);
		}else {
		
		textField=new TextField();
		textField.setPromptText(promptText);
		textField.setStyle("-fx-background-color: transparent;"
				+ "-fx-text-fill:#B2B2B2;"
				+ "fx-font-size:25px;");
		textField.setFont(f);
		
		
		Line line = new Line(10,35,245,35);
		Color c = Color.web("#B2B2B2");
		line.setStroke(c);
		group.getChildren().addAll(line,textField);
		}
		
		getChildren().add(label);
		getChildren().add(group);
	}

	public String getText() {
		
		return this.textField.getText().trim();
	}

	public String getPassword() {
		return this.passwordField.getText().trim();
	}
	
public void clear() {
	this.textField.setText("");
	
	}
public void clearPassword() {
	this.passwordField.setText("");
}
	
}
