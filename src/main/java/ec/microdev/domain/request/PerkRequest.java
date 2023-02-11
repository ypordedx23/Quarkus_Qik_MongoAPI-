package ec.microdev.domain.request;

import ec.microdev.domain.documents.QikPerk;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PerkRequest {

    private Integer idStore;
    private QikPerk qikperk;

}
