package com.example.TradeRec.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.example.TradeRec.dto.CustomerResponseDto;
import com.example.TradeRec.dto.LeadDto;
import com.example.TradeRec.entity.Product;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	private MyController myController;

	@GetMapping("/showForm")
	public String showForm(Model model) {
		LeadDto leadDto = new LeadDto();
		leadDto.setCustomerId("Customer Id");
		model.addAttribute("leadDto", leadDto);
		return "MyPage";
	}
	
	@GetMapping("/leadSaved")
	public ModelAndView leadSaved(@ModelAttribute("message") String message) {
		ModelAndView view = new  ModelAndView();
		view.setViewName("LeadResponse");
		view.addObject("status", "Lead saved successfully with Customer Id: "+message);
		
		return view;
	}
	
	@GetMapping("/leadTable")
	public String getLeadsTable(Model theModel) {
		theModel.addAttribute("leadList",myController.getLeadList());
		return "LeadTable";
	}
	
	@PostMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("product") Product theProduct,
							BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "LoginForm";
		}
		
		return "LoginForm";
	}
	
	@GetMapping("/showLoginForm")
	public String getLoginForm(Model model) {
		model.addAttribute("product", new Product());
		return "LoginForm";
	}
	
	@GetMapping("/customerUpdate")
	public String getCustomerUpdateForm(Model model) {
	  
	  return "UpdateCustomer";
	}
	
	@GetMapping("/showAddCustomer")
	public String addCustomer(Model model) {
	  
	  return "AddCustomer";
	}

}
