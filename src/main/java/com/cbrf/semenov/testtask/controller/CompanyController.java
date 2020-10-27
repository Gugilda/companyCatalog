package com.cbrf.semenov.testtask.controller;

import com.cbrf.semenov.testtask.entity.Company;
import com.cbrf.semenov.testtask.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepo companyRepo;

    @PostMapping("/company")
    public String saveCompany(@Valid Company company, BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            model.addAttribute("errors", errorList);
            return "company";
        }

        if (companyRepo.findByName(company.getName()) != null) {
            bindingResult.rejectValue("name", null, "Компания с таким названием уже существует");
            return "company";
        }

        if (companyRepo.findByINN(company.getINN()) != null) {
            bindingResult.rejectValue("INN", null, "Компания с таким ИНН уже существует");
            return "company";
        }

        if (companyRepo.findByOGRN(company.getOGRN()) != null) {
            bindingResult.rejectValue("OGRN", null, "Компания с таким ОГРН уже существует");
            return "company";
        }

        companyRepo.save(company);
        return "redirect:/";
    }

    @GetMapping("/company")
    public String sendForm(Company company) {
        return "company";
    }
}
