package demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import demo.exceptions.CustomerLocationException;
import demo.model.UserChoices;
import demo.services.CatalogueService;
import demo.services.CustomerLocationService;
 
@Controller
public class Home {
	
	private static final Logger logger = LoggerFactory.getLogger(Home.class); //TODO: throw away all this logging in code and add logging via aspects
	//TODO: change the naming and packaging, split this huge thing into independent services
	
	@Autowired
	CustomerLocationService customerLocationService;
	@Autowired
	CatalogueService catalogueService;
	private String customerId;
	
	@ModelAttribute("userChoices")
	public UserChoices createUserChoices() {
		return new UserChoices();
	}
	
	@RequestMapping("/")
	public String index() {
		logger.info("Returning the main page");
		return "index";
	}
	
	/*@RequestMapping(value = "/getLocation", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public String getLocation() {
		return "Glasgow";
	}*/
	
	//TODO: add exception handler that redirect to an error page with proper message
	
	@RequestMapping(value = "/getLocation", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String location(@RequestParam(value="customerID", required=false) String customerID) {
		logger.info("Entered the location method with parameter: " + customerID);
		//System.out.println(customerID);
		this.customerId = customerID;
		//return "Glasgow";
		String tempLocation = "";
		try {
			tempLocation = customerLocationService.getCustomerLocationBasedOnCookieId(customerID);
		} catch (CustomerLocationException e) {
			// log that an exception was thrown, return some meaningful message
			logger.error("Exception from getCustomerLocationBasedOnCookieId method - no match between customer ID: " + customerID + " and location found");
		}
		logger.info("Returning from location method with value: " + tempLocation);
		return tempLocation;
	}
	
	@RequestMapping(value = "/getCatalog", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String catalog(@RequestParam(value="location", required=false) String location) {
		logger.info("Entered the catalog method with parameter: " + location);
		//System.out.println("Received location: " + location);
		this.createUserChoices();
		List<String> listOfChoicesForGivenLocation = catalogueService.getCatalogueBasedOnLocation(location);
		String choicesInString = "";
		for (String s : listOfChoicesForGivenLocation) {
			choicesInString += s + ",";
		}
		logger.info("Returning from catalog method with value: " + choicesInString);
		return choicesInString;
		//return catalogueService.getCatalogueBasedOnLocation(location);
	}
	
	@RequestMapping(value = "/confirmation", method = RequestMethod.POST)
	public String confirmation(@ModelAttribute UserChoices userChoices, Model model) {
		logger.info("Entered the confirmation method with parameter: " + userChoices.toString());
		userChoices.setCustomerId(this.customerId.substring(this.customerId.indexOf("=") + 1)); // change this so that it's set in the form somehow
		// then agian, should JS handle that on the client side? maybe add encryption for the cookie ID
		model.addAttribute("userChoices", userChoices);
		//System.out.println("arsenalTv on userChoices object: " + userChoices.isArsenalTv());
		//System.out.println("user id: " + userChoices.getCustomerId());
		logger.info("Returning from confirmation method with result page");
		return "result";
	}
}