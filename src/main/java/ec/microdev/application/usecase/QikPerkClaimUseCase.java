package ec.microdev.application.usecase;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import ec.microdev.domain.documents.QikUserPerkClaim;
import ec.microdev.domain.request.UserPerkClaimRequest;
import ec.microdev.domain.response.UserPerkClaimResponse;
import ec.microdev.infrastructure.inputport.QikUserPerkClaimInputPort;
import ec.microdev.infrastructure.outputadapter.QikUserPerkClaimAdapter;
import ec.microdev.utils.Constant;
import ec.microdev.utils.Mapper;
import ec.microdev.utils.Util;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class QikPerkClaimUseCase implements QikUserPerkClaimInputPort {

    @Inject
    QikUserPerkClaimAdapter qikUserPerkClaimAdapter;

    @Override
    public UserPerkClaimResponse claimPerkOfStore(UserPerkClaimRequest qikPerClaim) {
        QikUserPerkClaim qikUserPerkClaim = Mapper.mapToUserPerkClaim(qikPerClaim);
        qikUserPerkClaim.setClaimedDate(Util.getServerClaimDate());
        qikUserPerkClaim.setStatus(Constant.PERK_CLAIMED_STATUS);
        qikUserPerkClaimAdapter.persist(qikUserPerkClaim);
        UserPerkClaimResponse response = Mapper.mapToUserPerkClaimResponse(qikUserPerkClaim);
        return response;
    }

    @Override
    public QikUserPerkClaim getUserPerkClaim(String userPerkClaimUUID) {
        Optional<QikUserPerkClaim> opPerkClaim = qikUserPerkClaimAdapter.findByClaimedUUID(userPerkClaimUUID);
        QikUserPerkClaim dbQikUserPerkClaim = new QikUserPerkClaim();
        if(opPerkClaim.isPresent()){
            dbQikUserPerkClaim = opPerkClaim.get();
        }
        return dbQikUserPerkClaim;
    }

    @Override
    public List<QikUserPerkClaim> getAllPerksByUserUUID(String userUUID) {
        Optional<List<QikUserPerkClaim>> opList = qikUserPerkClaimAdapter.getAllUserPerkCLAIMByUserUUID(userUUID);
        List<QikUserPerkClaim> dbListPerksClaimByUser = new ArrayList<>();
        if(opList.isPresent()){
            dbListPerksClaimByUser = opList.get();
        }
        return dbListPerksClaimByUser;
    }

    @Override
    public List<QikUserPerkClaim> getAllPerks() {
        return qikUserPerkClaimAdapter.listAll();
    }

    @Override
    public QikUserPerkClaim updatePerkClaimStatus(QikUserPerkClaim qikUserPerkClaim) {
        qikUserPerkClaimAdapter.update(qikUserPerkClaim);
        return qikUserPerkClaim;
    }
}
