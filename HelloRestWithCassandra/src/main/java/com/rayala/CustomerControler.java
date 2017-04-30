package com.rayala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class CustomerControler {
	
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping("/hello")
	public String Hello(){
     
		String output = this.repository.findByFirstName("Rajeev").toString();
		return(output);
	}
	/*@RequestMapping("/customer")
    public String greetingForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }*/

    /*@PostMapping("/customer")
    public String greetingSubmit(@ModelAttribute Customer customer) {
        return "result";
    }*/
}
