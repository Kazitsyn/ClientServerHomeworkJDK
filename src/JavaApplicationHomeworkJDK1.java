
import server.Server;
import server.ServerWindow;
import client.ClientGUI;


/**
 *
 * @author Sergey Kazitsyn
 */
public class JavaApplicationHomeworkJDK1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server();
        new ClientGUI(server);
        new ClientGUI(server);
        
    }
    
}
