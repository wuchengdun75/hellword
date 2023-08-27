import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名");
        String downloadFileName = scanner.next();

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        socket.shutdownOutput();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        String filePath = "e:\\" + downloadFileName + ".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);

        bos.close();
        bis.close();
        outputStream.close();
        socket.close();

        System.out.println("客户端下载完毕，正确退出..");


    }
}


