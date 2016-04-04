package demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import demo.exceptions.CustomerLocationException;

@Service
public class CustomerLocationServiceImplementation implements CustomerLocationService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerLocationServiceImplementation.class);

	@Override
	public String getCustomerLocationBasedOnCookieId(String cookieId)  {
		logger.info("Entered getCustomerLocationBasedOnCookieId method with parameter: " + cookieId);
		//TODO: this can later hit a db or another service  with the id to get a location
		String cookieIdValue = cookieId.substring(cookieId.indexOf("=") + 1);
		//String cookieIdValue = "456";
		System.out.println(cookieIdValue);
		if (cookieIdValue.equalsIgnoreCase("123")) {
			//System.out.println("inside london case");
			logger.info("Returning from getCustomerLocationBasedOnCookieId with value: London");
			return "London";
		} else if (cookieIdValue.equalsIgnoreCase("456")) {
			//System.out.println("inside liverpool case");
			logger.info("Returning from getCustomerLocationBasedOnCookieId with value: Liverpool");
			return "Liverpool";
		} else {
			//System.out.println("inside exception case");
			logger.error("Error - returning from getCustomerLocationBasedOnCookieId with an exception");
			throw new CustomerLocationException();
		}
		
	}
}