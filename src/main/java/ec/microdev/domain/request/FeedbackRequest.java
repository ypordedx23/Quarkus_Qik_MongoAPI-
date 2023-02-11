package ec.microdev.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FeedbackRequest {
    private Integer rating;
    private String description;
    private String storeId;
    private String ratingDescription;
}
