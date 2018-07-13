package MyProj.identity.mgmt.datamodel;

public class Identity{
	protected int USER_ID;
	protected String NAME;
	protected String EMAIL_ID;
	protected String usr_name="root";
	protected String pass="root";
	public boolean valid;

	public Identity() {
    }
	    public Identity(int USER_ID) {
        this.USER_ID = USER_ID;
    }
    public Identity(int USER_ID, String NAME, String EMAIL_ID) {
        this(NAME, EMAIL_ID);
        this.USER_ID = USER_ID;
    }
     
    public Identity(String NAME, String Email_id) {
        this.NAME = NAME;
        this.EMAIL_ID = Email_id;
      }
 
    public boolean isValid() {
        return valid;
	}

    public String getUsr_name() {
		return usr_name;
	}

	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
 

    public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	    public  int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int USER_ID) {
		this.USER_ID = USER_ID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
 
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}

	public void setEMAIL_ID(String EMAIL_ID) {
		this.EMAIL_ID = EMAIL_ID;
	}
	   

}
