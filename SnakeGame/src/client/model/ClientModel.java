package client.model;

import javafx.beans.property.SimpleStringProperty;

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


    private SimpleStringProperty clientMessage= new SimpleStringProperty();
    private SimpleStringProperty clientNickName = new SimpleStringProperty();
    private SimpleStringProperty serverIP = new SimpleStringProperty();
    private SimpleStringProperty serverPort = new SimpleStringProperty();



    public SimpleStringProperty getServerIP(){ return this.serverIP;}

    public SimpleStringProperty getServerPort() { return this.serverPort;}

    public SimpleStringProperty getClientNickName(){ return this.clientNickName;}

    public SimpleStringProperty getClientMessage(){ return this.clientMessage;}



}
