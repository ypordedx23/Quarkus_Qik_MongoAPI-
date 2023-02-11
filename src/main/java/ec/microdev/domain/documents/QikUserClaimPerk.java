package ec.microdev.domain.documents;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection="QikUserClaimPerk")
public class QikUserClaimPerk {
    private Object _id;
    private String userId;
    private String perkId;
}
