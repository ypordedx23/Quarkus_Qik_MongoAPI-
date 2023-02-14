package ec.microdev.infrastructure.inputport.http;

import ec.microdev.domain.documents.QikPerk;

import java.util.List;

public interface QikPerkInputPort {
    public QikPerk registerPerk(QikPerk qikUser);
    public QikPerk getPerkByUUID(String perkUUID);
    public List<QikPerk> getAllPerksByStoreUUID(String storeUUID);
    public List<QikPerk> getAllPerksByUserUUID(String userUUID);
    public List<QikPerk> getAllPerks();
    public QikPerk updatePerk(QikPerk qikUser);
}
