package registration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.animation.KeyFrame;
import driver.GUI;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import login.UserLogin;
import profiles.UserProfileInput;

public class UserRegistration  {
    //private UserProfileInput userView = new UserProfileInput();
    public boolean registered = false;
	private Group loginFields;
	public Button register;
	private Timeline timer;
	private Text successMsg = new Text("");
	public static ArrayList<String> imAnArrayList = new ArrayList<String>();
	private String[][] userTable = new String[20][3]; //2D Array that allows for 20 users, each 3 property columns

	public Scene regFields() {
		
		//Text for grading
		Text myText = new Text("The timer class can be found ");
		
		//Reg fields and locations
		Text emailLabel = new Text("Email:");emailLabel.setX(150);emailLabel.setY(150);
		TextField email = new TextField(); email.setPromptText("Email"); email.setLayoutX(200); email.setLayoutY(130);
		TextField firstName = new TextField(); firstName.setPromptText("First Name"); firstName.setLayoutX(100); firstName.setLayoutY(170);
		TextField lastName = new TextField();lastName.setPromptText("Last Name");lastName.setLayoutX(290);lastName.setLayoutY(170);
		register = new Button("Register"); register.setLayoutX(250);register.setLayoutY(205);
		Button facebookLogin = new Button("Login with Facebook"); facebookLogin.setLayoutX(215);facebookLogin.setLayoutY(245);
		
		//Login Button
		Button signIn = new Button("Already a member? Sign In");signIn.setLayoutX(200);signIn.setLayoutY(350);
		signIn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {

				Timeline loginDelay = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {

				    @Override
				    public void handle(ActionEvent event) {
				    	
				    	UserLogin loginScreen = new UserLogin();
						GUI.myStage.setScene(loginScreen.display());
						loginScreen.authenticate();
						
				    }
				}));
				loginDelay.setCycleCount(1);
				loginDelay.play();
				successMsg.setText("You will be redirected in 5 seconds\nPlease wait!");
				
			}
		});
		
		
		
		
		//Logo
		ImageView logo = new ImageView("file:src\\logo.png");
		logo.setFitWidth(300);logo.setFitHeight(90); logo.setLayoutX(130);logo.setLayoutY(20);
		
		/*---------------*/
		
		//Register button info capture
		
		//Reg Error
		Text errorMsg = new Text("");
		errorMsg.setFill(Color.RED); errorMsg.setLayoutX(200); errorMsg.setLayoutY(450);
		
		//Reg Success
		
		successMsg.setFill(Color.GREEN); successMsg.setLayoutX(190); successMsg.setLayoutY(470);
		
		
		String[] regInfoArray = new String [3];  //Object array
		 
		
		register.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(email.getText().isEmpty() || firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
					errorMsg.setText("*You must complete all fields");
				} else { //Successful Registration
					
					//Adding elements to String Object Array
					regInfoArray[0] = email.getText();
					regInfoArray[1] = firstName.getText();
					regInfoArray[2]= lastName.getText();
					//Adding same elements to an ArrayList
					imAnArrayList.addAll(Arrays.asList(email.getText(), firstName.getText(), lastName.getText()));
					
					//2D array implementation
					userTable[0][0] = email.getText();
					userTable[0][1] = firstName.getText();
					userTable[0][2] = lastName.getText();
					
					//Timer that delays login upon successful registration
					
					Timeline loginDelay = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {

					    @Override
					    public void handle(ActionEvent event) {
					    	
					    	UserProfileInput loggedIn = new UserProfileInput();
							GUI.myStage.setScene(loggedIn.display());
							
					    }
					}));
					loginDelay.setCycleCount(1);
					loginDelay.play();
					
				
					
					successMsg.setText("You will be redirected in 5 seconds");
					
					
					
				}
			}});
		
		/*---------------*/
		
		//Facebook login button - generates random tokens as a facebook login
		
		int[] token = new int[1]; //Primitive array
		facebookLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Random rand = new Random();
				token[0] = rand.nextInt(255)+10;
				successMsg.setText("Success! But FB login is currently unavailable");
				
				
			}});
		
		loginFields = new Group(email, firstName, lastName, facebookLogin, logo, register, errorMsg, successMsg, emailLabel, signIn);
		Scene registration = new Scene(loginFields, 600,800);
		return registration;
		}
	
	
	
	
	
	
}
