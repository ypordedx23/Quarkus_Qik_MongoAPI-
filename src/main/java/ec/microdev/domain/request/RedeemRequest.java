package ec.microdev.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RedeemRequest {
    Integer perkId;
    Integer userId;

}
