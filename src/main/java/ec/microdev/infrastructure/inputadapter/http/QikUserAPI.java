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

@RouteBase(path = "qikAPI")
public class QikUserAPI {
    @Inject
    QikUserInputPort userInputPort;

    @Route(path = "user", methods = Route.HttpMethod.POST)
    QikUser createUser(@Body QikUser qikUser){
        /*userInputPort.createUser(ex.getParam("username").get(),ex.getParam("password").get(),
                ex.getParam("cellphone").get(),ex.getParam("email").get(),
                ex.getParam("birthDate").get());*/
        return userInputPort.createUser(qikUser);
    }

    @Timed
    @Counted
    @Route(path="users", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    @CacheName("users")
    List<QikUser> getUser(){
        return userInputPort.getAll();
    }


}
