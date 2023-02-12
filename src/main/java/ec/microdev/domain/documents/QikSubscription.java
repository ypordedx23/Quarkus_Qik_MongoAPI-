package ec.microdev.domain.documents;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection="QikSubscription")
public class QikSubscription {
    @Id
    private ObjectId _id;
    private String qikUserId;
    private String qikStoreId;
    private boolean active;
    private String status;
    private String subscriptionDate;
}
