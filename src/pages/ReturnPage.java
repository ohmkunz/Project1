package pages;

import fields.ButtonField;
import fields.MakeHead;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ReturnPage extends HBox {
	private MakeHead head;
	
	private ComboBox<String> DVDNameCombobox;
	
	private ComboBox<String> NumberCombobox;
	private ReturnList returnList;
	
	private ButtonField confirm;
	private ButtonField back;
	public ReturnPage() {
		
		setAlignment(Pos.CENTER);
		setSpacing(30);
		setPadding(new Insets(15));
		
		head = new MakeHead("returnback", "Back 2 Us");
		//////////////
		VBox collector = new VBox();
		collector.setAlignment(Pos.CENTER);
		collector.setSpacing(30);
		collector.setPadding(new Insets(15));
		///////////////////
		
		
		DVDNameCombobox = new ComboBox<>();
		DVDNameCombobox.getItems().addAll("Lord of the ring","Harry potter","Game of throne",
				"Divergent", "Twilight", "Hungergame", "Percy jackson");
		DVDNameCombobox.setEditable(false);
		
		setupCombobox(DVDNameCombobox, "DVD List");
		/////////////////////////
		
		
		
		NumberCombobox = new ComboBox<>();
		NumberCombobox.getItems().addAll("1","2","3");
		NumberCombobox.setEditable(true);
		
		setupCombobox(NumberCombobox,"Number To Return");
		////////////////
		HBox choice = new HBox();
		choice.setAlignment(Pos.CENTER);
		choice.setSpacing(30);
		choice.setPadding(new Insets(15));
		
		back = new ButtonField("Back", "#d05d34");
		confirm = new ButtonField("Confirm", "#ffff8d");
		
		choice.getChildren().addAll(back,confirm);
		
		this.returnList = new ReturnList();
		this.returnList.setPrefWidth(500);
		
		
		collector.getChildren().addAll(head,DVDNameCombobox,NumberCombobox,choice);
		getChildren().addAll(collector,returnList);
	}
	
	public Button getBackBtn() {
		return back.getButton();
	}
	
	public String getDVDNameCombobox() {
		return DVDNameCombobox.getValue().toString();
	}
	
	public int getNumberCombobox() {
		return Integer.parseInt(NumberCombobox.getValue().toString());
	}
	
	public Button getConfirm() {
		return confirm.getButton();
	}

	public ReturnList getReturnList() {
		return returnList;
	}
	
	public void clearSelection() {
		DVDNameCombobox.getSelectionModel().clearSelection();;
		NumberCombobox.getSelectionModel().clearSelection();
	}
	public <T> void setupCombobox(ComboBox<T> comboBox,String promptText) {
		
		
		comboBox.setStyle("-fx-font-family:thaisanslite;"
				+ "-fx-color:#B2B2B2;"
				+ "-fx-font-size : 15pt;"
				+"src:url(font/supermarket.tff);"
				+ "-fx-pref-height: 40px;"
				+ "-fx-pref-width: 300px;"
				+ "-fx-background-color:#FFFFFF;");
		comboBox.setPromptText(promptText);
		
	}
}
