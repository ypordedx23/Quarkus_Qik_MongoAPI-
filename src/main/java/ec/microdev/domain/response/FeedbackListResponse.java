package ec.microdev.domain.response;


import ec.microdev.domain.documents.QikUserFeedback;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class FeedbackListResponse {
    List<QikUserFeedback> storePerks;

}
