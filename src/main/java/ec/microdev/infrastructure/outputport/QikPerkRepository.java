package ec.microdev.infrastructure.outputport;

import ec.microdev.domain.documents.QikPerk;
import ec.microdev.domain.documents.QikUser;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import java.util.List;
import java.util.Optional;

public interface QikPerkRepository extends PanacheMongoRepository<QikPerk> {
    Optional<QikPerk> findByUserUUID(String userID);

    Optional<List<QikPerk>> getPerksByStoreUUID(String storeUUID);
    Optional<List<QikPerk>> getPerksByUserUUID(String userUUID);
}
