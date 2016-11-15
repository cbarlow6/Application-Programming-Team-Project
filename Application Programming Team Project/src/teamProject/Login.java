package teamProject;

public class Login {
	String userName;
	String password;
	String question;

	Login(){
	
	}
	
	Login(String userName, String password, String question){
		this.userName = userName;
		this.password = password;
		this.question = question;
		
	}

	public String getPassword(){
		return password;
	}
	
	public String getUserName(){
		return userName;	
	}

	public String getQuestion(){
		return question;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public void setQuestion(String question){
		this.question = question;
	}
}	