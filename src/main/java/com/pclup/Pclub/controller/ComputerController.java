package com.pclup.Pclub.controller;



import com.pclup.Pclub.model.Computer;
import com.pclup.Pclub.repository.ComputerRepository;
import com.pclup.Pclub.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@Controller
public class ComputerController {



@Autowired
private ComputerService computerService;


    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("computers", computerService.getAllComputers());
        return "index";
    }
}

