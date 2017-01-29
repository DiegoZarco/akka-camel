package com.diego.test.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class LogicRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:logic")
		.startupOrder(1)
		.process(new Processor() {

			public void process(Exchange exchange) throws Exception {
				String message = exchange.getIn().getBody(String.class);
				System.out.println(message);
				//Thread.sleep(5000);
			}

		})
		.end();
		
	}

}
