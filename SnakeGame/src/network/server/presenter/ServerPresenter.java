package network.server.presenter;

import network.server.model.ServerModel;
import network.server.view.ServerView;

public class ServerPresenter {
	
	private ServerModel model;
	private ServerView view;
	
	public ServerPresenter(ServerModel model, ServerView view)
	{
		this.model = model;
		this.view = view;
		
		activateEvents();
	}

	private void activateEvents() {
		view.getStartButton().setOnAction(e->startServer());
		view.getInterruptButton().setOnAction(e->stopServer());
		
	}

	private Object stopServer() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object startServer() {
		// TODO Auto-generated method stub
		return null;
	}

}
