package server;

import client.Client;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Server implements iViewServer, iRepo{
    private boolean work;
    private List<Client> clientList;
    private iViewServer viewServer;
    private iRepo repo;

    public Server() {
        clientList = new ArrayList<>();
        viewServer = new ServerWindow(this);
        repo = new Repo();
    }
    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        this.clientList.add(client);
        appendLog(client.getName() + " подключился к серверу");
        return true;
    }
    public void disconnectUser(Client clientGUI){
        clientList.remove(clientGUI);
        appendLog(clientGUI.getName() + " отключелся от сервера");
        if (clientGUI != null){
            clientGUI.disconnectFromServer();
        }
    }
    @Override
    public boolean isWork() {
        return work;
    }
    @Override
    public void stopServer() {
        if (!work){
            appendLog("Сервер уже был остановлен");
        } else {
            work = false;
            while (!clientList.isEmpty()){
                disconnectUser(clientList.get(clientList.size()-1));
            }
            appendLog("Сервер остановлен!");
        }
    }
    @Override
    public void startServer(boolean work) {
        this.work = work;
    }
    public void message(String text){
        if (!work){
            return;
        }
        text += "";
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }
    private void answerAll(String text){
        for (Client clientGUI: clientList){
            clientGUI.answerFromServer(text);
        }
    }
    public String getLog() {
        return readLog();
    }
    @Override
    public void saveInLog(String text) {
        repo.saveInLog(text);
    }
    @Override
    public String readLog() {
        return repo.readLog();
    }
    @Override
    public void appendLog(String text) {
        viewServer.appendLog(text);
    }
}
