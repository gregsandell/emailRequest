package support.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SupportRequest {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private String name;
    private String email;
    private String orderNumber;
    private String issueDescription;

    public void setName(String name) {
        this.name = name;
        logger.info("Name set to " + name);
    }

    public String getName() {
        return name;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
        logger.info("Email set to " + email);
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
        logger.info("OrderNumber set to " + orderNumber);
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
    

}