package ec.microdev.infrastructure.outputport.mongoRepository;

import ec.microdev.domain.documents.QikUserPerkClaim;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import java.util.List;
import java.util.Optional;

public interface QikUserPerkClaimRepository extends PanacheMongoRepository<QikUserPerkClaim> {
    Integer claimedPerkStatus(String perkClaimedID);
    Optional<QikUserPerkClaim> findByClaimedUUID(String perkClaimedID);
    Optional<List<QikUserPerkClaim>> getAllUserPerkCLAIMByUserUUID(String userUUID);
}
