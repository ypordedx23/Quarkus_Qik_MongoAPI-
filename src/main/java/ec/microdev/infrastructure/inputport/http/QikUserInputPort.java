package ec.microdev.infrastructure.inputport.http;

import ec.microdev.domain.documents.QikUser;

import java.util.List;

public interface QikUserInputPort {

    public QikUser createUser(QikUser qikUser);

    public QikUser getById(String userId);

    public List<QikUser> getAll();

    public QikUser updateUser(QikUser qikUser);
}
