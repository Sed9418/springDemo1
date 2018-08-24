package com.example.demo.controller;

import com.example.demo.model.Advertisment;
import com.example.demo.model.Category;
import com.example.demo.repository.AdvertismentRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cat")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AdvertismentRepository advertismentRepository;

    @GetMapping("/findAdsByCategory/{id}")
    public String delete(@PathVariable("id") int id, ModelMap modelMap) {
        List<Category> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        List<Advertisment> ads = advertismentRepository.findAdvertismentsByCategory_Id(id);
        modelMap.addAttribute("ads", ads);
        return "home";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/";
    }

}
