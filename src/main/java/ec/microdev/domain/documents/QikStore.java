package ec.microdev.domain.documents;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection="QikStore")
public class QikStore {
    @Id
    private ObjectId _id;
    private String ownerUUID;
    private String name;
    private String backgroundImage;
    private String category;
    private String iconImage;
    private String status;
    private String urlMapsStore;
    private Integer branchesQuantity;
    private Integer employeeQuantity;
    private Float rating;
    private List<String > socialMedia;
}
