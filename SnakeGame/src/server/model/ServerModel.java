package server.model;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

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