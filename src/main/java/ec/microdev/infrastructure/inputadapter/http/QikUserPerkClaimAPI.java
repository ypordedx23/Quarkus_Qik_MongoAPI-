package ec.microdev.infrastructure.inputadapter.http;

import ec.microdev.domain.documents.QikUserPerkClaim;
import ec.microdev.domain.request.UserPerkClaimRequest;
import ec.microdev.domain.response.UserPerkClaimResponse;
import ec.microdev.infrastructure.inputport.QikUserPerkClaimInputPort;
import io.quarkus.vertx.web.*;

import javax.inject.Inject;
import java.util.List;

@RouteBase(path = "qikAPI/userperk")
public class QikUserPerkClaimAPI {

    @Inject
    QikUserPerkClaimInputPort qikUserPerkClaimInputPort;

    @Route(path = "", methods = Route.HttpMethod.POST, produces = ReactiveRoutes.JSON_STREAM)
    public UserPerkClaimResponse claimPerkOfStore(@Body UserPerkClaimRequest qikStore){
        return qikUserPerkClaimInputPort.claimPerkOfStore(qikStore);
    };

    @Route(path = ":userPerkClaimUUID", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    public QikUserPerkClaim getUserPerkClaim(@Param String userPerkClaimUUID){
        return qikUserPerkClaimInputPort.getUserPerkClaim(userPerkClaimUUID);
    };

    @Route(path = "list/:userUUID", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    public List<QikUserPerkClaim> getAllPerksByUserUUID(@Param String userUUID){
        return qikUserPerkClaimInputPort.getAllPerksByUserUUID(userUUID);
    };

    @Route(path = "", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    public List<QikUserPerkClaim> getAllPerks(){
        return qikUserPerkClaimInputPort.getAllPerks();
    };

    @Route(path = "update", methods = Route.HttpMethod.PUT, produces = ReactiveRoutes.JSON_STREAM)
    public QikUserPerkClaim updatePerkClaimStatus(@Body QikUserPerkClaim qikUser){
        return  qikUserPerkClaimInputPort.updatePerkClaimStatus(qikUser);
    };
}
