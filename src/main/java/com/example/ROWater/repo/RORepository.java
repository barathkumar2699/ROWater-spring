package com.example.ROWater.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.ROWater.entity.ServiceRequest;

public interface RORepository extends CrudRepository<ServiceRequest, Integer> {

}
