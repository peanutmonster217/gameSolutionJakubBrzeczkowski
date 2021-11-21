package com.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    PersonRepository personRepository;

    @GetMapping("/addusers")
    String addUsers(Model model){
        model.addAttribute("person", new Person());
        return "addusers";
    }

    @GetMapping("/saveusers")
    String saveUsers(Person user1){
        System.out.println(user1.getName());
        personRepository.save(user1);
        return "boards";
    }

}
