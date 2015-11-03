package multiplayer.onlineMultiplayer.model;

import network.server.model.ClientInfo;
import network.server.model.ServerModel;

public class OnlineMultiplayerModel {
	
	private ClientInfo clientInfo;
	private ServerModel serverModel;
	
	public OnlineMultiplayerModel()

	{
		serverModel = new ServerModel();
	}
}
