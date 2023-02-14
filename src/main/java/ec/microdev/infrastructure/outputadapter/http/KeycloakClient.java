package ec.microdev.infrastructure.outputadapter.http;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import ec.microdev.domain.response.KeycloakAuthResponse;

@RegisterRestClient(configKey="keycloak")
public interface KeycloakClient {

    @POST
    @Path("/protocol/openid-connect/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    KeycloakAuthResponse authUser(@RequestBody Form keycloakAuthRequest);
}
