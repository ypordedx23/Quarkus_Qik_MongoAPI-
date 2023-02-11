package ec.microdev.infrastructure.outputport;

import ec.microdev.domain.documents.QikUser;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import java.util.Optional;


public interface QikUserRepository extends PanacheMongoRepository<QikUser> {
    Optional<QikUser> findByUserName(String username);
    boolean existByUsername(String username);

}
