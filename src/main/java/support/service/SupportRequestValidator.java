package support.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.EmailValidator;

import support.misc.SupportGlobals;

public class SupportRequestValidator implements Validator, SupportGlobals {
    protected final Log logger = LogFactory.getLog(getClass());

    public boolean supports(Class clazz) {
        return SupportRequest.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        SupportRequest form = (SupportRequest) obj;
        if (form == null) {
            errors.rejectValue(FIELDNAME_NAME, "error.not-specified", null, "Form imcomplete.");
        }
        else {
            logger.info("Validating with " + form + ": " + form.getName());
            if (form.getName().trim().length() < 1) {
                errors.rejectValue(FIELDNAME_NAME, "error.name-empty",
                    null, "Name field empty.");
            }
            else {
	            if (form.getName().trim().length() > MAX_NAME_CHARS) {
	                errors.rejectValue(FIELDNAME_NAME, "error.name-too-long",
	                    new Object[] {new Integer(MAX_NAME_CHARS)}, "Too many characters in name.");
	            }
	            if (form.getEmail().trim().length() < 1) {
	                errors.rejectValue(FIELDNAME_EMAIL, "error.email-empty",
	                    null, "Name field empty.");
	            }
            }
            if (form.getEmail().trim().length() > MAX_EMAIL_CHARS) {
                errors.rejectValue(FIELDNAME_EMAIL, "error.email-too-long",
                    new Object[] {new Integer(MAX_EMAIL_CHARS)}, "Too many characters in email.");
            }
            EmailValidator emailValidator = EmailValidator.getInstance();
            if (!emailValidator.isValid(form.getEmail().trim())) {
                errors.rejectValue(FIELDNAME_EMAIL, "error.email-invalid",
                        null, "Invalid email.");
            }
            if (form.getOrderNumber().trim().length() < 1) {
                errors.rejectValue(FIELDNAME_ORDERNUMBER, "error.ordernumber-empty",
                    null, "Order Number field empty.");
            }
            else if (form.getOrderNumber().trim().length() > MAX_ORDERNUMBER_CHARS){
                errors.rejectValue(FIELDNAME_ORDERNUMBER, "error.ordernum-too-long",
	                    new Object[] {new Integer(MAX_ORDERNUMBER_CHARS)}, "Too many characters in Order Number.");
            }
            else {
	            Pattern p = Pattern.compile("^\\d+-[a-zA-Z]+$");
	            Matcher m = p.matcher(form.getOrderNumber().trim());
	            if (!m.find()) {
	                errors.rejectValue(FIELDNAME_ORDERNUMBER, "error.ordernumber-invalid",
	                        null, "Invalid Order Number.");
	            }
            }
            if (form.getIssueDescription().trim().length() < 1) {
                errors.rejectValue(FIELDNAME_ISSUEDESC, "error.issuedescription-empty",
                    null, "Issue Description field empty.");
            }
            else if (form.getIssueDescription().trim().length() > MAX_ISSUEDESC_CHARS) {
                errors.rejectValue(FIELDNAME_ISSUEDESC, "error.issuedescription-too-long",
                		new Object[] {new Integer(MAX_ISSUEDESC_CHARS)}, "Issue Description too long.");
            }
           
            
        }
    }


}