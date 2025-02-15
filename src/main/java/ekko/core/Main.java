package ekko.core;

import ekko.ui.Ekko;
import java.io.IOException;

import ekko.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Ekko ekko = new Ekko();

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            if (fxmlLoader.getLocation() == null) {
                throw new IOException("FXML file not found: /view/MainWindow.fxml");
            }
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setTitle("Ekko Chatbot");
            fxmlLoader.<MainWindow>getController().setEkko(ekko);
            stage.setOnCloseRequest(event -> System.exit(0)); // Ensure proper exit
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading MainWindow.fxml. Check the file path.");
            e.printStackTrace();
        }
    }
}
