package server;

public interface iRepo {
    /**
     * Метод схранения истории часта
     * @param text сообщение чата
     */
    void saveInLog(String text);

    /**
     * Метод чтения истории
     * @return история чата
     */
    String readLog();
}
