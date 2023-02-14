package ec.microdev.infrastructure.outputport.mongoRepository;

import ec.microdev.domain.documents.QikUser;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import java.util.Optional;


public interface QikUserRepository extends PanacheMongoRepository<QikUser> {
    Optional<QikUser> findByUserName(String username);
    boolean existByUsername(String username);

    Optional<QikUser> findByUserUUID(String userID);

    Optional<QikUser> findByEmail(String userEmail);
}
