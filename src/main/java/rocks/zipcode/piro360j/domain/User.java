package rocks.zipcode.piro360j.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name = "pirousers")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "owner")
    private Set<Piro> piros;

    @OneToMany(mappedBy = "owner")
    private Set<Tag> tags;
}
