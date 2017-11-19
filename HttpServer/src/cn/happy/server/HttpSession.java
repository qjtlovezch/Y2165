package cn.happy.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class HttpSession extends Thread {
	private Socket s;
	public final static String path = "E:\\img";
	private BufferedReader br;
	private OutputStream out;

	public HttpSession(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
			String command = null;
			while ((command = br.readLine()) != null) {
				//System.out.println(command);
				// 空行就是结束的标志
				if (command.equals("")) {
					break;
				}
				if (command.startsWith("GET")) {
					String[] strs = command.split(" ");
					String fileName = strs[1];
					if("/".equals(fileName)){
						fileName="/index.html";
					}
					File file = new File(path , fileName);
					if (!file.exists()) {
						//
						out.write("<H1>404 not found</H1>".getBytes());

					} else {
						// 处理Get指令
						doGet(file);
					}

				}
			}

			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doGet(File file) {
		try {
			InputStream is = new FileInputStream(file);

			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = is.read(buf)) != -1) {
				out.write(buf, 0, len);
				out.flush();
			}
			is.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
