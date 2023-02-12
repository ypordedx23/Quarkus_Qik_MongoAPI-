package ec.microdev.infrastructure.inputport;

import ec.microdev.domain.documents.QikStore;
import ec.microdev.domain.request.StoreRegisterRequest;

import java.util.List;

public interface QikStoreInputPort {
    public QikStore registerStore(StoreRegisterRequest qikStore, String userUUID);
    public QikStore getStoreByUUID(String storeUUID);
    public List<QikStore> getStoreListByStatus(String status);
    public List<QikStore> getAllStore();
    public QikStore updateStore(QikStore qikUser);
}
