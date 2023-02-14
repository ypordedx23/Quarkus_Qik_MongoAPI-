package ec.microdev.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class KeycloakAuthResponse { 
    String access_token;
    String expiresIn;
    String refreshExpiresIn;
    String refreshToken;
    String tokenType;
    String notBeforePolicy;
    String sessionState;
    String scope;
    
}
