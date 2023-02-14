package ec.microdev.infrastructure.inputadapter.http;

import ec.microdev.domain.documents.QikUserFeedback;
import ec.microdev.domain.request.FeedbackRequest;
import ec.microdev.infrastructure.inputport.http.QikUserFeedbackInputPort;
import io.quarkus.vertx.web.*;

import javax.inject.Inject;
import java.util.List;

@RouteBase(path = "qikAPI/feedback")
public class QikFeedbackAPI {

    @Inject
    QikUserFeedbackInputPort qikUserFeedbackInputPort;

    @Route(path = "", methods = Route.HttpMethod.POST, produces = ReactiveRoutes.JSON_STREAM)
    public QikUserFeedback registerFeedback(@Body FeedbackRequest feedback){
        return qikUserFeedbackInputPort.registerFeedback(feedback);
    };

    @Route(path = ":feedbackUUID", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    public QikUserFeedback getUserFeedback(@Param String feedbackUUID){
        return qikUserFeedbackInputPort.getUserFeedback(feedbackUUID);
    };

    @Route(path = "user/:userUUID", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    public List<QikUserFeedback> getAllFeedbackByUserUUID(@Param String userUUID){
        return qikUserFeedbackInputPort.getAllFeedbackByUserUUID(userUUID);
    };

    @Route(path = "", methods = Route.HttpMethod.GET, produces = ReactiveRoutes.JSON_STREAM)
    public List<QikUserFeedback> getAllFeedbackComments(){
        return qikUserFeedbackInputPort.getAllFeedbackComments();
    };

    @Route(path = "update", methods = Route.HttpMethod.PUT, produces = ReactiveRoutes.JSON_STREAM)
    public QikUserFeedback updateFeedback(@Body QikUserFeedback feedback){
        return qikUserFeedbackInputPort.updateFeedback(feedback);
    };
}
