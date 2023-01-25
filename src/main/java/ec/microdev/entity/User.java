package ec.microdev.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "userd")
public class User {

    @Id
    private String id;
    private String userName;
    private String password;

}
