package ekko.ui;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DialogBox extends HBox {
    private Label text;
    private ImageView displayPicture;

    public DialogBox(String s, Image image) {
        text = new Label(s);
        displayPicture = new ImageView(image);
        this.getChildren().addAll(displayPicture, text);
    }
}