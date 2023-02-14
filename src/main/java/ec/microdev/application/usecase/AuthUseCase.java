package ec.microdev.application.usecase;

import ec.microdev.domain.documents.QikStore;
import ec.microdev.domain.documents.QikUser;
import ec.microdev.domain.request.LoginRequest;
import ec.microdev.domain.request.StoreRegisterRequest;
import ec.microdev.domain.request.UserRegisterRequest;
import ec.microdev.domain.response.AuthResponse;
import ec.microdev.infrastructure.inputport.http.AuthInputPort;
import ec.microdev.infrastructure.outputadapter.mongoAdapter.QIkStoreAdapter;
import ec.microdev.infrastructure.outputadapter.mongoAdapter.QikUserAdapter;
import ec.microdev.utils.Constant;
import ec.microdev.utils.Mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AuthUseCase implements AuthInputPort {

    @Inject
    QikUserAdapter qikUserAdapter;

    @Inject
    QIkStoreAdapter qIkStoreAdapter;

    @Override
    public AuthResponse signinQikUser(UserRegisterRequest qikUserRegistration) {
        QikUser qikUser = Mapper.mapToQikUser(qikUserRegistration);
        List<String> roles = new ArrayList<>();
        roles.add(Constant.ROLE_CUSTOMER);
        qikUser.setRole(roles);
        qikUserAdapter.persist(qikUser);
        AuthResponse authResponse = Mapper.mapToAuthResponse(qikUser,"MockToken-IGNORE");
        return authResponse;
    }

    @Override
    public AuthResponse loginQikUser(LoginRequest loginRequest) {
        AuthResponse response = new AuthResponse();
        QikUser dbQikUser = qikUserAdapter.findByEmail(loginRequest.getUsername()).get();
        if(dbQikUser.getPassword().equals(loginRequest.getPassword())){
            response = Mapper.mapToAuthResponse(dbQikUser, "MockToken-IGNORE");
        }
        return response;
    }

    @Override
    public AuthResponse signinQikStore(StoreRegisterRequest storeRegisterRequest) {
        QikUser qikUser = Mapper.mapToQikUser(storeRegisterRequest);
        QikStore qikStore = Mapper.mapToQikStore(storeRegisterRequest);
        List<String> roles = new ArrayList<>();
        roles.add(Constant.ROLE_STORE);
        qikUser.setRole(roles);
        qikUserAdapter.persist(qikUser);
        qikStore.setOwnerUUID(qikUser.get_id().toString());
        qIkStoreAdapter.persist(qikStore);
        AuthResponse response = Mapper.mapToAuthResponse(qikUser,"MockToken-IGNORE");
        return response;
    }
}
