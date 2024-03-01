package com.example.demo.service;

import com.example.demo.dto.search.WorkerSearch;
import com.example.demo.entity.QWorker;
import com.example.demo.entity.Worker;
import com.example.demo.repository.WorkerRepository;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
@Transactional
public class WorkerService implements WorkerServiceImpl {
    protected final WorkerRepository workerRepository;
    protected final EntityManager entityManager;
    protected QWorker qWorker;
    protected JPAQuery<Worker> query;


    public WorkerService(WorkerRepository workerRepository, EntityManager entityManager) {
        this.workerRepository = workerRepository;
        this.entityManager = entityManager;
        this.qWorker = QWorker.worker;
        this.query = new JPAQuery<>(entityManager);
        ;
    }

    @Override
    public Page<Worker> getAll(WorkerSearch search) {
        this.query = new JPAQuery<>(entityManager);
        this.query.select(qWorker).from(qWorker);
        if (StringUtils.hasText(search.getName())) {
            this.query.where(qWorker.name.containsIgnoreCase(search.getName()));
        }
        long count = this.query.stream().count();
        var data = this.query.offset((long) search.getPage() * search.getSize()).limit(search.getSize()).fetch();
        return new PageImpl<>(data, PageRequest.of(search.getPage(), search.getSize()), count);
    }

    @Override
    public void deleteWorker(Long id) {
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found id " + id));
        workerRepository.deleteById(id);
    }

    @Override
    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker update(Worker worker, Long id) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker findById(Long id) {
        return workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found id " + id));
    }


}
