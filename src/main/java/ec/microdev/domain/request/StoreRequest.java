package ec.microdev.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StoreRequest {
    private String storeName;
    private String password;
    private String ownerName;
    private String category;
    private String ownerCharge;
    private String phoneNumber;
    private  String bussinesEmail;
    private String urlMapsStore;
    private Integer branchesQuantity;
    private Integer employeeQuantity;
    private List<String> socialMedia;

}
