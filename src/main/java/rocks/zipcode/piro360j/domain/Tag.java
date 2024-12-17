package rocks.zipcode.piro360j.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    @ManyToMany
    @JoinTable(
        name = "tag_piro",
        joinColumns = @JoinColumn(name = "tag_id"),
        inverseJoinColumns = @JoinColumn(name = "piro_id")
    )
    private Set<Piro> piros;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = true)
    private User owner;
}
