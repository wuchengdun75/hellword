import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
@SuppressWarnings({"all"})
public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("接收端 等待接收问题 ");
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        String answer = "";
        if("四大名著是哪些".equals(s)) {
            answer = "四大名著 <<红楼梦>> <<三国演示>> <<西游记>> <<水浒传>>";
        } else {
            answer = "what?";
        }
        data = answer.getBytes();
        packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.12.1"), 9998);

        socket.send(packet);//发送

        socket.close();
        System.out.println("A端退出...");

    }
}
