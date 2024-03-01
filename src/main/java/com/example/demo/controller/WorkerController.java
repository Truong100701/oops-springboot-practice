package com.example.demo.controller;


import com.example.demo.dto.WorkerDTO;
import com.example.demo.dto.search.WorkerSearch;
import com.example.demo.processor.WorkerProcessor;
import com.example.demo.service.WorkerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("workers")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @Autowired
    private WorkerProcessor workerProcessor;

    @GetMapping
    public ResponseEntity<?> getAll(@ModelAttribute WorkerSearch search){
        return ResponseEntity.ok(workerProcessor.getAll(search));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            workerService.deleteWorker(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted worker with id " + id + " successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public  ResponseEntity<?> save(@RequestBody WorkerDTO workerDTO){
        return ResponseEntity.ok(workerProcessor.save(workerDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody WorkerDTO workerDTO, @PathVariable Long id){
        return ResponseEntity.ok(workerProcessor.update(workerDTO, id));
    }


}
