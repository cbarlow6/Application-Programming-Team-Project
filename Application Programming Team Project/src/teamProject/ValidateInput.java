package teamProject;

import java.util.regex.*;

public class ValidateInput {

	public static boolean isSSNValid(String ssn){  
		boolean isValid = false;  
		 /*SSN format xxx-xx-xxxx, xxxxxxxxx, xxx-xxxxxx; xxxxx-xxxx: 
		         ^\\d{3}: Starts with three numeric digits. 
		    [- ]?: Followed by an optional "-" 
		    \\d{2}: Two numeric digits after the optional "-" 
		    [- ]?: May contain an optional second "-" character. 
		    \\d{4}: ends with four numeric digits. 
		 
		        Examples: 879-89-8989; 869878789 etc. 
		*/  
		  
		//Initialize reg ex for SSN.   
		String expression = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";  
		CharSequence inputStr = ssn;  
		Pattern pattern = Pattern.compile(expression);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
		}  
}
