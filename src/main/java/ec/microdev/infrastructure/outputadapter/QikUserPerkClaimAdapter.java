package ec.microdev.infrastructure.outputadapter;

import ec.microdev.domain.documents.QikUserPerkClaim;
import ec.microdev.infrastructure.outputport.QikUserPerkClaimRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class QikUserPerkClaimAdapter implements QikUserPerkClaimRepository {
    @Override
    public Integer claimedPerkStatus(String perkClaimedID) {
        return findByIdOptional(new ObjectId(perkClaimedID)).get().getStatus();
    }

    @Override
    public Optional<QikUserPerkClaim> findByClaimedUUID(String perkClaimedID) {
        return findByIdOptional(new ObjectId(perkClaimedID));
    }

    public Optional<List<QikUserPerkClaim>> getAllUserPerkCLAIMByUserUUID(String userUUID) {
        Optional optionalList = Optional.of(list("userId",userUUID));
        return optionalList;
    }
}
