package pages;

import fields.EventManager;
import fields.Inventory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		
		
		
	
		primaryStage.setResizable(false);
		
		
		
		StackPane s1 = new StackPane();
		s1.setStyle("-fx-background-color:#2A2E37;");//2A2E37
		Home home = new Home();
		s1.getChildren().add(home);
		Scene scene1 = new Scene(s1,1000, 800);

		
		
		StackPane s2 = new StackPane();
		s2.setStyle("-fx-background-color:#2A2E37;");//2A2E37
		Choose choose = new Choose();
		s2.getChildren().add(choose);
		Scene scene2 = new Scene(s2,1000, 800);
		
		
		StackPane s3 = new StackPane();
		s3.setStyle("-fx-background-color:#2A2E37;");//2A2E37
		RentPage rentPage = new RentPage();
		s3.getChildren().add(rentPage);
		Scene scene3 = new Scene(s3,1000,800);
		
		
		StackPane s4 = new StackPane();
		s4.setStyle("-fx-background-color:#2A2E37;");//2A2E37
		ReturnPage returnPage = new ReturnPage();
		s4.getChildren().add(returnPage);
		Scene scene4 = new Scene(s4,1000,800);
		
		Inventory inventory = new Inventory(rentPage);
        EventManager event = new EventManager(home,rentPage.getRentList(),rentPage,returnPage.getReturnList(),returnPage,inventory);
        event.goBtn(home.getGo(), primaryStage, scene2,s2);
        event.RentBtn(choose.getRent(), primaryStage, scene3,s3);
        event.BackBtn(choose.getBack(), primaryStage, scene1,s1);
        event.BackBtn(rentPage.getBackBtn(), primaryStage, scene2,s2);
        event.setUpCalculateBtn(rentPage.getCalculationBtn());
        event.setUpComfirmbtn(returnPage.getConfirm());
        //event.CalculateBtn(loanpage.getCalculationBtn());
        event.BackBtn(returnPage.getBackBtn(), primaryStage, scene2,s2);
        event.ReturnBtn(choose.getReTurn(), primaryStage, scene4,s4);
		
		primaryStage.setScene(scene1); // Place the scene ///<----
		primaryStage.setTitle("Progmeth Project");
		
		
		
		
	
		
        
		
        
        
		primaryStage.show();
	}
	public static void main(String [] args) {
		launch(args);
	}

}
