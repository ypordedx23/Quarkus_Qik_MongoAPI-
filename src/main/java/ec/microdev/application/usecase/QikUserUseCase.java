package ec.microdev.application.usecase;

import ec.microdev.domain.documents.QikUser;
import ec.microdev.infrastructure.inputport.http.QikUserInputPort;
import ec.microdev.infrastructure.outputadapter.mongoAdapter.QikUserAdapter;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class QikUserUseCase implements QikUserInputPort {

    @Inject
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
