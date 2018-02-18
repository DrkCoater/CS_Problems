/**
 * 
 */
package us.csbu.cs540.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author JeremyLu
 *
 */
public class BorderLayoutUI extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(BorderLayoutUI.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// BorderPane pane = new BorderPane();
		// Button okButton = new Button("OK");
		// Button leftButton = new Button("Left");
		// Button rightButton = new Button("Right");
		//
		// TextField text = new TextField();
		// pane.setCenter(text);
		//
		// pane.setTop(addHBox());
		// pane.setCenter(okButton);
		// pane.setLeft(leftButton);
		// pane.setRight(rightButton);
		//
		// Scene scene = new Scene(pane);
		// primaryStage.setScene(scene);
		// primaryStage.setTitle("Border layout example...");
		// primaryStage.show();

		primaryStage.setTitle("Scene Example");
		FlowPane rootNode = new FlowPane();
		Label label = new Label("my example");
		rootNode.getChildren().add(label);
		Scene scene = new Scene(rootNode);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@SuppressWarnings("unused")
	private HBox addHBox() {

		HBox hbox = new HBox();
		hbox.setStyle("-fx-background-color: #333");
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10); // Gap between nodes

		Button buttonOk = new Button("Ok");
		buttonOk.setPrefSize(100, 20);

		Button buttonCancel = new Button("Cancel");
		buttonCancel.setPrefSize(100, 20);

		hbox.getChildren().addAll(buttonOk, buttonCancel);

		return hbox;
	}

}
