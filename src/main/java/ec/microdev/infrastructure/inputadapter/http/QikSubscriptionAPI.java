package ec.microdev.infrastructure.inputadapter.http;

import ec.microdev.domain.documents.QikSubscription;
import ec.microdev.domain.request.SubscriptionRequest;
import ec.microdev.domain.response.SubscriptionResponse;
import ec.microdev.infrastructure.inputport.http.QikSubscriptionInputPort;
import ec.microdev.utils.Constant;
import io.quarkus.vertx.web.*;

import javax.inject.Inject;
import java.util.List;

@RouteBase(path = "qikAPI/subscription")
public class QikSubscriptionAPI {
    @Inject
    QikSubscriptionInputPort qikSubscriptionInputPort;

    @Route(path = "", methods = Route.HttpMethod.POST)
    SubscriptionResponse createStorePerk(@Body SubscriptionRequest subscriptionRequest){
        return qikSubscriptionInputPort.subscribeToStore(subscriptionRequest);
    }
    @Route(path="", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    List<QikSubscription> getAllSubscriptions(){
        return qikSubscriptionInputPort.getAllSubscriptions();
    }
    @Route(path = ":subscriptionUUID",methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    QikSubscription getSubscriptionUUID(@Param String subscriptionUUID){
        return qikSubscriptionInputPort.getSubscription(subscriptionUUID);
    }
    @Route(path = "deactivate/:subscriptionUUID", methods = Route.HttpMethod.PUT, produces = ReactiveRoutes.JSON_STREAM)
    QikSubscription updatePerkInfo(@Param String subscriptionUUID){
        return qikSubscriptionInputPort.updateSubscriptionStatus(subscriptionUUID, Constant.STATUS_INACTIVE);
    }
    @Route(path = "user/:userUUID",methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    List<QikSubscription> getSubscriptionByUserUUID(@Param String subscriptionUUID){
        return qikSubscriptionInputPort.getSubscriptionListByUserUUID(subscriptionUUID);
    }
}
