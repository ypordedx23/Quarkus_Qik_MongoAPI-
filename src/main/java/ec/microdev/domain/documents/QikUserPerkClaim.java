package ec.microdev.domain.documents;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@MongoEntity(collection="QikUserClaimPerk")
public class QikUserPerkClaim {
    @Id
    private Object _id;
    private String userId;
    private String perkId;
    private String claimedDate;
    private Integer status;
}
