package com.diego.test.akka.camel;

import java.io.FileInputStream;
import java.io.InputStream;

import akka.camel.CamelMessage;

public class FileCamelConsumer extends CamelConsumerActorExtension{

	public FileCamelConsumer(String uri) {
		super(uri);
	}

	@Override
	public void onReceive(Object msg) throws Throwable {
		CamelMessage camelMessage = (CamelMessage) msg;
		InputStream file = camelMessage.getBodyAs(InputStream.class, getCamelContext());
		System.out.println("Whatever");
		//FileInputStream fis = new FileInputStream(file);
		//String body = camelMessage.getBodyAs(String.class, getCamelContext());
		//System.out.println(body);
	}

}
