package com.cbrf.semenov.testtask.controller;


import com.cbrf.semenov.testtask.entity.Company;
import com.cbrf.semenov.testtask.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping
    public String index(Model model) {
        Iterable<Company> companies = companyRepo.findAll();
        model.addAttribute("companies", companies);
        return "index";
    }

    @GetMapping("/search")
    public String searchCompany(@RequestParam(value = "query", required = false) String query,
                                @RequestParam(value = "field", required = false) String field, Model model) {
        if (query == null || query.isEmpty()) {
            return "search";
        }

        List<Company> result = null;

        switch (field) {
            case "name":
                result = companyRepo.findByNameContaining(query);
                break;
            case "address":
                result = companyRepo.findByAddressContaining(query);
                break;
            case "INN":
                result = companyRepo.findByINNContaining(query);
                break;
            case "OGRN":
                result = companyRepo.findByOGRNContaining(query);
                break;
        }

        model.addAttribute("search", result);
        return "search";
    }
}

