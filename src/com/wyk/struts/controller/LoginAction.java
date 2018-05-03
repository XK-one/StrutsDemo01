package com.wyk.struts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wyk.struts.entity.LoginActionForm;
import com.wyk.struts.help.PasswordErrorException;
import com.wyk.struts.help.UserNotFoundException;
import com.wyk.struts.manager.UserManager;
import com.wyk.struts.manager.impl.UserManagerImpl;

public class LoginAction extends Action{

	 @Override  
     public ActionForward execute(ActionMapping mapping,ActionForm form,  
                   HttpServletRequest request, HttpServletResponse response)  
                   throws Exception {  
  
  
            LoginActionForm laf = (LoginActionForm)form;  
            String username = laf.getUsername();  
            String password = laf.getPassword();  
              
            UserManager userManager = new UserManagerImpl();  
            //传递用户名和密码  
            try  
            {  
                   userManager.login(username, password);  
                   request.setAttribute("username", username);  
                   return mapping.findForward("success");  
            }catch(UserNotFoundException e)  
            {  
                   e.printStackTrace();  
                   request.setAttribute("msg","用户不能找到,用户名称=[" +username +"+]");  
            }catch(PasswordErrorException e)  
            {  
                   e.printStackTrace();  
                   request.setAttribute("msg","密码错误");  
            }  
              
            return mapping.findForward("error");  
     }  
}
