package de.fhdw.server.example.main;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;

public class JettyServer {

	public static void main(String[] args) throws Exception {

		// Kommentar
		Server server = new Server(9998);

		// JERSEY
		ResourceConfig resourceConfig = new PackagesResourceConfig("de.fhdw.server.example.rest");
		ServletContextHandler sh = new ServletContextHandler();
		sh.setContextPath("/rest");
		sh.addServlet(new ServletHolder(new ServletContainer(resourceConfig)), "/*");

		server.setHandler(sh);
		server.start();

		Logger logger = Logger.getRootLogger();
		SimpleLayout layout = new SimpleLayout();
		ConsoleAppender appender = new ConsoleAppender(layout);
		FileAppender fileappender = new FileAppender(layout, "logs\\example.log");
		logger.addAppender(appender);
		logger.addAppender(fileappender);
		logger.setLevel(Level.ALL);

	}
}
