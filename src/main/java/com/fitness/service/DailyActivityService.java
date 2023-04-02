package com.fitness.service;

import com.fitness.domain.entities.DailyActivity;
import com.fitness.domain.models.DailyActivityViewModel;
import com.fitness.domain.repository.DailyActivityRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class DailyActivityService {

    private final DailyActivityRepository dailyActivityRepository;

    public DailyActivityService(DailyActivityRepository dailyActivityRepository) {
        this.dailyActivityRepository = dailyActivityRepository;
    }

    public List<DailyActivityViewModel> getAll() {
        List<DailyActivityViewModel> dailyActivityViewModelList = new ArrayList<>();
        for (DailyActivity dailyActivity : dailyActivityRepository.findAll()) {
            DailyActivityViewModel dailyActivityViewModel = new DailyActivityViewModel();
            dailyActivityViewModel.setId(dailyActivity.getId());

            dailyActivityViewModel.setName(dailyActivity.getName());

            dailyActivityViewModelList.add(dailyActivityViewModel);
        }

        return dailyActivityViewModelList;
    }
}
