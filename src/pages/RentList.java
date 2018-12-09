package pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RentList extends StackPane {
	private ObservableList<Label> logDataList = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	private int Number = 1;
	
	public RentList() {
		setBorder(new Border(new BorderStroke(Color.web("#b2b2b2"), BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			setPrefWidth(400);
			logListView = new ListView<Label>(logDataList);
			logListView.setPrefWidth(250);
			logListView.setFocusTraversable(true);
			logListView.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			logListView.setPlaceholder(new Label(""));
			
			getChildren().add(logListView);
	}
	
	public void addData(String name, String tel, String DVDName, double price,int loanNumber) {
		
		Font f = Font.loadFont(ClassLoader.getSystemResource("font/thaisanslite.ttf").toExternalForm(), 25);
		
		Label newLabel = new Label(Number++ + ". " + name + " Tel." + tel + "\nrent "+loanNumber+ " of "+ DVDName + " .Price is " + price + " bath .");
		newLabel.setFont(f);
		newLabel.setStyle("-fx-text-fill:#2A2E37;"
				+ "fx-font-size:10px");
		logDataList.add(newLabel);
		logListView.scrollTo(newLabel);
	}

}
