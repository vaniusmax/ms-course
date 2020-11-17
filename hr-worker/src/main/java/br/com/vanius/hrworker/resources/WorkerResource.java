package br.com.vanius.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import br.com.vanius.hrworker.entities.Worker;
import br.com.vanius.hrworker.repositories.WorkerRepository;


@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Value("${test.config}")
	private String config;
	
	@Autowired
	private Environment env;
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private WorkerRepository repo;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfig(){
		logger.info("CONFIGS + "+ config);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repo.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		logger.info("PORT ="+ env.getProperty("local.server.port"));
		
		Worker obj = repo.findById(id).get();
		return ResponseEntity.ok(obj);
	}

}
