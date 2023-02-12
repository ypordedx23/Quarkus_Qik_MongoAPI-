package ec.microdev.infrastructure.outputadapter;

import ec.microdev.domain.documents.QikPerk;
import ec.microdev.domain.documents.QikUser;
import ec.microdev.infrastructure.outputport.QikPerkRepository;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

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