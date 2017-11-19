package demo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TheadRequestHandler implements Runnable {
	private Socket ss = null;
	private InputStream in = null;
	// 选择高级流
	private PrintStream out = null;
	// 交给服务器要访问的页面
	private final static String path = "E:\\img";

	public TheadRequestHandler(Socket ss) {
		this.ss = ss;
		try {
			in = this.ss.getInputStream();
			out = new PrintStream(this.ss.getOutputStream());
		} catch (IOException e) {
			System.err.println("获取失败" + e.getMessage());
		}
	}

	@Override
	public void run() {

		// 获得ip
		System.out.println("----服务了----"
				+ this.ss.getInetAddress().getHostAddress());
		String fileName = readerRequestHead();
		try {
			readFile(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取请求头的操作
	 *
	 * @return 返回请求资源名，没有返回空
	 */
	public String readerRequestHead() {
		//高级带缓冲区的读取器
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		try {
			// 获取页面中的所有信息
			// GET /index.html HTTP/1.1
			// 请求头信息中包含了请求的资源
			String requestHandler = br.readLine();
			System.out.println("请求头：" + requestHandler);
			if (requestHandler != null) {
				String[] hands = requestHandler.split(" ");
				// 获取/index.html
				return hands[1].equals("/") ? "index.html" : hands[1];
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index.html";
	}

	/**
	 * 根据请求的资源名获取资源进行相应
	 *
	 * @param fileName
	 * @throws Exception
	 */
	public void readFile(String fileName) throws Exception {
		if (fileName != null) {
			File f = new File(path + fileName);
			// 判断文件是否存在
			if (f.exists()) {
				FileInputStream fis = new FileInputStream(f);
				// byte[]bs=new byte[(int)f.length()];
				byte[] bs = new byte[1024 * 1024];

				out.println("HTTP/1.1 200 OK");
				out.println();
				int num = 0;
				if ((num = fis.read(bs)) != -1) {
					out.write(bs);
					out.flush();
				}
				out.close();
			}
		}

	}


}
