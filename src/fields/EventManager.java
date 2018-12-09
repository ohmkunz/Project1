package fields;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import pages.Home;
import pages.RentList;
import pages.RentPage;
import pages.ReturnList;
import pages.ReturnPage;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.stage.Stage;
import fields.MyException;
public class EventManager {
	
	private RentList rentList;
	private RentPage rentPage;
	private Inventory inventory;
	private ReturnList returnList;
	private ReturnPage returnPage;
	private Home home;
	private String name;
	private String tel;
	public EventManager(Home home,RentList rentList,RentPage rentPage,ReturnList returnList,ReturnPage returnPage,Inventory inventory) {
		this.rentPage =rentPage;
		this.rentList=rentList;
		this.inventory = inventory;
		this.returnPage=returnPage;
		this.returnList=returnList;
		this.home = home;
	}
	
	public void setUpCalculateBtn(Button calculateBtn) {
		calculateBtn.setOnAction(new calculateBtnEventHandler());
	}
	public void setUpComfirmbtn(Button confirm) {
		confirm.setOnAction(new confirmBtnEventHandler());
	}
	
	public void goBtn(Button goBtn,Stage stage, Scene scene,StackPane s) {
		
		goBtn.setOnAction(e-> {
			
			
			
				// TODO Auto-generated method stub
				
				try {
					String error = "";
					this.name = home.getName();
					this.tel = home.getTel();
					
					if (name.equals("")|isNumeric(name)) {
						error+="-Please input your name in right way (not include digit in your name).";
					}if (!checkTel(tel)|tel.length()!=10) {
						error+="\n-Please input your tel no. in right way (not include char in your tel and your tel must be in length 10 ).";
					}if(tel.length()>2 && !tel.substring(0, 2).equals("08") && !tel.substring(0, 2).equals("09")) {
						error+="\n-Tel. Form must be 08XXXXXXXX or 09XXXXXXXX";
					}
					if (!error.equals("")) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						
						alert.setContentText(error);
						alert.showAndWait();
						error="";
						return;
					}
					this.home.clearName();
					this.home.clearTel();
					
				}catch(Exception ect){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setContentText("please input all field");
					alert.showAndWait();
					
				}
				FadeTransition fade = new FadeTransition();
				fade.setDuration(javafx.util.Duration.millis(700));
				fade.setNode(s);
				fade.setFromValue(0.2);
				fade.setToValue(1);
				fade.play();
				
				stage.setScene(scene);
				
			
		});
		
			
			
		
		
		
	}
	
	private class calculateBtnEventHandler implements EventHandler<ActionEvent>{
		
		public calculateBtnEventHandler() {
			//inventory = new Inventory(loanpage);
		}
		@Override
		public void handle(ActionEvent arg0) {
			try {
				//inventory = new Inventory(loanpage.getDVDNameCombobox(),loanpage.getTheNumberToLoan(),loanpage.getDay());
				//inventory = new Inventory(loanpage);
				double price = inventory.rentDVD(rentPage.getDVDNameCombobox(), rentPage.getDay(), rentPage.getTheNumberToRent());
	/* if (price<0) {
					return;
				}*/
				rentList.addData(name, tel, rentPage.getDVDNameCombobox(), price,rentPage.getTheNumberToRent());
				//loanpageright.addData(loanpage.getDVDNameCombobox(),""+loanpage.getTheNumberToLoan(), loanpage.getDiscount(), 8);
			}catch(MyException myException) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText(myException.toString().trim().replace("fields.MyException: ", ""));
				alert.showAndWait();
			}catch(Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("please input all field");
				alert.showAndWait();
			}
		}
	}
	
	private class confirmBtnEventHandler  implements EventHandler<ActionEvent> {
		
		public confirmBtnEventHandler() {
			
		}

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				
				
				
				if (inventory.returnDVD(returnPage.getDVDNameCombobox(), returnPage.getNumberCombobox())) {
					returnList.addData(returnPage.getDVDNameCombobox(), returnPage.getNumberCombobox(),name,tel);
					return;
				
				}
				
				
				//int numberToreturn;
				//returnList.addData(returnPage.getDVDNameCombobox(), returnPage.getNumberCombobox(),name,tel);
				//rentList.addData(home.getName(),home.getTel(),rentPage.getDVDNameCombobox(),returnPage.getNumberCombobox() );
				//loanpageright.addData(loanpage.getCustomerName(), loanpage.getCustomerTel(), loanpage.getDVDNameCombobox(), price);
				//loanpageright.addData(loanpage.getDVDNameCombobox(),""+loanpage.getTheNumberToLoan(), loanpage.getDiscount(), 8);
			}catch(MyException myException) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText(myException.toString().trim().replace("fields.MyException: ", ""));
				alert.showAndWait();
			
			}catch(Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("please input all field");
				alert.showAndWait();
			}
		}
	}
	
	public void RentBtn(Button RentBtn, Stage stage, Scene scene,StackPane s) {
		RentBtn.setOnAction(e-> {
			
			FadeTransition fade = new FadeTransition();
			fade.setDuration(javafx.util.Duration.millis(700));
			fade.setNode(s);
			fade.setFromValue(0.2);
			fade.setToValue(1);
			fade.play();
			
			stage.setScene(scene);
			
		});
	}
	
	public void ReturnBtn(Button returnBtn, Stage stage, Scene scene,StackPane s) {
		returnBtn.setOnAction(e-> {
			
			FadeTransition fade = new FadeTransition();
			fade.setDuration(javafx.util.Duration.millis(700));
			fade.setNode(s);
			fade.setFromValue(0.2);
			fade.setToValue(1);
			fade.play();
			
			stage.setScene(scene);
			
		});
	}
	
	public void BackBtn(Button backBtn, Stage stage, Scene scene,StackPane s) {
		backBtn.setOnAction(e-> {
			rentPage.clearSelection();
			returnPage.clearSelection();
			FadeTransition fade = new FadeTransition();
			fade.setDuration(javafx.util.Duration.millis(700));
			fade.setNode(s);
			fade.setFromValue(0.2);
			fade.setToValue(1);
			fade.play();
			
			stage.setScene(scene);
			
		});
	}
	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (Character.isDigit(c)) return true;
	    }
	    return false;
	}
	public static boolean checkTel(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}


}
