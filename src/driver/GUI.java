package driver;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.UserLogin;
import profiles.UserProfileInput;
import registration.UserRegistration;

public class GUI extends Application { //inheritance

private UserProfileInput userProfile = new UserProfileInput();
private UserLogin loginScreen = new UserLogin();
public static Stage myStage;

	public static void main(String[] args) {
		launch(args);
		 

	}
	@Override
	public void start(Stage primaryStage) throws Exception{

	 
		myStage = primaryStage;
		myStage.setScene(userProfile.userReg2.regFields());
		
		//myStage.setScene(loginScreen.display());
		
        myStage.setTitle("RealConnect");
        myStage.show();
       
	}

}
