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
@MongoEntity(collection="QikUserFeedBack")
public class QikUserFeedback {
    @Id
    private ObjectId _id;
    private Float rating;
    private String description;
    private String userId;
    private String storeId;
    private String ratingDescription;
}
