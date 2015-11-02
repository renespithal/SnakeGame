package network.client.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClientModel {

	private IntegerProperty serverPort = new SimpleIntegerProperty(this, "serverPort", 9999);

    private final StringProperty serverIP =
            new SimpleStringProperty(this, "serverIP", "serverIP");

    private final StringProperty clientNickname =
            new SimpleStringProperty(this, "clientNickname", "nickname");

    public final int getServerPort(){
        return serverPort.get();
    }

    public final void setServerPort(int serverPort){
        this.serverPort.set(serverPort);
    }

    public final IntegerProperty serverPortProperty(){
        return serverPort;
    }

    // setter, getter & property accessor.
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
        return clientNickname.get();
    }
    public void setClientNickname(String nickname){
        this.clientNickname.set(nickname);
    }
    public final StringProperty clientNicknameProperty(){
        return clientNickname;
    }
}
