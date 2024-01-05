
/**
 *
 * @author Sergey Kazitsyn
 */
public class JavaApplicationHomeworkJDK1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
        new ClientGUI(server);
        new ClientGUI(server);
        
    }
    
}
