package br.com.vanius.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.vanius.hrpayroll.entities.Payment;
import br.com.vanius.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String host;
	
	@Autowired
	private RestTemplate template;
	
	public Payment getPayment(long workerId, int days) {
		
		Map<String, String> params = new HashMap<>();
		params.put("id", ""+workerId);
		
		Worker worker = template.getForObject(host + "/workers/{id}", Worker.class, params);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
