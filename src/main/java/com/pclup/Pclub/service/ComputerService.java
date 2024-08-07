package com.pclup.Pclub.service;


import com.pclup.Pclub.model.Computer;
import com.pclup.Pclub.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public void addOrUpdateComputer(Computer computer) {
        // Преобразуем номер ПК из строки в число
        int number = Integer.parseInt(computer.getNumber());
        deleteOldEntries(computer.getRoom(), String.valueOf(number));
        computerRepository.save(computer);
    }

    public void deleteOldEntries(String room, String number) {
        List<Computer> computers = computerRepository.findByRoomAndNumber(room, number);
        if (computers.size() > 1) {
            computers.sort((c1, c2) -> c2.getBookingTime().compareTo(c1.getBookingTime()));
            for (int i = 1; i < computers.size(); i++) {
                computerRepository.delete(computers.get(i));
            }
        }
    }

    public void updateComputerStatus(Long computerId, String status, String bookingTime) {
        Computer computer = computerRepository.findById(computerId)
                .orElseThrow(() -> new RuntimeException("Computer not found"));
        computer.setStatus(status);
        computer.setBookingTime(bookingTime);
        computerRepository.save(computer);
    }
    public void deleteComputer(Long id) {
        computerRepository.deleteById(id);
    }
}