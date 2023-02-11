package ec.microdev.application.usecase;

import ec.microdev.domain.documents.QikUser;
import ec.microdev.domain.request.LoginRequest;
import ec.microdev.infrastructure.inputport.AuthInputPort;
import ec.microdev.infrastructure.outputadapter.QikUserAdapter;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthUseCase implements AuthInputPort {

    @Autowired
    QikUserAdapter qikUserAdapter;

    @Override
    public QikUser registerQikuser(QikUser qikUser) {
        return null;
    }

    @Override
    public QikUser loginQikUser(LoginRequest loginRequest) {
        QikUser dbQuikuser = qikUserAdapter.findByUserName(loginRequest.getUsername()).get();
        if(dbQuikuser.getPassword().equals(loginRequest.getPassword())){
            return dbQuikuser;
        }else {
            return new QikUser();
        }
    }
}
