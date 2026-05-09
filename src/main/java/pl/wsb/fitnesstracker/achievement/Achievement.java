package pl.wsb.fitnesstracker.achievement;

import jakarta.persistence.*;
import pl.wsb.fitnesstracker.user.api.User;
import java.time.LocalDateTime;

@Entity
@Table(name = "achievement")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "earned_at")
    private LocalDateTime earnedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Pusty konstruktor wymagany przez JPA (Hibernate)
    public Achievement() {
    }

    // Konstruktor z parametrami do wygodnego tworzenia obiektów
    public Achievement(String name, LocalDateTime earnedAt, User user) {
        this.name = name;
        this.earnedAt = earnedAt;
        this.user = user;
    }

    // --- Gettery i Settery ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEarnedAt() {
        return earnedAt;
    }

    public void setEarnedAt(LocalDateTime earnedAt) {
        this.earnedAt = earnedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}