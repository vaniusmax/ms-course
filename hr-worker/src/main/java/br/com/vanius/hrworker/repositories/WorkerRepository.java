package br.com.vanius.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vanius.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
