package ec.microdev.infrastructure.inputadapter.http;

import ec.microdev.domain.documents.QikUser;
import ec.microdev.domain.request.LoginRequest;
import ec.microdev.infrastructure.inputport.AuthInputPort;
import ec.microdev.infrastructure.inputport.QikUserInputPort;
import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.ReactiveRoutes;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;

@RouteBase(path = "qikAPI/auth")
public class AuthAPI {


    @Inject
    AuthInputPort userAuthInputPort;

    @Route(path = "register", methods = Route.HttpMethod.POST, produces = ReactiveRoutes.APPLICATION_JSON)
    @PermitAll
    QikUser registerQikuser(@Body LoginRequest loginBody){
        /*userInputPort.createUser(ex.getParam("username").get(),ex.getParam("password").get(),
                ex.getParam("cellphone").get(),ex.getParam("email").get(),
                ex.getParam("birthDate").get());*/
        return userAuthInputPort.loginQikUser(loginBody);
    }


}
