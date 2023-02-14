package ec.microdev.infrastructure.outputadapter.mongoAdapter;

import ec.microdev.domain.documents.QikUserFeedback;
import ec.microdev.infrastructure.outputport.mongoRepository.QikUserFeedbackRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class QikUserFeedbackAdapter implements QikUserFeedbackRepository {
    @Override
    public Optional<List<QikUserFeedback>> getAllUserFeedbackByStoreUUID(String storeUUID) {
        Optional optionalList = Optional.of(list("storeId",storeUUID));
        return optionalList;
    }

    @Override
    public Optional<List<QikUserFeedback>> getAllUserFeedbackByUserUUID(String userUUID) {
        Optional optionalList = Optional.of(list("userId",userUUID));
        return optionalList;
    }

    @Override
    public Optional<QikUserFeedback> getFeedbackByUserUUID(String userUUID) {
        return find("userId",userUUID).firstResultOptional();
    }
}
