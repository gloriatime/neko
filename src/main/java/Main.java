import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        ImageView iView = new ImageView("/sit_still.gif");
        iView.setFitHeight(100);
        iView.setFitWidth(100);
        Pane root = new Pane(iView);
        Scene scene = new Scene(root, 100, 100);
        stage.setScene(scene);
        scene.setFill(null);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}