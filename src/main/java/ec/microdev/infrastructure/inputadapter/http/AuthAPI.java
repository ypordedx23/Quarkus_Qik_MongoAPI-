package ec.microdev.infrastructure.inputadapter.http;

import ec.microdev.domain.request.LoginRequest;
import ec.microdev.domain.request.StoreRegisterRequest;
import ec.microdev.domain.request.UserRegisterRequest;
import ec.microdev.domain.response.AuthResponse;
import ec.microdev.infrastructure.inputport.http.AuthInputPort;
import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.ReactiveRoutes;
import io.quarkus.vertx.web.Route;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/auth")
public class AuthAPI {


    @Inject
    AuthInputPort userAuthInputPort;

    @Route(path = "login", methods = Route.HttpMethod.POST, produces = ReactiveRoutes.APPLICATION_JSON)
    //@PermitAll
    AuthResponse loginQikUser(@Body LoginRequest loginRequest){
        return userAuthInputPort.loginQikUser(loginRequest);
    }

    @Route(path = "signin", methods = Route.HttpMethod.POST, produces = ReactiveRoutes.APPLICATION_JSON)
    AuthResponse signingQlikUser(@Body UserRegisterRequest qikUserRequest){
        return userAuthInputPort.signinQikUser(qikUserRequest);
    }

    @Route(path = "storesignin", methods = Route.HttpMethod.POST, produces = ReactiveRoutes.APPLICATION_JSON)
    AuthResponse signingQlikUser(@Body StoreRegisterRequest qikUserRequest){
        return userAuthInputPort.signinQikStore(qikUserRequest);
    }
}
