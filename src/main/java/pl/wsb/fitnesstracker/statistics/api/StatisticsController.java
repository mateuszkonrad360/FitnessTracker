package pl.wsb.fitnesstracker.statistics.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticsProvider statisticsProvider;

    public StatisticsController(StatisticsProvider statisticsProvider) {
        this.statisticsProvider = statisticsProvider;
    }

    // Zadanie 1: Lista podstawowych informacji (ID + Imię i Nazwisko jako username)
    @GetMapping
    public ResponseEntity<List<StatisticShortInfoDTO>> getAllStatisticsShortInfo() {
        return ResponseEntity.ok(statisticsProvider.findAllShortInfo());
    }

    // Zadanie 2: Szczegóły po dowolnym parametrze
    @GetMapping("/search")
    public ResponseEntity<StatisticDetailsDTO> getStatisticDetails(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email) {

        return ResponseEntity.ok(statisticsProvider.findDetailsByCriteria(id, firstName, lastName, email));
    }
}