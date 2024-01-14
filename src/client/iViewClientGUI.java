package client;

public interface iViewClientGUI {

    void sendMessage(String message);
    void connectToServer(String name);
    void disconnectFromServer();

    boolean isConnected();

}
