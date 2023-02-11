package ec.microdev.domain.documents;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection="QikStore")
public class QikStore {
    private ObjectId _id;
    private String name;
    private String backgroundImage;
    private String category;
    private String iconImage;
    private String urlMapsStore;
    private Integer branchesQuantity;
    private Integer employeeQuantity;
    private List<String > socialMedia;
}
