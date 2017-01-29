package com.diego.test.akka;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MainPublishRabbit {
	
	private final String QUEUE_NAME = "test";
	private final String message = "Hello world";
	private final int NUMBER_MESSAGES = 500000;

	public static void main(String[] args) throws IOException, TimeoutException{
		MainPublishRabbit main = new MainPublishRabbit();
		main.boot();
	}
	
	public void boot() throws IOException, TimeoutException{
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("127.0.0.1");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    channel.queueDeclare(QUEUE_NAME, true, false, false, null);
	    for (int i=0; i<NUMBER_MESSAGES; i++){
	    	String msg = message + i;
	    	channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
		    System.out.println(" [x] Sent '" + message + "'");
	    }
	    channel.close();
	    connection.close();

	}
}
