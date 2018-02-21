package com.redrops.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.redrops.model.UserPojo;

public class Moderator extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
	private SessionMap<String,Object> sessionMap;
	private String name,email,gender,blood;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		// TODO Auto-generated method stub
		this.sessionMap = (SessionMap<String, Object>) sessionMap;
		
	}

	//if any other action comes without these parameters in struts validation, 
	//they will generate error saying no action found
	//check its not working
	/*public void validate() {
		if(org.apache.commons.lang.StringUtils.isEmpty(getUserId())) {
			addFieldError(getUserId(), "u cant keep user id null");
			
		}
		if(org.apache.commons.lang.StringUtils.isEmpty(getPassword())) {
			addFieldError(getPassword(), "u cant keep password null");
		}
    }
	*/
	
	public String getLogin() {
		
		//HttpSession session = ServletActionContext.getRequest().getSession(true);
		
		if(getUserId().equals("Tanmoy") && getPassword().equals("password")) {
			
			/*Map<String, Object> context = new HashMap<String, Object>();
			context.put("name", "Name of user:"+getUserId());
			context.put("blood", "Blood group: AB+");
			ActionContext.getContext().getValueStack().push(context);*/
			sessionMap.put("name", "Name of user:"+getUserId());
			sessionMap.put("blood", "Blood group: AB+");
			
			return "success";
		}
		return "error";
	}
	
	public String doLogout() {
		if(sessionMap != null) {
			System.out.println("Map found empty");
		}
		
		if (sessionMap.containsKey("name")) {
            sessionMap.remove("name");
        }
		if (sessionMap.containsKey("blood")) {
            sessionMap.remove("blood");
        }
		System.out.println("logout process completed");
		
		return "success";
	}
	
	public String doRegister(){
		UserPojo up=new UserPojo();
		up.setName(name);
		up.setPassword(password);
		up.setGender(gender);
		up.setEmail(email);
		up.setBlood(blood);
		
		
		
		return "error";
	}
	
}
