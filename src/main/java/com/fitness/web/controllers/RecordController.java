package com.fitness.web.controllers;

import com.fitness.domain.entities.Record;
import com.fitness.domain.models.RecordBindingModel;
import com.fitness.domain.models.ResultViewModel;
import com.fitness.service.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public List<Record> show() {
        return recordService.getAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody RecordBindingModel bindingModel) {
        recordService.create(bindingModel);

        return ResponseEntity.ok(new ResultViewModel("Record was successfully created"));
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity destroy(@PathVariable Integer id) {
        recordService.destroy(id);

        return ResponseEntity.ok(new ResultViewModel("Record was successfully removed"));
    }
}
