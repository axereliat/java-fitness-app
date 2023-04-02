package com.fitness.config;

import com.fitness.domain.entities.DailyActivity;
import com.fitness.domain.repository.DailyActivityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InitialData {

    private static final String BENCH_PRESS = "Bench Press";
    private static final String DEADLIFT = "Deadlift";
    private static final String SQUATS = "Squats";
    private static final String MILITARY_PRESS = "Military Press";
    private static final String BICEP_CURL = "Bicep Curl";

    private final DailyActivityRepository dailyActivityRepository;

    public InitialData(DailyActivityRepository dailyActivityRepository) {
        this.dailyActivityRepository = dailyActivityRepository;
    }

    private void seedActivities() {
        if (dailyActivityRepository.findAll().size() > 0) {
            return;
        }

        DailyActivity benchPress = DailyActivity.builder()
                .name(BENCH_PRESS)
                .build();

        DailyActivity militaryPress = DailyActivity.builder()
                .name(MILITARY_PRESS)
                .build();

        DailyActivity deadlift = DailyActivity.builder()
                .name(DEADLIFT)
                .build();

        DailyActivity squats = DailyActivity.builder()
                .name(SQUATS)
                .build();

        DailyActivity bicepCurl = DailyActivity.builder()
                .name(BICEP_CURL)
                .build();

        this.dailyActivityRepository.save(benchPress);
        this.dailyActivityRepository.save(militaryPress);
        this.dailyActivityRepository.save(deadlift);
        this.dailyActivityRepository.save(squats);
        this.dailyActivityRepository.save(bicepCurl);
    }

    @PostConstruct
    public void seedData() {
        seedActivities();
    }
}
