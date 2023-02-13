package ec.microdev.infrastructure.outputport;

import ec.microdev.domain.documents.QikUserFeedback;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import java.util.List;
import java.util.Optional;

public interface QikUserFeedbackRepository extends PanacheMongoRepository<QikUserFeedback> {
    Optional<List<QikUserFeedback>> getAllUserFeedbackByStoreUUID(String storeUUID);
    Optional<List<QikUserFeedback>> getAllUserFeedbackByUserUUID(String userUUID);
    Optional<QikUserFeedback> getFeedbackByUserUUID(String userUUID);
}
