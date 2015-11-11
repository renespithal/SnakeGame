package server.model;

import javafx.beans.property.SimpleIntegerProperty;
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

    private SimpleIntegerProperty serverPort = new SimpleIntegerProperty();

    public SimpleIntegerProperty getServerPort(){ return  this.serverPort;}

    public void setServerPort(SimpleIntegerProperty serverPort) {
        this.serverPort = serverPort;
    }
}
