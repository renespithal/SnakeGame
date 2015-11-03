package network.server.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import network.server.model.ServerModel;
import network.server.view.ServerView;


public class ServerPresenter {
	
	private ServerModel model;
	private ServerView view;
	private ServerSocket serverSocket;
	private int port;
	public static int clients = 0;
	
	public ServerPresenter(ServerView view)
	{
		this.model = model;
		this.view = view;
		
		activateEvents();
	}

	private void activateEvents() {
		view.getStartButton().setOnAction(e->startServer());
		view.getInterruptButton().setOnAction(e->stopServer());
		
	}

	private void stopServer() {
		try {
			view.getTextArea().clear();
			if(serverSocket != null)
			{
			serverSocket.close();
			}
			else
			{
				view.getTextArea().setText("No JSONServer to closed.");
			}
		} catch (Exception e) {
		}
	}

	private void startServer() {
		try{
			view.getTextArea().clear();
		    port = Integer.parseInt(view.getPortTxtField().getText());
		    establish(port);
		}catch(Exception e){
			view.getTextArea().setText("Invalid port");
		}
	}
	
	public void establish(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    	view.getTextArea().clear();
        view.getTextArea().setText("JSONServer has been established on port " + port);

    }
	
	public void accept() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            Runnable r = new MyThreadHandler(socket);
            Thread t = new Thread(r);
            t.start();
        }
    }
	private static class MyThreadHandler implements Runnable {
        private Socket socket;

        MyThreadHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            clients++;
            System.out.println(clients + " JSONClient(s) connected on port: " + socket.getPort());

            try {
                // For JSON Protocol
                JSONObject jsonObject = receiveJSON();
                sendJSON(jsonObject);

            } catch (IOException | JSONException e) {

            } finally {
                try {
                    closeSocket();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void closeSocket() throws IOException {
            socket.close();
        }


        /**
         * use the JSON Protocol to receive a json object as
         * String from the client and reconstructs that object
         * @return JSONObejct with the same state (data) as
         * the JSONObject the client sent as a String msg.
         * @throws IOException
         * @throws JSONException 
         */
        public JSONObject receiveJSON() throws IOException, JSONException {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            String line = in.readLine();
            JSONObject jsonObject = new JSONObject(line);
            System.out.println("Got from client on port " + socket.getPort() + " " + jsonObject.toString(2));
            return jsonObject;
        }


        public void sendJSON(JSONObject jsonObject) throws IOException, JSONException {
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            out.write(jsonObject.toString() + "\n");
            out.flush();
            System.out.println("Sent to client on port " + socket.getPort() + " " + jsonObject.toString(2));
        }
    }

	

}
