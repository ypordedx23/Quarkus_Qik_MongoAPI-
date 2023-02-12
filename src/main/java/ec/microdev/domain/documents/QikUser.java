package ec.microdev.domain.documents;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import javax.persistence.Id;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection="QikUser")
public class QikUser {
    @Id
    private ObjectId _id;
    private String token;
    private String username;
    private String password;
    private String cellphone;
    private String email;
    private String birthDate;
    private String status;
    private String name;
    private String lastName;
    private String charge;
    private List<String> role;
    /*private List<String> role;
    * prviate List<String> storeRole*/

}
