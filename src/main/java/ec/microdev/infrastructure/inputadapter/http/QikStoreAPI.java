package ec.microdev.infrastructure.inputadapter.http;

import ec.microdev.domain.documents.QikStore;
import ec.microdev.domain.request.StoreRegisterRequest;
import ec.microdev.infrastructure.inputport.QikStoreInputPort;
import ec.microdev.utils.Constant;
import io.quarkus.vertx.web.*;

import javax.inject.Inject;
import java.util.List;

@RouteBase(path = "qikAPI/store")
public class QikStoreAPI {

    @Inject
    QikStoreInputPort storeInputPort;

    @Route(path = ":userUUID", methods = Route.HttpMethod.POST)
    QikStore registerStore(@Body StoreRegisterRequest qikUser, @Param String userUUID){
        return storeInputPort.registerStore(qikUser,userUUID);
    }

    /*@Timed
    @Counted
    @CacheName("users")*/
    @Route(path = "", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    List<QikStore> getStore(){
        return storeInputPort.getAllStore();
    }

    @Route(path = ":storeUUID", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    QikStore getStoreByStoreUUID(@Param String storeUUID){
        return  storeInputPort.getStoreByUUID(storeUUID);
    }

    @Route(path = "list", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    List<QikStore> getStoreByStatus(){
        return storeInputPort.getStoreListByStatus(Constant.STATUS_ACTIVE);
    }

    @Route(path = "update", methods = Route.HttpMethod.PUT, produces = ReactiveRoutes.JSON_STREAM)
    QikStore updateStoreInfo(@Body QikStore qikStore){
        return storeInputPort.updateStore(qikStore);
    }
}
