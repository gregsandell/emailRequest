package support.control;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import support.misc.SupportGlobals;



public class StartPageController implements Controller, SupportGlobals {

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	logger.info("In handleRequest()");
    	Map<String, Object> myModel = new HashMap<String, Object>();
    	String mesg = request.getParameter("thankyou") == null ? "" : "Your request has been submitted.";
    	myModel.put("mesg", mesg);
    	return new ModelAndView(JSP_HOMEPAGE, "model", myModel);
    }
}
