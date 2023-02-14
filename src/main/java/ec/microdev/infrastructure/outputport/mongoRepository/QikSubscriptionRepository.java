package ec.microdev.infrastructure.outputport.mongoRepository;

import ec.microdev.domain.documents.QikSubscription;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import java.util.Optional;

public interface QikSubscriptionRepository extends PanacheMongoRepository<QikSubscription> {

    Optional<QikSubscription> findByUserUUID(String userID);
    boolean subscriptionStatus(String userID,String storeID);
    Optional<QikSubscription> findByStoreUUID(String storeID);
}
