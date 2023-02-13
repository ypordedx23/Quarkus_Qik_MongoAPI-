package ec.microdev.infrastructure.outputadapter;

import ec.microdev.domain.documents.QikSubscription;
import ec.microdev.infrastructure.outputport.QikSubscriptionRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static ec.microdev.utils.Util.addIfNotNull;

@ApplicationScoped
public class QikSubscriptionAdapter implements QikSubscriptionRepository {
    @Override
    public Optional<QikSubscription> findByUserUUID(String userID) {
        return find("qikUserId",userID).firstResultOptional();
    }

    @Override
    public boolean subscriptionStatus(String userID, String storeID) {
        Map<String, Object> parameters = new HashMap<>();
        addIfNotNull(parameters, "qikUserId", userID );
        addIfNotNull(parameters, "qikStoreId", storeID );
        String query = parameters.entrySet().stream()
                .map( entry -> entry.getKey() + "=:" + entry.getKey() )
                .collect( Collectors.joining(" and ") );
        return find(query, parameters).firstResultOptional().get().isActive();
    }

    @Override
    public Optional<QikSubscription> findByStoreUUID(String storeID) {
        return find("qikStoreId",storeID).firstResultOptional();
    }

    public Optional<List<QikSubscription>> getAllUserSubscriptionByUserUUID(String userUUID) {
        Optional optionalList = Optional.of(list("qikUserId",userUUID));
        return optionalList;
    }
}
