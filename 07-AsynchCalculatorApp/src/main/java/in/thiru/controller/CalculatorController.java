package in.thiru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

	@GetMapping("/index")
	public String showForm() {

		return "index";
	}

	@PostMapping("/add")
	public String adding(Model model,@RequestParam("num1") Integer num1,@RequestParam("num2") Integer num2)
	{
		
		Integer result=num1+num2;
		
		model.addAttribute("result",result);
		
		return "index";
	}
	
	
	
}
