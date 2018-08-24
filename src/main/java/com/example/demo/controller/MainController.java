package com.example.demo.controller;

import com.example.demo.model.Advertisment;
import com.example.demo.model.Category;
import com.example.demo.repository.AdvertismentRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AdvertismentRepository advertismentRepository;

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/home")
    public String home(ModelMap modelMap) {
        List<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        List<Advertisment> ads = advertismentRepository.findAll();
        modelMap.addAttribute("ads", ads);
        return "home";
    }

    @GetMapping("/admin")
    public String admin(ModelMap modelMap) {
        List<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "admin";
    }

}
