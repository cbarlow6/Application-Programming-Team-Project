package teamProject;

public abstract class Admin {

	String admin_userName;
	String user_userName;
	int privilegeLevel;
	
	Admin(){
		
	}
	
	Admin(String admin_userName, String user_userName, int privilegeLevel){
		this.admin_userName = admin_userName;
		this.user_userName = user_userName;
		this.privilegeLevel = privilegeLevel;
	}

	/**
	 * @return the admin_userName
	 */
	public String getAdmin_userName() {
		return admin_userName;
	}

	/**
	 * @param admin_userName the admin_userName to set
	 */
	public void setAdmin_userName(String admin_userName) {
		this.admin_userName = admin_userName;
	}

	/**
	 * @return the user_userName
	 */
	public String getUser_userName() {
		return user_userName;
	}

	/**
	 * @param user_userName the user_userName to set
	 */
	public void setUser_userName(String user_userName) {
		this.user_userName = user_userName;
	}

	/**
	 * @return the privilegeLevel
	 */
	public int getPrivilegeLevel() {
		return privilegeLevel;
	}

	/**
	 * @param privilegeLevel the privilegeLevel to set
	 */
	public void setPrivilegeLevel(int privilegeLevel) {
		this.privilegeLevel = privilegeLevel;
	}

	
	
	
}
