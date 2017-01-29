package com.diego.test.akka.camel;

import akka.camel.CamelMessage;

public class FileCamelConsumer extends CamelConsumerActorExtension{

	public FileCamelConsumer(String uri) {
		super(uri);
	}

	@Override
	public void onReceive(Object msg) throws Throwable {
		CamelMessage camelMessage = (CamelMessage) msg;
		String body = camelMessage.getBodyAs(String.class, getCamelContext());
		System.out.println(body);
	}

}
