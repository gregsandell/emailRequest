package support.control;

import java.util.Properties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import support.service.EmailConfigBean;
import support.service.SupportRequest;

public class SupportRequestFormController extends SimpleFormController {

    protected final Log logger = LogFactory.getLog(getClass());
    public ModelAndView onSubmit(Object command)
            throws ServletException {
    	SupportRequest form = (SupportRequest)command;
        sendEmail(form);
        logger.info("returning from SupportRequestForm view to " + getSuccessView());
        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    private void sendEmail(SupportRequest form) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("emailConfig.xml");
    	EmailConfigBean emailCfg = (EmailConfigBean)context.getBean("emailCfg");   	
    	Properties props = System.getProperties();
    	props.put("mail.smtp.host", emailCfg.getSmtpHost());
    	props.put("mail.smtp.user", emailCfg.getUser());
    	props.put("mail.smtp.password", emailCfg.getPassword());
    	props.put("mail.smtp.port", "587"); 
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");

    	Session session = Session.getDefaultInstance(props, null);
    	MimeMessage message = new MimeMessage(session);
    	try {
			message.setFrom(new InternetAddress(form.getEmail()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					emailCfg.getRecipient()));
			message.setSubject("New Support Request");
			message.setText("Name: " + form.getName() + "\n" + "Email: "
					+ form.getEmail() + "\n" + "Order Number: "
					+ form.getOrderNumber() + "\n" + "Issue Description: "
					+ form.getIssueDescription() + "\n");
			Transport transport = session.getTransport("smtp");
			transport.connect(emailCfg.getSmtpHost(), emailCfg.getUser(), emailCfg.getPassword());
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			logger.error("Exception trying to send email, error is: " + e.getMessage());
		}
	
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        SupportRequest supportRequest = new SupportRequest();
        /* Uncomment the lines below to make testing a little easier  */
//        supportRequest.setName("Fred");
//        supportRequest.setEmail("fred@rock.com");
//        supportRequest.setOrderNumber("123-asdf");
//        supportRequest.setIssueDescription("The description");
        return supportRequest;
    }

}