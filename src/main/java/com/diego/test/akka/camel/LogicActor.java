package com.diego.test.akka.camel;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.camel.Ack;

public class LogicActor extends UntypedActor{
	
	private ActorRef rabbitActor;
	
	public LogicActor(ActorRef rabbitActorRef){
		this.rabbitActor = rabbitActorRef;
	}

	@Override
	public void onReceive(Object message) throws Throwable {
		System.out.println(message);
		//Thread.sleep(5000);
		rabbitActor.tell(Ack.getInstance(), getSelf());
	}

}
