package ec.microdev;

import ec.microdev.entity.User;
import ec.microdev.entity.UserRepository;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.quarkus.cache.CacheName;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.vertx.web.*;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import org.apache.commons.lang3.RandomStringUtils;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.UUID;

@RouteBase(path = "quarkTest")
public class Main {

    @Inject
    UserRepository usRepository;

    @Route(path = "Hello", methods = Route.HttpMethod.GET)
    void hello(RoutingExchange ex){
        ex.ok("Hello "+ex.getParam("name"));
    }

    @Route(path="Users", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    @Timed
    @Counted
    @CacheName("users")
    Multi<User> getUser(){
        return Multi.createFrom().items(()->usRepository.listAll().stream()).runSubscriptionOn(Infrastructure.getDefaultWorkerPool());
    }

    @Transactional
    void serverInit(@Observes StartupEvent startupEvent){
        for (int i= 0; i <10000;i++){
            User us = new User();
            us.setId(UUID.randomUUID().toString());
            us.setUserName(RandomStringUtils.randomAlphabetic(10,15));
            us.setPassword(RandomStringUtils.randomAlphanumeric(10));
            usRepository.persistAndFlush(us);
        }
    }
}