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
@MongoEntity(collection="QikPerk")
public class QikPerk {
    @Id
    private ObjectId _id;
    private String name;
    private String description;
    private String termsAndConditions;
    private String startDate;
    private String endDate;
    private String storeId;
}
