package dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class xuli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String xuli(String input) {
		String output = null;
		System.out.println(input);
		try {
			Socket socket = new Socket("localhost", 5000);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			
				DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
				outToServer.writeUTF(input);
				output = dis.readUTF();
				System.out.println(output);

		} catch (Exception e) {
			System.out.println(e);
		}
		return output;
	}

}
