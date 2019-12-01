package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Button b = new Button("Flick mich nicht");
        TextField t = new TextField();
        var items = Arrays.asList("Schnipp", "Schnapp", "Schnepp");
        ComboBox<String> c = new ComboBox<>(FXCollections.observableList(items));
        TextArea t2 = new TextArea("abcdef");
        t2.setFont(Font.font("Verdana", 20));
        c.selectionModelProperty().get().select(0);
        Scene scene = new Scene(new VBox(l, b, t, c, t2), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
