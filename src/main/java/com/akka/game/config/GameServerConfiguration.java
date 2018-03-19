package com.akka.game.config;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.akka.game.config.extension.SpringExtension;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.akka.game"})
public class GameServerConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringExtension springExtension;

    @Bean
    public ActorSystem actorSystem(){
        ActorSystem system = ActorSystem.create("GameServer", akkaConfiguration());
        springExtension.initialize(applicationContext);

        ActorRef rootActor = system.actorOf(springExtension.props("gameRootActor"), "gameRootActor");

        return system;
    }

    @Bean
    public Config akkaConfiguration(){
        return ConfigFactory.load();
    }

}
