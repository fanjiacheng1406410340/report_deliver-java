package example.deliver;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.dahantc.api.deliver.ReceiveDeliverServlet;

public class ReceiveDeliverDemo {
	public static void main(String[] args) {
		System.out.println("Jetty启动8081...");
		Server server = new Server(8081);
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		// http://127.0.0.1:8081/receiveReport
		context.addServlet(new ServletHolder(new ReceiveDeliverServlet()), "/receiveDeliver");
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
