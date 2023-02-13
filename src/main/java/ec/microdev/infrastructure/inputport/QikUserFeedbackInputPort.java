package ec.microdev.infrastructure.inputport;

import ec.microdev.domain.documents.QikUserFeedback;
import ec.microdev.domain.request.FeedbackRequest;

import java.util.List;

public interface QikUserFeedbackInputPort {
    public QikUserFeedback registerFeedback(FeedbackRequest feedback);
    public QikUserFeedback getUserFeedback(String feedbackUUID);
    public List<QikUserFeedback> getAllFeedbackByUserUUID(String userUUID);
    public List<QikUserFeedback> getAllFeedbackComments();
    public QikUserFeedback updateFeedback(QikUserFeedback feedback);
}

