package com.example.springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    
    // controller to show initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    
    // controller to process form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
    
    // controller to read form data
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
    	// read request parameter from HTML form
    	String theName = request.getParameter("studentName");
    	
    	// convert data to all caps
    	theName = theName.toUpperCase();
    	
    	// create message
    	String result = "Yo " + theName;
    	
    	// add message to model
    	model.addAttribute("message", result);
    	
    	return "helloworld";
    }
    
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
    	// convert data to all caps
    	theName = theName.toUpperCase();
    	
    	// create message
    	String result = "Hey there, " + theName;
    	
    	// add message to model
    	model.addAttribute("message", result);
    	
    	return "helloworld";
    }
}
