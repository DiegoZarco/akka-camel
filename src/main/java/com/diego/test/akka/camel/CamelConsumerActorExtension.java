package com.diego.test.akka.camel;

import akka.camel.javaapi.UntypedConsumerActor;

public abstract class CamelConsumerActorExtension extends UntypedConsumerActor{
	
	private String uri;

	@Override
	public String getEndpointUri() {
		return uri;
	}
	
	public CamelConsumerActorExtension(final String uri){
		this.uri = uri;
	}

}
