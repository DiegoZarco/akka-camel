package com.diego.test.akka;

import org.apache.camel.main.Main;

import com.diego.test.camel.FileRoute;
import com.diego.test.camel.LogicRoute;
import com.diego.test.camel.RabbitMQRoute;

public class MainCamel {
	
	private Main main;
	
	public static void main(String[] args) throws Exception{
		MainCamel m = new MainCamel();
		m.boot();
	}
	
	public void boot() throws Exception{
		main = new Main();
		main.addRouteBuilder(new LogicRoute());
		main.addRouteBuilder(new RabbitMQRoute());
		main.addRouteBuilder(new FileRoute());
		main.start();
	}
}
