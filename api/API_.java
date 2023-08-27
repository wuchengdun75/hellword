import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//DESKTOP-S4MP84S/192.168.12.1

        InetAddress host1 = InetAddress.getByName("DESKTOP-S4MP84S");
        System.out.println("host1=" + host1);//DESKTOP-S4MP84S/192.168.12.1

        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2=" + host2);//www.baidu.com / 110.242.68.4

        String hostAddress = host2.getHostAddress();//IP 110.242.68.4
        System.out.println("host2 对应的ip = " + hostAddress);//110.242.68.4

        String hostName = host2.getHostName();
        System.out.println("host2对应的主机名/域名=" + hostName); // www.baidu.com

    }
}
