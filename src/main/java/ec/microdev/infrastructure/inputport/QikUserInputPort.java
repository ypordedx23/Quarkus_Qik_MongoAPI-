package ec.microdev.infrastructure.inputport;

import ec.microdev.domain.documents.QikUser;

import java.util.List;

public interface QikUserInputPort {
    public QikUser createUser(String username, String password,
                              String cellphone, String email,
                              String birthDate);

    public QikUser createUser(QikUser qikUser);

    public QikUser getById(String userId);

    public List<QikUser> getAll();
}
