package ec.microdev.infrastructure.outputadapter;

import ec.microdev.domain.documents.QikUser;
import ec.microdev.infrastructure.outputport.QikUserRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class QikUserAdapter implements QikUserRepository {

    @Override
    public Optional<QikUser> findByUserName(String username) {
        return find("username",username).firstResultOptional();
    }

    @Override
    public boolean existByUsername(String username) {
        return find("username",username).firstResultOptional().isPresent();
    }


}
