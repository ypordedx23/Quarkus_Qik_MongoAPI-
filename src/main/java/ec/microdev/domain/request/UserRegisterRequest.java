package ec.microdev.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRegisterRequest {
    String name;
    String lastName;
    String phoneNumber;
    String email;
    String birthDate;
    String password;
}
