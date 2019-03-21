package com.chillax.dto;





public class Manager {
    private String wid;

    private String username;

    private String usertime;
    
    private String institute;
    
    private String usersex;
    
    public  Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String userid, String username, String usertime, String userinstitute,String usersex) {
		super();
		this.wid=userid;
		this.username=username;
		this.usertime=usertime;
		this.institute=userinstitute;
		this.usersex=usersex;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertime() {
		return usertime;
	}

	public void setUsertime(String usertime) {
		this.usertime = usertime;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
}

   