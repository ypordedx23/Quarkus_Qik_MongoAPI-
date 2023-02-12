package ec.microdev.infrastructure.inputadapter.http;

import ec.microdev.domain.documents.QikUser;
import ec.microdev.infrastructure.inputport.QikUserInputPort;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.quarkus.cache.CacheName;
import io.quarkus.vertx.web.*;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import java.util.List;

@RouteBase(path = "qikAPI/user")
public class QikUserAPI {
    @Inject
    QikUserInputPort userInputPort;

    @Route(path = "register", methods = Route.HttpMethod.POST)
    QikUser createUser(@Body QikUser qikUser){
        return userInputPort.createUser(qikUser);
    }

    @Route(path="", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    List<QikUser> getUser(){
        return userInputPort.getAll();
    }

    @Route(path = ":userUUID",methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    QikUser getUserByUUID(@Param String userUUID){
        return userInputPort.getById(userUUID);
    }

    @Route(path = "update", methods = Route.HttpMethod.PUT, produces = ReactiveRoutes.JSON_STREAM)
    QikUser updateUserInfo(@Body QikUser qikUser){
        return userInputPort.updateUser(qikUser);
    }
}
