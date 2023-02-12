package ec.microdev.application.usecase;

import ec.microdev.domain.documents.QikUser;
import ec.microdev.infrastructure.inputport.QikUserInputPort;
import ec.microdev.infrastructure.outputadapter.QikUserAdapter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class QikUserUseCase implements QikUserInputPort {

    @Autowired
    QikUserAdapter qikUserAdapter;

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

    @Override
    public QikUser updateUser(QikUser qikUser) {
        //QikUser dbQikUser = qikUserAdapter.findById(qikUser.get_id());
        qikUserAdapter.update(qikUser);
        return qikUser;
    }
}
