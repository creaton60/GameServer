package com.akka.game.root;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import scala.Option;

@Component
@Scope("prototype")
public class GameRootActor extends AbstractActor{
    private final LoggingAdapter LOG = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public void preStart() throws Exception {
        super.preStart();
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
    }

    @Override
    public void preRestart(Throwable reason, Option<Object> message) throws Exception {
        super.preRestart(reason, message);
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchAny(e -> LOG.error("recevied unknown message , {} " , e))
                .build();
    }
}
