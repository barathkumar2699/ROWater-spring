package com.example.ROWater.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.ROWater.entity.Engineer;

public interface EngineerRepo extends CrudRepository<Engineer, String> {

}
