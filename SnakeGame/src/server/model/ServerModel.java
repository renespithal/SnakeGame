package server.model;

import server.view.ServerView;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Created by Rusty on 09.11.2015.
 */
public class ServerModel {

    private ServerModel model;
    private ServerView view;
    private int serverPort;
    ServerSocket server;
    ArrayList<PrintWriter> list_clientWriter;
}
