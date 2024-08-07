package com.pclup.Pclub.repository;

import com.pclup.Pclub.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

List<Computer> findByRoomAndNumber(String room, String number);
}

