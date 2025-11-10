package en.unideb.inf.SpringDataFX.frontend;

import en.unideb.inf.SpringDataFX.SpringBackendManager;
import en.unideb.inf.SpringDataFX.SpringDataFxApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFXApplication extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainPage.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        ((MainPageController)loader.getController()).setBackendManager(new SpringBackendManager());
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
