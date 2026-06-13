package pl.wsb.fitnesstracker.statistics.api;

public record StatisticShortInfoDTO(
        Long id,
        int totalTrainings,
        double totalDistance,
        int totalCaloriesBurned
) {}