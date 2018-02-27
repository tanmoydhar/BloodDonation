package com.redrops.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;
import com.redrops.model.RequestPojo;
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
	private String show;
	private String state;
	private String contact;
	private List<UserPojo> doners;
	private List<RequestPojo> noticeBoard;
	private String bloodRequest;
	
	
	
	
	
	public List<RequestPojo> getNoticeBoard() {
		return noticeBoard;
	}

	public void setNoticeBoard(List<RequestPojo> noticeBoard) {
		this.noticeBoard = noticeBoard;
	}

	public String getBloodRequest() {
		return bloodRequest;
	}

	public void setBloodRequest(String bloodRequest) {
		this.bloodRequest = bloodRequest;
	}

	public List<UserPojo> getDoners() {
		return doners;
	}

	public void setDoners(List<UserPojo> doners) {
		this.doners = doners;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

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
		
		System.out.println("Inside getLogin");
		
		if(getEmail().equals("Tanmoy") && getPassword().equals("password")) {
			
			sessionMap.put("email", getEmail());
			sessionMap.put("blood", "AB+");
			
			return "success";
		}
		return "error";
	}
	
	public String doLogout() {
		if(sessionMap != null) {
			System.out.println("Map found empty");
		}
		
		if (sessionMap.containsKey("email")) {
            sessionMap.remove("email");
        }
		if (sessionMap.containsKey("blood")) {
            sessionMap.remove("blood");
        }
		System.out.println("logout process completed");
		
		return "success";
	}
	
	public String doRegister(){
		System.out.println("inside register");
		
		UserPojo up=new UserPojo();
		up.setName(name);
		up.setPassword(password);
		up.setGender(gender);
		up.setEmail(email);
		up.setBlood(blood);
		up.setShow(show);
		up.setState(state);
		up.setContact(contact);
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(up);
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		
		
		return "success";
	}
	
	public String doSearchDoner() {
		//state and blood are incoming
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from UserPojo where blood=:blood and state=:state");
		query.setString("blood", blood);
		query.setString("state", state);
		doners = query.list();
		
		System.out.println(doners.size());
		for(UserPojo up: doners) {
			System.out.println(up.getName()+"  "+up.getEmail());
		}
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		return "success";
	}
	
	public String doPostRequest() {
		RequestPojo rp=new RequestPojo();
		rp.setEmail((String) sessionMap.get("email"));
		rp.setRequest(bloodRequest);
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(rp);
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		
		return "success";
	}
	
	public String doFetchRequest() {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from RequestPojo ");
		noticeBoard = query.list();
		
		System.out.println(noticeBoard.size());
		for(RequestPojo rp: noticeBoard) {
			System.out.println(rp.getEmail()+"  "+rp.getRequest());
		}
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		return "success";
	}
	
}
