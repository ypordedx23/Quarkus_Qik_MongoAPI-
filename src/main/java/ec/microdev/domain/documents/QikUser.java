package ec.microdev.domain.documents;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;



@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection="QikUser")
public class QikUser {
    private ObjectId _id;
    private String token;
    private String username;
    private String password;
    private String cellphone;
    private String email;
    private String birthDate;
    private String status;
    /*private List<String> role;
    * prviate List<String> storeRole*/

}
