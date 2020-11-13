package br.com.vanius.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.vanius.hrpayroll.entities.Payment;
import br.com.vanius.hrpayroll.entities.Worker;
import br.com.vanius.hrpayroll.feignclient.WorkerFeignClients;

@Service
public class PaymentService {
	
	
	@Autowired
	private WorkerFeignClients workFeignClients;
	
	public Payment getPayment(long workerId, int days) {
		
	
		
		Worker worker = workFeignClients.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
