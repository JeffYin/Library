package cgc.library.webapp.controller;

// Start of user code for import
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cgc.library.model.Publisher;
import cgc.library.service.PublisherManager;
import flexjson.JSONSerializer;


// End of user code for import

/**
 * Simple class to deal with collection of data
 */
@Controller
@RequestMapping("/publishers")
public class PublisherController {
   private transient final Log log = LogFactory.getLog(PublisherController.class);
   private  PublisherManager publisherManager = null;
   
   @Autowired
   public void setPublisherManager(PublisherManager publisherManager) {
     this.publisherManager = publisherManager;
   }
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "query") String name, HttpServletResponse response) throws Exception {
		//TODO: search publisher by name.
		if (StringUtils.isNotBlank(name)) {
			ajaxFindPubsherByName(name, response); 
			return null; 
		} else {
           return new ModelAndView().addObject(publisherManager.getAll());
		}
    }
    
	
	private void ajaxFindPubsherByName(String name, HttpServletResponse response) {
		String publisherName = String.format("%%%s%%", name);  
		Map<String, Object> queryParams = new HashMap<String, Object>(1);
		queryParams.put("name", publisherName); 
		List<Publisher>publisherList = publisherManager.findByNamedQuery("findPublisherByName", queryParams);
		
		JSONSerializer serializer = new JSONSerializer().include("name").exclude("*"); 
		String feedback = serializer.serialize(publisherList);
		
		log.debug(String.format("find the publishers:%s", feedback)); 
		
		try {	
			response.getWriter().print(feedback);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	


}
