package ec.microdev.application.usecase;

import ec.microdev.domain.documents.QikStore;
import ec.microdev.domain.request.StoreRegisterRequest;
import ec.microdev.infrastructure.inputport.QikStoreInputPort;
import ec.microdev.infrastructure.outputadapter.QIkStoreAdapter;
import ec.microdev.utils.Constant;
import ec.microdev.utils.Mapper;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Component
public class QikStoreUseCase implements QikStoreInputPort {

    @Inject
    QIkStoreAdapter qIkStoreAdapter;

    @Override
    public QikStore registerStore(StoreRegisterRequest qikStoreRequest, String userUUID) {
        QikStore qikStore = Mapper.mapToQikStore(qikStoreRequest);
        qikStore.setOwnerUUID(userUUID);
        qikStore.setStatus(Constant.STATUS_ACTIVE);
        qIkStoreAdapter.persist(qikStore);
        return qikStore;
    }

    @Override
    public QikStore getStoreByUUID(String storeUUID) {
        Optional<QikStore> opStore = qIkStoreAdapter.findByStoreID(storeUUID);
        QikStore dbStore = new QikStore();
        if(opStore.isPresent()){
            dbStore = opStore.get();
        }
        return dbStore;
    }

    @Override
    public List<QikStore> getStoreListByStatus(String status) {
        return qIkStoreAdapter.list("status", Constant.STATUS_ACTIVE);
    }

    @Override
    public List<QikStore> getAllStore() {
        return qIkStoreAdapter.listAll();
    }

    @Override
    public QikStore updateStore(QikStore qikStore) {
        qIkStoreAdapter.update(qikStore);
        return qikStore;
    }
}
