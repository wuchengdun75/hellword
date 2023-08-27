import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");

        Socket socket = serverSocket.accept();

        System.out.println("服务端 socket =" + socket.getClass());
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();

    }
}
