package com.diego.test.akka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.diego.test.akka.camel.FileCamelConsumer;
import com.diego.test.akka.camel.RabbitMQCamelConsumer;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;
import akka.actor.Props;

@SuppressWarnings("rawtypes")
public class Main {
	
	private Map<String, Class> endPointsSupported;
	
	public static void main(String[] args) {
		Main startUp = new Main();
		startUp.boot();
	}
	
	public Main(){
		endPointsSupported = new HashMap<String, Class>();
		endPointsSupported.put("rabbitmq", RabbitMQCamelConsumer.class);
		endPointsSupported.put("file", FileCamelConsumer.class);
	}

	public void boot() {
		ActorSystem system = ActorSystem.create();
		try {
			Config config = ConfigFactory.defaultApplication();
			List<String> camelEndpoints = config.getStringList("endpoints");
			startCamelEndpoints(camelEndpoints, system);
		} catch (Exception e) {
			System.out.println("FALTAL ERROR --> " + e);
			system.terminate();
		} 

	}

	private void startCamelEndpoints(final List<String> camelEndpoints, final ActorSystem system) throws Exception {
		for (String camelEndpoint : camelEndpoints) {
			String aux = camelEndpoint.substring(0, camelEndpoint.indexOf(":"));
			Class consumerClass = endPointsSupported.get(aux);
			if (consumerClass!=null){
				system.actorOf(Props.create(consumerClass, camelEndpoint));
			} else {
				throw new Exception("The endpoint is not supported");
			}
		}
	}
}
