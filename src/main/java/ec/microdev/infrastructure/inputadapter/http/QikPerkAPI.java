package ec.microdev.infrastructure.inputadapter.http;

import ec.microdev.domain.documents.QikPerk;
import ec.microdev.domain.documents.QikUser;
import ec.microdev.infrastructure.inputport.QikPerkInputPort;
import ec.microdev.infrastructure.inputport.QikUserInputPort;
import io.quarkus.vertx.web.*;

import javax.inject.Inject;
import java.util.List;

@RouteBase(path = "qikAPI/perk")
public class QikPerkAPI {
    @Inject
    QikPerkInputPort qikInputPort;

    @Route(path = "register", methods = Route.HttpMethod.POST)
    QikPerk createStorePerk(@Body QikPerk qikPerk){
        return qikInputPort.registerPerk(qikPerk);
    }
    @Route(path="", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    List<QikPerk> getAllPerks(){
        return qikInputPort.getAllPerks();
    }
    @Route(path = ":perkUUID",methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    QikPerk getPerkByUUID(@Param String userUUID){
        return qikInputPort.getPerkByUUID(userUUID);
    }
    @Route(path = "update", methods = Route.HttpMethod.PUT, produces = ReactiveRoutes.JSON_STREAM)
    QikPerk updatePerkInfo(@Body QikPerk qikPerk){
        return qikInputPort.updatePerk(qikPerk);
    }
    @Route(path = "user/:userUUID",methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    List<QikPerk> getAllUserPerks(@Param String userUUID){
        return qikInputPort.getAllPerksByUserUUID(userUUID);
    }
    @Route(path = "store/:storeUUID",methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    List<QikPerk> getAllStorePerks(@Param String storeUUID){
        return qikInputPort.getAllPerksByStoreUUID(storeUUID);
    }
}
