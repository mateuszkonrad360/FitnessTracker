package pl.wsb.fitnesstracker.workoutsession;

import jakarta.persistence.*;
import org.springframework.data.convert.Jsr310Converters;
import pl.wsb.fitnesstracker.training.api.Training;

import java.time.LocalDateTime;

// TODO: Define the Event entity with appropriate fields and annotations
@Entity
public abstract class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Training training;
    private LocalDateTime timestamp;
    private double startLatitude;
    private double startLongitude;
    private double endLatitude;
    private double endLongitude;
    private double altitude;

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public Training getTraining() {
        return training;
    }

    public LocalDateTime
    getTimestamp() {
        return timestamp;
    }

    public void
    setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double
    getStartLatitude(double startLatitude) {
        return startLatitude;
    }

    public void
    setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double
    getStartLatitude() {
        return startLatitude;
    }

    public void
    setStartLongitude(double startLatitude) {
        this.startLatitude =
                startLatitude;
    }

    public double getEndLatitude()
    {
        return endLatitude;
    }

    public void
    setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
}