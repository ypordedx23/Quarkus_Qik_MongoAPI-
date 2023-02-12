package ec.microdev.utils;

import ec.microdev.domain.documents.*;
import ec.microdev.domain.request.*;
import ec.microdev.domain.response.AuthResponse;
import ec.microdev.domain.response.SubscriptionResponse;
import ec.microdev.domain.response.UserPerkClaimResponse;

public class Mapper {
    public static QikUser mapToQikUser(UserRegisterRequest registrationRequest){
        QikUser mappedQikUser = new QikUser();
        mappedQikUser.setCellphone(registrationRequest.getPhoneNumber());
        mappedQikUser.setEmail(registrationRequest.getEmail());
        mappedQikUser.setBirthDate(registrationRequest.getBirthDate());
        mappedQikUser.setName(registrationRequest.getName());
        mappedQikUser.setLastName(registrationRequest.getLastName());
        mappedQikUser.setPassword(registrationRequest.getPassword());
        return mappedQikUser;
    }

    public static QikUser mapToQikUser(StoreRegisterRequest registerRequest){
        QikUser mappedQikUser = new QikUser();
        mappedQikUser.setCharge(registerRequest.getOwnerCharge());
        mappedQikUser.setName(registerRequest.getOwnerName());
        mappedQikUser.setEmail(registerRequest.getBussinesEmail());
        mappedQikUser.setCellphone(registerRequest.getPhoneNumber());
        mappedQikUser.setPassword(registerRequest.getPassword());
        return mappedQikUser;
    }

    public static QikStore mapToQikStore(StoreRegisterRequest registerRequest){
        QikStore mappedQikStore = new QikStore();
        mappedQikStore.setName(registerRequest.getStoreName());
        mappedQikStore.setUrlMapsStore(registerRequest.getUrlMapsStore());
        mappedQikStore.setCategory(registerRequest.getCategory());
        mappedQikStore.setBranchesQuantity(registerRequest.getBranchesQuantity());
        mappedQikStore.setEmployeeQuantity(registerRequest.getEmployeeQuantity());
        mappedQikStore.setSocialMedia(registerRequest.getSocialMedia());
        return mappedQikStore;
    }

    public static AuthResponse mapToAuthResponse(QikUser qikUser,String tokken){
        AuthResponse mappedAuthResponse = new AuthResponse();
        mappedAuthResponse.setQikUser(qikUser);
        mappedAuthResponse.setToken(tokken);
        return mappedAuthResponse;
    }

    public static QikUserFeedback mapToQikUserFeedback(FeedbackRequest feedback) {
        QikUserFeedback mappedUserFeedback = new QikUserFeedback();
        mappedUserFeedback.setUserId(feedback.getUserId());
        mappedUserFeedback.setStoreId(feedback.getStoreId());
        mappedUserFeedback.setRating(feedback.getRating());
        mappedUserFeedback.setRatingDescription(feedback.getRatingDescription());
        mappedUserFeedback.setDescription(feedback.getDescription());
        return mappedUserFeedback;
    }

    public static QikUserPerkClaim mapToUserPerkClaim(UserPerkClaimRequest qikPerClaim) {
        QikUserPerkClaim mappedUserQikPerkClaim = new QikUserPerkClaim();
        mappedUserQikPerkClaim.setUserId(qikPerClaim.getUserUUID());
        mappedUserQikPerkClaim.setPerkId(qikPerClaim.getUserUUID());
        return mappedUserQikPerkClaim;
    }

    public static UserPerkClaimResponse mapToUserPerkClaimResponse(QikUserPerkClaim qikUserPerkClaim) {
        UserPerkClaimResponse mappedUserPerkClaimResponse = new UserPerkClaimResponse();
        mappedUserPerkClaimResponse.setClaimedDate(qikUserPerkClaim.getClaimedDate());
        mappedUserPerkClaimResponse.setStatus(qikUserPerkClaim.getStatus());
        return mappedUserPerkClaimResponse;
    }

    public static QikSubscription mapToQikSubscription(SubscriptionRequest qikSubscriptionRequest) {
        QikSubscription mappedQikSubscription = new QikSubscription();
        mappedQikSubscription.setQikStoreId(qikSubscriptionRequest.getStoreId());
        mappedQikSubscription.setQikUserId(qikSubscriptionRequest.getUserId());
        return mappedQikSubscription;
    }

    public static SubscriptionResponse mapToSubscriptionResponse(QikSubscription qikSubscription) {
        SubscriptionResponse mappedSubscriptionResponse = new SubscriptionResponse();
        mappedSubscriptionResponse.setSubscriptionDate(qikSubscription.getSubscriptionDate());
        mappedSubscriptionResponse.setSubscriptionStatus(qikSubscription.getStatus());
        return mappedSubscriptionResponse;
    }
}
