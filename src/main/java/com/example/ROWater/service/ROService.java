package com.example.ROWater.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ROWater.entity.Engineer;
import com.example.ROWater.entity.Master;
import com.example.ROWater.entity.ServiceRequest;
import com.example.ROWater.repo.EngineerRepo;
import com.example.ROWater.repo.MasterRepo;
import com.example.ROWater.repo.RORepository;

@Service
public class ROService {

	@Autowired
	RORepository ROrepo;
	@Autowired
	MasterRepo MasterRepo;
	@Autowired
	EngineerRepo EngineerRepo;
	
	public void prepopulate() {
		Master obj=new Master(14012, "8017155642", "RO51J2");
		Master obj2=new Master(12117, "9015674215", "RO51J9");
		Master obj3=new Master(14558, "9876543211", "RO52Q4");
		MasterRepo.save(obj);
		MasterRepo.save(obj2);
		MasterRepo.save(obj3);
		Engineer ebj=new Engineer("E001", "Kuldeep Mishra", "9638521234");
		Engineer ebj1=new Engineer("E002", "Akshay Sony", "7369514785");
		Engineer ebj2=new Engineer("E003", "Manish Ketan", "9765432118");
		EngineerRepo.save(ebj);
		EngineerRepo.save(ebj1);
		EngineerRepo.save(ebj2);
	}
	
	public List<Master> getCustomer() {
		Iterable<Master> iter = MasterRepo.findAll();
		List<Master> obj=new ArrayList<Master>();
		iter.forEach(e->obj.add(e));
		return obj;
	}
	public List<Engineer> getEngineer() {
		Iterable<Engineer> iter = EngineerRepo.findAll();
		List<Engineer> obj=new ArrayList<Engineer>();
		iter.forEach(e->obj.add(e));
		return obj;
	}

	public Master getByCustomerId(Integer id) {
		// TODO Auto-generated method stub
		  Master master = MasterRepo.findById(id).get();
		  return master;
		
	}

	public ServiceRequest saveServiceReuest(Master customer, String description, String engineer) {
		// TODO Auto-generated method stub
		ServiceRequest obj=new ServiceRequest();
		obj.setConsumerId(customer.getConsumerId());
		obj.setEngineerId(engineer);
		obj.setRequestDate(new Date());
		obj.setDescription(description);
		obj.setStatus("BOOKED");
		ROrepo.save(obj);
		return obj;
	}

	public  List<ServiceRequest> getServices() {
		// TODO Auto-generated method stub
		Iterable<ServiceRequest> findAll = ROrepo.findAll();
		List<ServiceRequest> obj=new ArrayList<ServiceRequest>();
		findAll.forEach(e->obj.add(e));
		return obj;
		
	}

	
}
