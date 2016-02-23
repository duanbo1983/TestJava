import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("130.211.174.137");
        byte[] receiveData = new byte[10];
        //String sentence = inFromUser.readLine();

        byte[] sendData = new byte[11];
        sendData[0] = 0x01;
        for (int i = 1; i < sendData.length; i ++) {
            sendData[i] = 0x55;
        }

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 53);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}