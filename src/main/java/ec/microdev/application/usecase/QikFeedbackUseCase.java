package ec.microdev.application.usecase;

import ec.microdev.domain.documents.QikUserFeedback;
import ec.microdev.domain.request.FeedbackRequest;
import ec.microdev.infrastructure.inputport.http.QikUserFeedbackInputPort;
import ec.microdev.infrastructure.outputadapter.mongoAdapter.QikUserFeedbackAdapter;
import org.bson.types.ObjectId;
import ec.microdev.utils.Mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class QikFeedbackUseCase implements QikUserFeedbackInputPort {

    @Inject
    QikUserFeedbackAdapter qikUserFeedbackAdapter;

    @Override
    public QikUserFeedback registerFeedback(FeedbackRequest feedback) {
        QikUserFeedback qikUserFeedback = Mapper.mapToQikUserFeedback(feedback);
        qikUserFeedbackAdapter.persist(qikUserFeedback);
        return qikUserFeedback;
    }

    @Override
    public QikUserFeedback getUserFeedback(String feedbackUUID) {
        Optional<QikUserFeedback> opUserFeedback = qikUserFeedbackAdapter.findByIdOptional(new ObjectId(feedbackUUID));
        QikUserFeedback dbQikUserFeedback = new QikUserFeedback();
        if(opUserFeedback.isPresent()){
            dbQikUserFeedback = opUserFeedback.get();
        }
        return dbQikUserFeedback;
    }

    @Override
    public List<QikUserFeedback> getAllFeedbackByUserUUID(String userUUID) {
        List<QikUserFeedback> userFeedbacks = new ArrayList<>();
        Optional<List<QikUserFeedback>> list = qikUserFeedbackAdapter.getAllUserFeedbackByUserUUID(userUUID);
        if(list.isPresent()){
            userFeedbacks = list.get();
        }
        return userFeedbacks;
    }


    public List<QikUserFeedback> getAllFeedbackByStoreUUID(String storeUUID) {
        List<QikUserFeedback> storeFeedbacks = new ArrayList<>();
        Optional<List<QikUserFeedback>> list = qikUserFeedbackAdapter.getAllUserFeedbackByStoreUUID(storeUUID);
        if(list.isPresent()){
            storeFeedbacks = list.get();
        }
        return storeFeedbacks;
    }


    @Override
    public List<QikUserFeedback> getAllFeedbackComments() {
        /*
        * TO DO
        * */
        return qikUserFeedbackAdapter.listAll();
    }

    @Override
    public QikUserFeedback updateFeedback(QikUserFeedback feedback) {
        qikUserFeedbackAdapter.update(feedback);
        return feedback;
    }
}
