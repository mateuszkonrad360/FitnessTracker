package pl.wsb.fitnesstracker.event;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event") // Zmienione z 'events' na 'event'
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime startDate;
    private String location;

    public Event() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}