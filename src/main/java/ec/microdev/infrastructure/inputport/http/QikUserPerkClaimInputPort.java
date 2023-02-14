package ec.microdev.infrastructure.inputport.http;

import ec.microdev.domain.documents.QikUserPerkClaim;
import ec.microdev.domain.request.UserPerkClaimRequest;
import ec.microdev.domain.response.UserPerkClaimResponse;

import java.util.List;

public interface QikUserPerkClaimInputPort {
    public UserPerkClaimResponse claimPerkOfStore(UserPerkClaimRequest qikStore);
    public QikUserPerkClaim getUserPerkClaim(String userPerkClaimUUID);
    public List<QikUserPerkClaim> getAllPerksByUserUUID(String userUUID);
    public List<QikUserPerkClaim> getAllPerks();
    public QikUserPerkClaim updatePerkClaimStatus(QikUserPerkClaim qikUser);
}
