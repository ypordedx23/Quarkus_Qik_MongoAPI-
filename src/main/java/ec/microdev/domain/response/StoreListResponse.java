package ec.microdev.domain.response;

import ec.microdev.domain.documents.QikStore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StoreListResponse {
    List<QikStore> storeList;

}
