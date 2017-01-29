package com.diego.test.camel;

import org.apache.camel.main.Main;

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
