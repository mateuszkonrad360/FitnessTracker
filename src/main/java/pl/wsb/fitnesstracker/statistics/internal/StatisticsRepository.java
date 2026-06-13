package pl.wsb.fitnesstracker.statistics.internal;

import pl.wsb.fitnesstracker.statistics.api.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    // Spring sam połączy się z obiektem User wewnątrz encji i wyszuka po jego polach
    Optional<Statistics> findByUserFirstNameAndUserLastName(String firstName, String lastName);

    Optional<Statistics> findByUserEmail(String email);
}