package com.example.demo.processor;

import com.example.demo.dto.WorkerDTO;
import com.example.demo.dto.search.WorkerSearch;
import com.example.demo.entity.Worker;
import com.example.demo.service.WorkerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkerProcessor {
    private final WorkerService workerService;

    public WorkerProcessor(WorkerService workerService) {
        this.workerService = workerService;
    }

    public Page<WorkerDTO> getAll(WorkerSearch search) {
        var page =workerService.getAll(search);
        List<WorkerDTO>content = page.getContent().stream().map(this::dataTransferDTO).collect(Collectors.toList());

        return new PageImpl<>(content, PageRequest.of(search.getPage(), search.getSize()),
                page.getTotalElements());
        //return workerService.getAll(search).stream().map(this::dataTransferDTO).collect(Collectors.toList());
    }

    public WorkerDTO save(WorkerDTO workerDTO){
        Worker worker = dataTransferEntity(workerDTO);
        Worker saveWorker = workerService.save(worker);
        return dataTransferDTO(saveWorker);
    }

    public WorkerDTO update(WorkerDTO workerDTO, Long id){
//            workerService.findById(id);
//            Worker worker = dataTransferEntity(workerDTO);
//            Worker saveWorker = workerService.update(worker, id);
//            return dataTransferDTO(saveWorker);
        Worker worker = workerService.findById(id);
        worker.setAddress(workerDTO.getAddress());
         workerService.update(worker, id);
        return dataTransferDTO(worker);
    }

    public WorkerDTO dataTransferDTO(Worker worker) {
        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setAddress(worker.getAddress());
        workerDTO.setName(worker.getName());
        workerDTO.setAge(worker.getAge());
        workerDTO.setGender(worker.getGender());
        return workerDTO;
    }

    public Worker dataTransferEntity(WorkerDTO workerDTO){
        Worker worker = new Worker();
        worker.setAddress(workerDTO.getAddress());
        worker.setName(workerDTO.getName());
        worker.setAge(workerDTO.getAge());
        worker.setGender(workerDTO.isGender());
        return worker;
    }
}
