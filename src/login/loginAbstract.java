package login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

abstract class loginAbstract {
	private Button login;
	private Group loginFields;
	private  PasswordField password = new PasswordField();
	private Label message = new Label();

	public abstract void authenticate();
	public Scene display() {
		
		
		//Reg fields and locations
		
				Text signIn = new Text("Please Sign In Below\nHint: Enter the password 'premium'\nto enter advertiser area.\nAny other password will\n"
						+ "take you to the regular user area");
				signIn.setX(240);signIn.setY(180);
				Text emailLabel = new Text("Email:");emailLabel.setX(150);emailLabel.setY(350);
				TextField email = new TextField(); email.setPromptText("Email"); email.setLayoutX(230); email.setLayoutY(320);
				Text passwordLabel = new Text("Password:"); passwordLabel.setLayoutX(150); passwordLabel.setLayoutY(400);
				setPassword(new PasswordField()); getPassword().setPromptText("Password"); getPassword().setLayoutX(230); getPassword().setLayoutY(380);
			
				
				
				login = new Button("Sign in"); login.setLayoutX(250);login.setLayoutY(205);
				
				
				
				
				
				
				
				//Logo
				ImageView logo = new ImageView("file:src\\logo.png");
				logo.setFitWidth(300);logo.setFitHeight(90); logo.setLayoutX(130);logo.setLayoutY(20);
				
				
		
		
		
		
		
		
		
		
		
		
				loginFields = new Group(email, logo, emailLabel, passwordLabel, signIn, getPassword(), getMessage() );
				Scene loginScene = new Scene(loginFields, 600,800);
				return loginScene;

		
	}
	


	public PasswordField getPassword() {
		return password;
	}

	public void setPassword(PasswordField password) {
		this.password = password;
	}

	public Label getMessage() {
		return message;
	}

	public void setMessage(Label message) {
		this.message = message;
	}
}
