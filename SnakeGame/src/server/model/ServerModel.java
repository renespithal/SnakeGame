package server.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import server.view.ServerView;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Created by Rusty on 09.11.2015.
 */
public class ServerModel {

    ServerSocket server;
    ArrayList<PrintWriter> list_clientWriter;

    private IntegerProperty serverPort = new SimpleIntegerProperty(this, "serverPort", 8888);


    public final int getServerPort() {
        return serverPort.get();
    }


    public final void setServerPort(int serverPort) {
        this.serverPort.set(serverPort);
    }


    public final IntegerProperty serverPortProperty() {
        return serverPort;

    }
}