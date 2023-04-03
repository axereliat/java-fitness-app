package com.fitness.web.controllers;

import com.fitness.common.exceptions.ResourceNotFoundException;
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

    @PostMapping("/{id}/update")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody RecordBindingModel bindingModel) {
        try {
            recordService.update(id, bindingModel);

            return ResponseEntity.ok(new ResultViewModel("Record was successfully updated"));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getRecord(@PathVariable Integer id) {
        try {
            Record record = this.recordService.getById(id);

            return ResponseEntity.ok(record);
        }
        catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
