# akka-camel
A proof of concept to see the integration between akka and camel with rabbitmq and file component

We see different approachs to consume events from RabbitMQ.

In one scenario we have a solution with only Apache Camel.
In the other scenario we have a solution with Apache Camel and the integration with Akka Actors.

The problems were the way Akka integrated with Apache Camel gives ACKs to RabbitMQ.
