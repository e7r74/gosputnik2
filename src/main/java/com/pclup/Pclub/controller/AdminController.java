package com.pclup.Pclub.controller;

import com.pclup.Pclub.model.Computer;
import com.pclup.Pclub.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {


@Autowired
private ComputerService computerService;

    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        List<Computer> computers = computerService.getAllComputers();
        model.addAttribute("computers", computers);
        return "admin";
    }

    @PostMapping("/admin/addComputer")
    public String addComputer(Computer computer) {
        computerService.addOrUpdateComputer(computer);
        return "redirect:/admin";
    }

    @PostMapping("/admin/updateComputer")
    public String updateComputerStatus(@RequestParam Long computerId, @RequestParam String status, @RequestParam String bookingTime) {
        computerService.updateComputerStatus(computerId, status, bookingTime);
        return "redirect:/admin";
    }
    @PostMapping("/admin/deleteComputer")
    public String deleteComputer(@RequestParam Long id) {
        computerService.deleteComputer(id);
        return "redirect:/admin";
    }
}


