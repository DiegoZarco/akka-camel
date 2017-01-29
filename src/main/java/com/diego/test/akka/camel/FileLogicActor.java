package com.diego.test.akka.camel;

import akka.actor.UntypedActor;
import akka.camel.CamelMessage;

public class FileLogicActor extends UntypedActor{

	@Override
	public void onReceive(Object message) throws Throwable {
		CamelMessage camelMessage = (CamelMessage)message;
		String textLine = (String)camelMessage.body();
		System.out.println(textLine);
	}

}
