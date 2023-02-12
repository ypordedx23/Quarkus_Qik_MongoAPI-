package ec.microdev.infrastructure.outputport;

import ec.microdev.domain.documents.QikStore;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import java.util.Optional;

public interface QikStoreRepository extends PanacheMongoRepository<QikStore> {
    Optional<QikStore> findByStoreID(String storeId);


}
