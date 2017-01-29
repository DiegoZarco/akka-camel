package com.diego.test.camel;

import org.apache.camel.builder.RouteBuilder;

public class RabbitMQRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("rabbitmq://127.0.0.1:5672/test_ex?queue=test&routingKey=#&username=guest&password=guest&autoDelete=false&autoAck=false&prefetchEnabled=true&prefetchCount=1")
		.startupOrder(2)
		.to("direct:logic");
	}

}
