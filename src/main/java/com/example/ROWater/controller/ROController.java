package com.example.ROWater.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ROWater.entity.Engineer;
import com.example.ROWater.entity.Master;
import com.example.ROWater.entity.ServiceRequest;
import com.example.ROWater.service.ROService;

@Controller
public class ROController {

	@Autowired
	ROService service;
	 @RequestMapping(value = "/",method = RequestMethod.GET)
	public String welcomePage() {
		service.prepopulate();
		
		return "login";
	}
	 
	 @RequestMapping(value = "/" , method = RequestMethod.POST)
	 public String login(@RequestParam String username,@RequestParam String password,Model model)
	 {
		 System.out.println(username+" "+password);
		 if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin"))
		 return "redirect:/customer";
		 else {
			 model.addAttribute("error", "Invalid Credentials");
			 return "login";
		 }
	 }
	 
	 @RequestMapping(value="/customer")
	 public String getCustomer(HttpSession model) {
		 List<Master> customer = service.getCustomer();
		 System.out.println(customer);
		
		 model.setAttribute("customer", customer);
		 return "customer";
	 }
	 
	 @GetMapping("/customer/{consumerId}")
	 public String getCustomer(@PathVariable String consumerId,HttpSession session) {
		 Master byCustomerId = service.getByCustomerId(Integer.parseInt(consumerId));
		 session.setAttribute("id", consumerId);
		 session.setAttribute("cus", byCustomerId);
		 List<Engineer> engineer = service.getEngineer();
		 session.setAttribute("engineer", engineer);
		 return "desc";
	 }
	 
	 @GetMapping("/engg")
	 public String saveCustomerReq(@RequestParam String description,HttpSession session,Model model) {
//		 Master customer = (Master) session.getAttribute("cus");
		 session.setAttribute("description", description);
		 System.err.println(description);
		 //System.err.println(customer);
		 //service.saveServiceReuest(customer,description,engineer);
	//	 model.addAttribute("person", engineer);
		 return "engg";
	 }
	 
	 @GetMapping("/save")
	 public String save(@RequestParam String engineer,HttpSession session,Model model) {
		 Master customer = (Master) session.getAttribute("cus");
		 String description=(String) session.getAttribute("description");
		 System.err.println(description+":"+engineer);
		 System.err.println(customer);
		 ServiceRequest saveServiceReuest = service.saveServiceReuest(customer,description,engineer);
		 model.addAttribute("person", engineer);
		 model.addAttribute("obj", saveServiceReuest);
		 return "req";
	 }
	 
	 @RequestMapping(value="/engineer")
	 public String getEngineer(HttpSession session) {
		 
		 List<Engineer> engineer = service.getEngineer();
		 session.setAttribute("eng", engineer);
		 return "engineer";
	 }
	 
	 @RequestMapping("/search")
	 public String searchEngg(@RequestParam String search,HttpSession model) {
//		 System.err.println(search);
		 Master byCustomerId = service.getByCustomerId(Integer.parseInt(search));
		 System.err.println(byCustomerId);
		 List<Master> obj=new ArrayList<Master>();
		 obj.add(byCustomerId);
		 model.setAttribute("customer", obj);
		 return "customer";
	 }
	 
	 @RequestMapping("/service")
	 public String getService(HttpSession session) {
		 List<ServiceRequest> services = service.getServices();
		 System.err.println(services);
		 session.setAttribute("service", services);
		 return "service";
	 }
}
