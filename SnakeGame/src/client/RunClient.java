package client;

import client.model.ClientModel;
import client.presenter.ClientPresenter;
import client.view.ClientView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Rusty on 09.11.2015.
 */

public class RunClient extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        ClientModel model = new ClientModel();
        ClientView view = new ClientView(model);
        ClientPresenter presenter = new ClientPresenter(model, view);

        Scene scene = new Scene(view, 800, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Chat");
        primaryStage.show();
    }

}
