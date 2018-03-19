package com.akka.game.root;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.akka.game.config.extension.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import scala.Option;

@Component
@Scope("prototype")
public class GameRootActor extends AbstractActor{
    private final LoggingAdapter LOG = Logging.getLogger(getContext().getSystem(), this);

    @Autowired
    protected SpringExtension extension;

    private ActorRef contentsActor;

    private ActorRef manageActor;

    private ActorRef serverConnectActor;

    private ActorRef chatActor;

    @Override
    public void preStart() throws Exception {
        super.preStart();

        contentsActor = getContext().actorOf(extension.props("contentsActor"), "contentsActor");
        manageActor = getContext().actorOf(extension.props("manageActor"), "manageActor");
        serverConnectActor = getContext().actorOf(extension.props("serverConnectActor"), "serverConnectActor");
        chatActor = getContext().actorOf(extension.props("chatActor"), "ChatActor");

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
