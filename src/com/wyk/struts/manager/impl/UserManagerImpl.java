package com.wyk.struts.manager.impl;

import com.wyk.struts.help.PasswordErrorException;
import com.wyk.struts.help.UserNotFoundException;
import com.wyk.struts.manager.UserManager;

public class UserManagerImpl implements UserManager {

	@Override
	public void login(String userName, String pwd) {
		
	             if(!"admin".equals(userName))  
	             {  
	                    throw new UserNotFoundException();  
	             }  
	               
	               
	             if(!"admin".equals(pwd))  
	             {  
	                    throw new PasswordErrorException();  
	             }  
	      

	}

}
