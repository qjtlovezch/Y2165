package demo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpStart {
	public static void main(String[] args) throws Exception {
		start();
	}

	public static void start() throws Exception {
		ServerSocket ss = new ServerSocket(8082);
		System.out.println("*****服务器开启，监听8080端口******");
		//线程池（提高效率缓存线程的容器）
		ExecutorService pool = Executors.newFixedThreadPool(100);
		while (true) {
			//循环监听
			Socket accept = ss.accept();
			//将需要处理的请求交给线程池，线程池将使用一个线程来完成我们提交的任务
			pool.submit(new TheadRequestHandler(accept));
		}

	}
}









