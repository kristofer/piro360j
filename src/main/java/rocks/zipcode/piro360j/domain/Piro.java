package rocks.zipcode.piro360j.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "piros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "video_url")
    private String s3UrlToVideo;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "location")
    private String location;

    @Column(name = "created_at", nullable = false, updatable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime created;

    @ManyToMany(mappedBy = "piros")
    private Set<Tag> tags = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User owner;

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
    }

    // Helper methods for managing bidirectional relationships
    // public void addTag(Tag tag) {
    //     tags.add(tag);
    //     tag.getPiros().add(this);
    // }

    // public void removeTag(Tag tag) {
    //     tags.remove(tag);
    //     tag.getPiros().remove(this);
    // }
}