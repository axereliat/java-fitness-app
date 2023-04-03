package com.fitness.service;

import com.fitness.common.exceptions.ResourceNotFoundException;
import com.fitness.domain.entities.DailyActivity;
import com.fitness.domain.entities.Record;
import com.fitness.domain.models.RecordBindingModel;
import com.fitness.domain.repository.DailyActivityRepository;
import com.fitness.domain.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    private final DailyActivityRepository dailyActivityRepository;

    public RecordService(RecordRepository recordRepository, DailyActivityRepository dailyActivityRepository) {
        this.recordRepository = recordRepository;
        this.dailyActivityRepository = dailyActivityRepository;
    }

    public List<Record> getAll() {
        return this.recordRepository.findAll();
    }

    public void create(RecordBindingModel bindingModel) {
        DailyActivity dailyActivity = this.dailyActivityRepository.findById(bindingModel.getActivityType())
                .orElseThrow(ResourceNotFoundException::new);

        Record record = Record.builder()
                .reps(bindingModel.getReps())
                .sets(bindingModel.getSets())
                .dailyActivity(dailyActivity)
                .build();

        this.recordRepository.save(record);
    }

    public void destroy(Integer id) {
        this.recordRepository.deleteById(id);
    }

    public void update(Integer id, RecordBindingModel bindingModel) {
        DailyActivity dailyActivity = this.dailyActivityRepository.findById(bindingModel.getActivityType())
                .orElseThrow(ResourceNotFoundException::new);

        Record record = recordRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        record.setReps(bindingModel.getReps());
        record.setSets(bindingModel.getSets());
        record.setDailyActivity(dailyActivity);

        this.recordRepository.save(record);
    }

    public Record getById(Integer id) {
        return this.recordRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
