package ec.microdev.infrastructure.inputport.http;

import ec.microdev.domain.documents.QikSubscription;
import ec.microdev.domain.request.SubscriptionRequest;
import ec.microdev.domain.response.SubscriptionResponse;

import java.util.List;

public interface QikSubscriptionInputPort {
    public SubscriptionResponse subscribeToStore(SubscriptionRequest qikStore);
    public QikSubscription getSubscription(String subscriptionUUID);
    public List<QikSubscription> getSubscriptionListByUserUUID(String userUUID);
    public List<QikSubscription> getAllSubscriptions();
    public QikSubscription updateSubscriptionStatus(String subscriptionUUID, String status);
}
