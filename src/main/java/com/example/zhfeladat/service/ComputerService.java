package com.example.zhfeladat.service;

import com.example.zhfeladat.models.Computer;

import java.util.List;

public interface ComputerService {

    List<Computer> getAll();

    void add(Computer computer);

    void deleteById(long l);

}
