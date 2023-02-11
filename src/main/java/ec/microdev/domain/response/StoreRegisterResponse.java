package ec.microdev.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StoreRegisterResponse {
    Integer idStore;
    String storeStatus;
    String token;
}
