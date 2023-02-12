package ec.microdev.infrastructure.inputport;

import ec.microdev.domain.request.LoginRequest;
import ec.microdev.domain.request.StoreRegisterRequest;
import ec.microdev.domain.request.UserRegisterRequest;
import ec.microdev.domain.response.AuthResponse;

public interface AuthInputPort {
    AuthResponse signinQikUser(UserRegisterRequest qikUserRegistration);

    AuthResponse loginQikUser(LoginRequest loginRequest);

    AuthResponse signinQikStore(StoreRegisterRequest storeRegisterRequest);
}
