package ec.microdev.infrastructure.outputadapter;

import ec.microdev.domain.documents.QikStore;
import ec.microdev.infrastructure.outputport.QikStoreRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class QIkStoreAdapter implements QikStoreRepository {
    @Override
    public Optional<QikStore> findByStoreID(String storeId) {
        return findByIdOptional(new ObjectId(storeId));
    }
}
