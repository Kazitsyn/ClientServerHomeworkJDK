package client;

import server.Server;
import server.ServerWindow;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sergey
 */
public class Client implements iViewClientGUI{

    private Server server;
    private boolean connected;
    private String name;
    private iViewClientGUI viewClientGUI;


    public Client(iViewClientGUI viewClientGUI, Server server) {
        this.server = server;
        this.viewClientGUI = viewClientGUI;

    }

    private void showOnWindow(String text){
        viewClientGUI.sendMessage(text + "\n");
    }

    public void answerFromServer(String messageFromServer){
        showOnWindow(messageFromServer);
    }

    @Override
    public void sendMessage(String message) {
        if (connected){
            if (!message.equals("")){
                server.message(name + ": " + message);
            }
        } else {
            showOnWindow("Нет подключения к серверу");
        }
    }

    @Override
    public void connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)){
            showOnWindow("Вы успешно подключились!\n");
            connected = true;
            viewClientGUI.connectToServer(name);
            String tfMessage = server.getLog();
            if (tfMessage != null){
                showOnWindow(tfMessage);
            }

        } else {
            showOnWindow("Подключение не удалось");

        }
    }

    @Override
    public void disconnectFromServer() {
        if (connected) {
            connected = false;
            server.disconnectUser(this);
            viewClientGUI.disconnectFromServer();
            showOnWindow("Вы были отключены от сервера!");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isConnected() {
        return connected;
    }
}