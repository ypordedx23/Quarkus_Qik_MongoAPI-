package ec.microdev.domain.documents;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection="QikUserFeedBack")
public class QikUserFeedback {
    private ObjectId _id;
    private Integer rating;
    private String description;
    private String userId;
    private String storeId;
    private String ratingDescription;
}
