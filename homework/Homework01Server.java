import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");

        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        String answer = "";
        if ("name".equals(s)) {
            answer = "我是韩顺平";
        } else if("hobby".equals(s)) {
            answer = "编写java程序";
        } else {
            answer = "你说的啥子";
        }


        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer);
        bufferedWriter.newLine();/
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();//关闭

    }
}
