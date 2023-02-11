package ec.microdev.infrastructure.inputport;

import ec.microdev.domain.documents.QikUser;
import ec.microdev.domain.request.LoginRequest;
import io.quarkus.vertx.web.Body;

public interface AuthInputPort {
    QikUser registerQikuser(QikUser qikUser);

    QikUser loginQikUser(LoginRequest loginRequest);
}
