package pages;

import fields.ButtonField;
import fields.MakeHead;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Choose extends VBox {
	
	private MakeHead head;
	private ButtonField back;
	private ButtonField rent;
	private ButtonField reTurn;
	public Choose() {
		
		setAlignment(Pos.CENTER);
		setSpacing(30);
		setPadding(new Insets(15));
		
		this.head = new MakeHead("trade", "Choose Your Way");
		
		this.rent = new ButtonField("Rent", "#f88379");
		this.reTurn = new ButtonField("Return", "#49bdc1");
		this.back = new ButtonField("Back", "#f25d34");
		
		getChildren().addAll(head,rent,reTurn,back);
		
	}
	public Button getBack() {
		return back.getButton();
	}
	public Button getRent() {
		return rent.getButton();
	}
	public Button getReTurn() {
		return reTurn.getButton();
	}
	
	
}
