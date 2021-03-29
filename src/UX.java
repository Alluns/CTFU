import javax.swing.*;
import java.net.Socket;
import java.util.Scanner;

public class UX {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the IP you wish to connect to...");
        String ip = (String) s.nextLine();
        System.out.println("Good job! Please enter the port you want to join...");
        int port = Integer.parseInt(JOptionPane.showInputDialog(null,"Port?","Connect to..",JOptionPane.QUESTION_MESSAGE));       ;
        Socket socket = null;

        try {
            socket = new Socket(ip,port);
        } catch (Exception e) {
            System.out.println("Client failed to connect");
            System.exit(0);
        }
    }
}
