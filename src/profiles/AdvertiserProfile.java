package profiles;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import registration.UserRegistration;

public class AdvertiserProfile implements ProfileInterface { //implemented interface
	private Group root = new Group();
	private TextField aboutField;
	private Text savedText = new Text("");
	//public UserRegistration userReg2 = new UserRegistration();
	@Override
	public void layOut() {
		//Top Tile
				TilePane topTile = new TilePane();
				topTile.setOrientation(Orientation.HORIZONTAL);
				topTile.setTileAlignment(Pos.CENTER_LEFT);
				ImageView logo = new ImageView("file:src\\logo.png");
				logo.setFitWidth(300);logo.setFitHeight(90);
				topTile.getChildren().addAll(logo);
		//Mid Tile
				TilePane middleTile = new TilePane();
				middleTile.setOrientation(Orientation.HORIZONTAL);
				middleTile.setTileAlignment(Pos.BASELINE_LEFT);
				Text about = new Text("About");
				 aboutField = new TextField(); aboutField.setPrefHeight(100);aboutField.setPrefWidth(200);
				
				Hyperlink editLink = new Hyperlink("Edit"); Hyperlink save = new Hyperlink("Save");
				middleTile.getChildren().addAll(about, editLink);
				middleTile.getChildren().add(savedText);
				middleTile.setLayoutX(100);middleTile.setLayoutY(400); middleTile.setHgap(30);middleTile.setPrefColumns(2); ;middleTile.setVgap(10);
				
				//Edit button
				editLink.setOnAction(new EventHandler<ActionEvent>(){
				public void handle (ActionEvent e) {
				middleTile.getChildren().removeAll(editLink);
				middleTile.getChildren().add(aboutField);
				middleTile.getChildren().add(save);
				
			
			;
			
		}});
				//Save button
				save.setOnAction(new EventHandler<ActionEvent>() {
					public void handle (ActionEvent s) {
						savedText.setText(aboutField.getText());
						middleTile.getChildren().removeAll(save);
						middleTile.getChildren().removeAll(aboutField);
						middleTile.getChildren().add(editLink);
						
					}
				});
				
				
				
				
				
				
				root.getChildren().addAll(topTile, middleTile);
		
	}

	@Override
	public Scene display() {
		layOut();
		Scene advertiserProfile = new Scene(root, 600,800);
		
		return advertiserProfile;
	}

}
