package com.example.demo.service;

import com.example.demo.dto.search.WorkerSearch;
import com.example.demo.entity.Worker;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WorkerServiceImpl {
    Page<Worker> getAll(WorkerSearch search);

    void deleteWorker(Long id);

//    Worker findById(Long id);

    Worker save(Worker worker);

    Worker update(Worker worker, Long id);

    Worker findById(Long id);
}
