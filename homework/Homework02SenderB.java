import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

@SuppressWarnings({"all"})
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9998);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题: ");
        String question = scanner.next();
        byte[] data = question.getBytes(); //

        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.12.1"), 8888);

        socket.send(packet);

        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);

        int length = packet.getLength();//实际接收到的数据字节长度
        data = packet.getData();//接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);

        socket.close();
        System.out.println("B端退出");
    }
}
