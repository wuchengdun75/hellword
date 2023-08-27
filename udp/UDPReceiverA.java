import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("接收端A 等待接收数据..");
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);


        data = "好的, 明天见".getBytes();
        packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.12.1"), 9998);

        socket.send(packet);

        socket.close();
        System.out.println("A端退出...");

    }
}
