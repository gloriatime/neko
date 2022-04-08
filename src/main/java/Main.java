import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ImageView iView = new ImageView("/sit_still.gif");
        iView.setFitHeight(100);
        iView.setFitWidth(100);

        Pane root = new Pane(iView);

        Scene scene = new Scene(root, 100, 100);

        SystemTray tray = SystemTray.getSystemTray();
        MenuItem itemExit = new MenuItem("exit");
        itemExit.addActionListener(e -> System.exit(0));
        PopupMenu popMenu = new PopupMenu();
        popMenu.add(itemExit);

        try{
            BufferedImage imageIcon = ImageIO.read( getClass().getResourceAsStream("icon_tray.png") );
            TrayIcon trayIcon = new TrayIcon(imageIcon,"neko",popMenu);
            trayIcon.setImageAutoSize(true);
            tray.add(trayIcon);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        stage.setScene(scene);
        scene.setFill(null);
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}