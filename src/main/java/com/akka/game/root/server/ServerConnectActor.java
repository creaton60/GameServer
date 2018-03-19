package com.akka.game.root.server;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 *
 */
public class ServerConnectActor extends AbstractActor{
    private final LoggingAdapter LOG = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchAny(e -> LOG.error("recevied unknown message : {} ", e))
                .build();
    }
}
