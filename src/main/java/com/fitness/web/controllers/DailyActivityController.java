package com.fitness.web.controllers;

import com.fitness.domain.models.DailyActivityViewModel;
import com.fitness.service.DailyActivityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class DailyActivityController {

    private final DailyActivityService dailyActivityService;

    public DailyActivityController(DailyActivityService dailyActivityService) {
        this.dailyActivityService = dailyActivityService;
    }

    @GetMapping
    public List<DailyActivityViewModel> show() {
        return dailyActivityService.getAll();
    }
}
