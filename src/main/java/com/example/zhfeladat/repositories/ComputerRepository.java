package com.example.zhfeladat.repositories;

import com.example.zhfeladat.models.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends CrudRepository<Computer, Long> {
}
