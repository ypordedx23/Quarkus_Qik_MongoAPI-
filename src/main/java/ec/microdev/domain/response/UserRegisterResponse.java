package ec.microdev.domain.response;

import ec.microdev.domain.documents.QikUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserRegisterResponse {
    QikUser qikUser;
    String token;

}
