package server;

import java.io.FileReader;
import java.io.FileWriter;

public class Repo implements iRepo{
    public static final String LOG_PATH = "src/server/log.txt";

    /**
     * Метод схранения истории часта
     *
     * @param text сообщение чата
     */
    @Override
    public void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Метод чтения истории
     *
     * @return история чата
     */
    @Override
    public String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
