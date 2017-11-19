package cn.happy.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	
	public final static int port=8080;

	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(port);
			while(true){
				Socket s=ss.accept();
				new HttpSession(s).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
