package com.diego.test.akka.camel.routes;

import org.apache.camel.builder.RouteBuilder;

import akka.actor.ActorRef;
import akka.camel.internal.component.CamelPath;

public class FileAkkaCamelRoute extends RouteBuilder{
	
	private String uri;
	
	public FileAkkaCamelRoute(ActorRef actorRef){
		uri = CamelPath.toUri(actorRef);
	}

	@Override
	public void configure() throws Exception {
		from("file:///Users/diegozarcogomez/Documents/test?initialDelay=3000&delay=2000")
		.split(body().tokenize("\n"))
		.streaming()
		.to(uri);
		
	}

}
