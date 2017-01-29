package com.diego.test.akka.camel;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.camel.CamelMessage;

public class RabbitMQCamelConsumer extends CamelConsumerActorExtension {

	public RabbitMQCamelConsumer(final String uri) {
		super(uri);
	}

	@Override
	public void onReceive(Object msg) throws Throwable {
		CamelMessage camelMessage = (CamelMessage) msg;
		ActorRef logicActor = getContext().actorOf(Props.create(LogicActor.class, getSender()));
		String body = camelMessage.getBodyAs(String.class, getCamelContext());
		logicActor.tell(body, getSelf());
	}

	/**
	 * Sin este metodo todos los mensajes llegan al actor y se da ACK inmediato
	 * aunque en el endpoint de rabbit de camel hayamos puesto autoAck a false
	 */
	@Override
	public boolean autoAck() {
		return false;
	}

}
