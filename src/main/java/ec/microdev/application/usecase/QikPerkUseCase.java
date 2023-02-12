package ec.microdev.application.usecase;

import ec.microdev.domain.documents.QikPerk;
import ec.microdev.infrastructure.inputport.QikPerkInputPort;
import ec.microdev.infrastructure.outputadapter.QikPerkAdapter;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class QikPerkUseCase implements QikPerkInputPort {

    @Inject
    QikPerkAdapter qikPerkAdapter;

    @Override
    public QikPerk registerPerk(QikPerk qikPerk) {
        qikPerkAdapter.persist(qikPerk);
        return qikPerk;
    }

    @Override
    public QikPerk getPerkByUUID(String perkUUID) {
        QikPerk dbQikPerk = new QikPerk();
        Optional<QikPerk> opPerk= qikPerkAdapter.findByIdOptional(new ObjectId(perkUUID));
        if(opPerk.isPresent()){
            dbQikPerk= opPerk.get();
        }
        return dbQikPerk;
    }

    @Override
    public List<QikPerk> getAllPerksByStoreUUID(String storeUUID) {
        List<QikPerk> dbQikPerkListByStore = new ArrayList<>();
        Optional<List<QikPerk>> opList = qikPerkAdapter.getPerksByStoreUUID(storeUUID);
        if(opList.isPresent()){
            dbQikPerkListByStore = opList.get();
        }
        return dbQikPerkListByStore;
    }

    @Override
    public List<QikPerk> getAllPerksByUserUUID(String userUUID) {
        List<QikPerk> dbQikPerkListByUser = new ArrayList<>();
        Optional<List<QikPerk>> opList = qikPerkAdapter.getPerksByUserUUID(userUUID);
        if(opList.isPresent()){
            dbQikPerkListByUser = opList.get();
        }
        return dbQikPerkListByUser;
    }

    @Override
    public List<QikPerk> getAllPerks() {
        return qikPerkAdapter.listAll();
    }

    @Override
    public QikPerk updatePerk(QikPerk qikPerk) {
        qikPerkAdapter.update(qikPerk);
        return qikPerk;
    }
}
