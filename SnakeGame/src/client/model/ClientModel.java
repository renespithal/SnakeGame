package client.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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


private StringProperty clientMessage = new SimpleStringProperty(this, "clientMessage");

    private final StringProperty serverIP =
            new SimpleStringProperty(this, "serverIP", "localhost");



    private final StringProperty clientNickName =
            new SimpleStringProperty(this, "clientNickname", "Test");


    private IntegerProperty serverPort = new SimpleIntegerProperty(this, "serverPort", 8888);



    public final String getClientMessage(){
        return clientMessage.get();
    }

    public final StringProperty clientMessage(){
        return  clientMessage;
    }


    public final int getServerPort(){
        return serverPort.get();
    }


    public final void setServerPort(int serverPort){
        this.serverPort.set(serverPort);
    }


    public final IntegerProperty serverPortProperty(){
        return serverPort;
    }
    public final String getServerIP(){
        return serverIP.get();
    }
    public void setServerIP(String serverIP){
        this.serverIP.set(serverIP);
    }
    public final StringProperty serverIPProperty(){
        return serverIP;
    }



    // setter, getter & property accessor.
    public final String getClientNickname(){
        return clientNickName.get();
    }
    public void setClientNickname(String nickname){
        this.clientNickName.set(nickname);
    }
    public final StringProperty clientNicknameProperty(){
        return clientNickName;
    }

}




