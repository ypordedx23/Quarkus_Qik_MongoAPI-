package ec.microdev.application.usecase;

import ec.microdev.domain.documents.QikUser;
import ec.microdev.infrastructure.inputport.QikUserInputPort;
import ec.microdev.infrastructure.outputadapter.QikUserAdapter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

import static ec.microdev.utils.Constant.STATUS_ACTIVE;

@Component
public class QikUserUseCase implements QikUserInputPort {

    @Autowired
    QikUserAdapter qikUserAdapter;

    @Override
    public QikUser createUser(String username, String password, String cellphone, String email, String birthDate) {
        QikUser qikuser = new QikUser();
        qikuser.setCellphone(cellphone);
        qikuser.setPassword(password);
        qikuser.setStatus(STATUS_ACTIVE);
        qikuser.setEmail(email);
        qikuser.setBirthDate(birthDate);
        qikUserAdapter.persist(qikuser);
        return qikuser;
    }

    @Override
    public QikUser createUser(QikUser qikUser) {
        qikUserAdapter.persist(qikUser);
        return qikUser;
    }

    @Override
    public QikUser getById(String userId) {
            return qikUserAdapter.findById(new ObjectId(userId));
    }

    @Override
    public List<QikUser> getAll() {
        return qikUserAdapter.listAll();
    }
}
