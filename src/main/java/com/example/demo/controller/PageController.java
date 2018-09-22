package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String hmmGenerator(@RequestParam(value = "a", required = false, defaultValue ="0") String a, @RequestParam(value = "b", required = false, defaultValue ="0") String b, Model model) {
		int ia = Integer.parseInt(a);
		int ib = Integer.parseInt(b);
		
		int numM = 1;
		int numWord = 1;
		
		if (ia > 0)
			numM = ia;
		if (ib > 0)
			numWord = ib;
		
		String word = "h";
	    for (int i=0; i<numM;i++)
	        word += "m";
		
		String output = "";
	    for (int i=0; i<numWord;i++)
	        output += word + " ";
		
	    model.addAttribute("a", a);
	    model.addAttribute("b", b);
		model.addAttribute("output", output);
		
		return "generator";
	}
}

