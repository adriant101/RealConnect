package login;
import driver.GUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import profiles.AdvertiserProfile;
import profiles.UserProfileInput;

public class UserLogin extends loginAbstract {//Abstract class implementation
	

	@Override
	public void authenticate() {
		
		getPassword().setOnAction(new EventHandler<ActionEvent>()
		{public void handle (ActionEvent e) {
			if (!getPassword().getText().equals("premium")) {
				UserProfileInput loggedIn = new UserProfileInput();
				GUI.myStage.setScene(loggedIn.display());
	           
	        } else {
	            AdvertiserProfile loggedIn = new AdvertiserProfile();
	            GUI.myStage.setScene(loggedIn.display());
	        }
	        getPassword().clear();
	    }
		
		});
		 
		
	}
	
	
	

}
