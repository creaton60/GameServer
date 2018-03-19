package com.akka.game.root.chat;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ChatActor extends AbstractActor{
    private final LoggingAdapter LOG = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return null;
    }
}
