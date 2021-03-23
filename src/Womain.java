import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Womain {
    //Womain is the server, please be respectful
    public static void main(String[] args) {
        String output = "";
        String input = "";

        int port = 1234;
        ServerSocket serverSocket;
        Socket socket;

        try{
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String name = in.readLine();
            System.out.println(name + " connected!");

            while (true){
                if (output.equalsIgnoreCase("/kill")){
                    in.close();
                    out.close();
                    socket.close();
                    System.out.println(name + " has been terminated");
                    System.exit(0);
                }

                if (!(output.equalsIgnoreCase(""))){
                    out.println(output);
                    output = "";
                }
            }
        }
        catch (Exception e) {
            System.out.println("Server fail");
        }
    }
}
