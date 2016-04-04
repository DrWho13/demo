package demo.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CatalogueServiceImplementation implements CatalogueService {
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogueServiceImplementation.class);

	@Override
	//public String getCatalogueBasedOnLocation(String location) {
	public List<String> getCatalogueBasedOnLocation(String location) {
		logger.info("Entered method getCatalogueBasedOnLocation with parameter: " + location);
		//TODO: wire in myBatis or hibernate to hit hsqldb for data; add dummy data scripts to pre-populate the db
		//System.out.println("inside catalogue service, with location: " + location);
		if (location.equalsIgnoreCase("london")) {
			List<String> londonChoices = new ArrayList<String>();
			londonChoices.add("ArsenalTV");
			londonChoices.add("ChelseaTV");
			londonChoices.add("SkyNews");
			londonChoices.add("SkySportsNews");
			londonChoices.add("london"); //TODO: adding this temporary for easy identification of, remove and redesign later
			logger.info("Returning from getCatalogueBasedOnLocation method with list of size: " + londonChoices.size());
			return londonChoices;
		} else if (location.equalsIgnoreCase("liverpool")) {
			List<String> liverpoolChoices = new ArrayList<String>();
			liverpoolChoices.add("LiverpoolTV");
			liverpoolChoices.add("SkyNews");
			liverpoolChoices.add("SkySportsNews");
			liverpoolChoices.add("liverpool"); //TODO: adding this temporary for easy identification of, remove and redesign later
			logger.info("Returning from getCatalogueBasedOnLocation method with list of size: " + liverpoolChoices.size());
			return liverpoolChoices;
		}
		logger.info("Returning from getCatalogueBasedOnLocation method with list of size: 0");
		return new ArrayList<String>(); // change this to throwing an exception, add logging
	}	
}