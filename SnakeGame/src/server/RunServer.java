package server;

import javafx.scene.image.Image;
import server.model.ServerModel;
import server.presenter.ServerPresenter;
import server.view.ServerView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Rusty on 09.11.2015.
 */
public class RunServer extends Application {


    @Override

    public void start(Stage primaryStage) throws Exception {

        ServerModel model = new ServerModel();
        ServerView view = new ServerView(model);
        ServerPresenter s = new ServerPresenter(model, view);


        
        Scene scene = new Scene(view, 600, 500);

        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:src/images/yinyanyolologo2.png"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Server");
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
