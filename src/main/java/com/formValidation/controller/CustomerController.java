package com.formValidation.controller;

import com.formValidation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {


    //Add an initbinder to trim all form fields coming to controller
    //This remove all trailing and leading spaces
//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder){
//        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//    }

    @GetMapping("/")
    public String showForm(Model theModel) {
        //
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid
                              @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult) {
        System.out.println("Lastname |" + theCustomer.getLastName() + "|   " );
        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
