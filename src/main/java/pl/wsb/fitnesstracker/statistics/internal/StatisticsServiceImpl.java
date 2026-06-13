package pl.wsb.fitnesstracker.statistics.internal;

import pl.wsb.fitnesstracker.statistics.api.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class StatisticsServiceImpl implements StatisticsProvider {

    private final StatisticsRepository statisticsRepository;

    public StatisticsServiceImpl(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    // Wymaganie 1: Wylistowanie wszystkich statystyk (ID statystyki + imię i nazwisko)
    @Override
    public List<StatisticShortInfoDTO> findAllShortInfo() {
        return statisticsRepository.findAll().stream()
                .map(stat -> new StatisticShortInfoDTO(
                        stat.getId(),                  // ID statystyki
                        stat.getTotalTrainings(),      // Liczba treningów
                        stat.getTotalDistance(),       // Dystans
                        stat.getTotalCaloriesBurned()
                ))
                .toList();
    }

    // Wymaganie 2: Pobranie pełnych szczegółów danej statystyki
    @Override
    public StatisticDetailsDTO findDetailsByCriteria(Long id, String firstName, String lastName, String email) {
        Statistics statEntity;

        if (id != null) {
            statEntity = statisticsRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brak statystyki o ID: " + id));
        } else if (firstName != null && lastName != null) {
            statEntity = statisticsRepository.findByUserFirstNameAndUserLastName(firstName, lastName)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brak statystyki dla użytkownika: " + firstName + " " + lastName));
        } else if (email != null) {
            statEntity = statisticsRepository.findByUserEmail(email)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brak statystyki dla maila: " + email));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Musisz podać co najmniej jeden parametr wyszukiwania.");
        }

        // Mapujemy obiekt na pełne DTO statystyk
        return new StatisticDetailsDTO(
                statEntity.getId(),
                statEntity.getUser().getFirstName(),
                statEntity.getUser().getLastName(),
                statEntity.getUser().getEmail(),
                statEntity.getTotalTrainings(),
                statEntity.getTotalDistance(),
                statEntity.getTotalCaloriesBurned()
        );
    }

    @Override
    public Optional<Statistics> getStatistics(Long statisticsId) {
        return Optional.empty();
    }
}