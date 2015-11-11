package client.model;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Rusty on 09.11.2015.
 */
public class ClientModel {

    Socket client;
    PrintWriter writer;
    BufferedReader reader;

    private String serverPort;
    private String serverIP;
    private String clientNickName;
    private String clientMessage;


    public String getServerPort() {
        return this.serverPort;
    }

    public String getServerIP() {
        return this.serverIP;
    }

    public String getClientNickName() {
        return this.clientNickName;
    }

    public String getClientMessage() {
        return this.clientMessage;
    }


}
