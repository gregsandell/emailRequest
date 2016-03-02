package support.misc;

public interface SupportGlobals {
	public static final int MAX_NAME_CHARS = 100;
	public static final int MAX_EMAIL_CHARS = 100;
	public static final int MAX_ORDERNUMBER_CHARS = 50;
	public static final int MAX_ISSUEDESC_CHARS = 10000;
	
	/* These constants help keep some consistency between JSPs and servlets.  Of course, if the
	 * SupportRequest bean changes, these would have to change too.  Nothing's perfect ;-)
	 */
	public static final String FIELDNAME_NAME = "name";
	public static final String FIELDNAME_EMAIL = "email";
	public static final String FIELDNAME_ORDERNUMBER = "orderNumber";
	public static final String FIELDNAME_ISSUEDESC = "issueDescription";
	
	public static final String JSP_HOMEPAGE = "homepage";
}
