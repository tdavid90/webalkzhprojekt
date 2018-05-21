package com.example.zhfeladat.service;

import com.example.zhfeladat.models.Computer;
import com.example.zhfeladat.repositories.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {

    private ComputerRepository computerRepository;

    @Autowired
    public void setComputerRepository(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public List<Computer> getAll() {
        Iterable<Computer> allComputers = computerRepository.findAll();

        List<Computer> computerList = new ArrayList<>();
        for(Computer computer : allComputers){
            computerList.add(computer);
        }

        return computerList;
    }

    @Override
    public void add(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public void deleteById(long l) {
        computerRepository.deleteById(l);
    }
}
