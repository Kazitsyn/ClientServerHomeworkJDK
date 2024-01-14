package server;

import client.Client;

public interface iViewServer {
    void appendLog(String text);
    void disconnectUser(Client client);
    boolean isWork();

    void stopServer();
    void startServer(boolean work);
}
