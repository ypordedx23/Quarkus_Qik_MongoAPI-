package ec.microdev.application.usecase;

import ec.microdev.domain.documents.QikSubscription;
import ec.microdev.domain.request.SubscriptionRequest;
import ec.microdev.domain.response.SubscriptionResponse;
import ec.microdev.infrastructure.inputport.QikSubscriptionInputPort;
import ec.microdev.infrastructure.outputadapter.QikSubscriptionAdapter;
import ec.microdev.utils.Constant;
import ec.microdev.utils.Mapper;
import ec.microdev.utils.Util;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class QikSubscriptionUseCase implements QikSubscriptionInputPort {

    @Inject
    QikSubscriptionAdapter qikSubscriptionAdapter;
    @Override
    public SubscriptionResponse subscribeToStore(SubscriptionRequest qikSubscriptionRequest) {
        QikSubscription qikSubscription = Mapper.mapToQikSubscription(qikSubscriptionRequest);
        qikSubscription.setSubscriptionDate(Util.getServerClaimDate());
        qikSubscription.setActive(true);
        qikSubscription.setStatus(Constant.STATUS_ACTIVE);
        qikSubscriptionAdapter.persist(qikSubscription);
        SubscriptionResponse response = Mapper.mapToSubscriptionResponse(qikSubscription);
        return response;
    }

    @Override
    public QikSubscription getSubscription(String subscriptionUUID) {
        Optional<QikSubscription> opSubscription = qikSubscriptionAdapter.findByIdOptional(new ObjectId(subscriptionUUID));
        QikSubscription subscription = new QikSubscription();
        if(opSubscription.isPresent()){
            subscription = opSubscription.get();
        }
        return subscription;
    }

    @Override
    public List<QikSubscription> getSubscriptionListByUserUUID(String userUUID) {
        Optional<List<QikSubscription>> opList = qikSubscriptionAdapter.getAllUserSubscriptionByUserUUID(userUUID);
        List<QikSubscription> dbSubscriptionList = new ArrayList<>();
        if(opList.isPresent()){
            dbSubscriptionList = opList.get();
        }
        return dbSubscriptionList;
    }

    @Override
    public List<QikSubscription> getAllSubscriptions() {
        return qikSubscriptionAdapter.listAll();
    }

    @Override
    public QikSubscription updateSubscriptionStatus(String subscriptionUUID, String status) {
        QikSubscription qikSubscription = qikSubscriptionAdapter.findById(new ObjectId(subscriptionUUID));
        qikSubscription.setStatus(status);
        qikSubscriptionAdapter.update(qikSubscription);
        return qikSubscription;
    }
}
