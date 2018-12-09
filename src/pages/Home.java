package pages;

import fields.ButtonField;
import fields.InputField;
import fields.MakeHead;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Home extends VBox{

	private MakeHead head;
	private InputField name;
	private InputField tel;
	private ButtonField go;
	public Home() {
		setAlignment(Pos.CENTER);
		setSpacing(30);
		setPadding(new Insets(15));
		
		this.head = new MakeHead("cd","WELCOME"); 
		
		
		this.name = new InputField("Name :", "Input Your Name", "user");
		this.tel = new InputField("Tel. :", "Input Your Tel. No.", "tel");
 		
		this.go = new ButtonField("Go", "#2dbf64");
		
		getChildren().addAll(head,name,tel,go);
		
		
	}
	public String getName() {
		return name.getText().trim();
	}
	public String getTel() {
		return tel.getText().trim();
	}
	public Button getGo() {
		return go.getButton();
	}
	public void clearName() {
		this.name.clear();;
	}
	public void clearTel() {
		this.tel.clear();
	}
	
	
	
}
