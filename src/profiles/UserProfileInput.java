package profiles;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import registration.UserRegistration;

public class UserProfileInput implements ProfileInterface { //implemented interface
	private Group root = new Group();
	public UserRegistration userReg2 = new UserRegistration();
	@Override
	public void layOut() {
		//Top Tile
		TilePane topTile = new TilePane();
		topTile.setOrientation(Orientation.HORIZONTAL);
		topTile.setTileAlignment(Pos.CENTER_LEFT);
		ImageView logo = new ImageView("file:src\\logo.png");
		logo.setFitWidth(300);logo.setFitHeight(90);
		
		//Welcome arrayList needs to account for members that already exist and come in through the login screen.
		//Text welcome = new Text("Welcome, "+ userReg2.imAnArrayList.get(1) + " " + userReg2.imAnArrayList.get(2)); 
		
		topTile.getChildren().addAll(logo); //welcome);
		
		
		//Middle Tile
		TilePane middleTile = new TilePane();
		middleTile.setOrientation(Orientation.VERTICAL);
		middleTile.setTileAlignment(Pos.CENTER);
		middleTile.setPadding(new Insets(20,20,20,20));
		middleTile.setLayoutX(180);middleTile.setLayoutY(100);
		ImageView blankImg = new ImageView("file:src\\blank.png");
		blankImg.setFitWidth(200); blankImg.setFitHeight(200);
		
		Text regularUser = new Text("Regular User Area");
		middleTile.getChildren().addAll(blankImg, regularUser);
		
		
		root.getChildren().addAll(topTile,middleTile);
		
	}

	@Override
	public  Scene display() {
		layOut();
		Scene profileScene = new Scene(root, 600,800);
		
		
		return profileScene;
	}

}
