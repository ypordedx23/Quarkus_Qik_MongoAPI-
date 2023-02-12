package ec.microdev.infrastructure.outputadapter;

import ec.microdev.domain.documents.QikUser;
import ec.microdev.infrastructure.outputport.QikUserRepository;
import org.bson.types.ObjectId;

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

    @Override
    public Optional<QikUser> findByUserUUID(String userID) {
        return findByIdOptional(new ObjectId(userID));
    }

    @Override
    public Optional<QikUser> findByEmail(String userEmail) {
        return find("email", userEmail).firstResultOptional();
    }

}
