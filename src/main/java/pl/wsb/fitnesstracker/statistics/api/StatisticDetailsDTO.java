package pl.wsb.fitnesstracker.statistics.api;

public record StatisticDetailsDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        int totalTrainings,
        double totalDistance,
        int totalCaloriesBurned
) {}