package ec.microdev.infrastructure.outputadapter.mongoAdapter;

import ec.microdev.domain.documents.QikPerk;
import ec.microdev.infrastructure.outputport.mongoRepository.QikPerkRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class QikPerkAdapter implements QikPerkRepository {
    @Override
    public Optional<QikPerk> findByUserUUID(String userID) {
        return findByIdOptional(new ObjectId(userID));
    }

    @Override
    public Optional<List<QikPerk>> getPerksByStoreUUID(String storeUUID) {
        Optional optionalList = Optional.of(list("storeId",storeUUID));
        return optionalList;
    }

    @Override
    public Optional<List<QikPerk>> getPerksByUserUUID(String userUUID) {
        Optional optionalList = Optional.of(list("userID",userUUID));
        return optionalList;
    }
}
