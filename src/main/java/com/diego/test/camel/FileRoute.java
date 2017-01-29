package com.diego.test.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class FileRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:///Users/diegozarcogomez/Documents/test?initialDelay=3000&delay=2000")
		.split(body().tokenize("\n"))
		.parallelProcessing()
		.streaming()
		.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						System.out.println(exchange.getIn().getBody(String.class));

					}
				}).end();
	}

}
