package com.ehome.responses;

import com.ehome.payload.LoginUserDto;

public class LoginResponse {
    private String token;

    private long expiresIn;
    
    private Integer userid;
    
    private String username;
    

	public Integer getUserid() {
		return userid;
	}

	public LoginResponse setUserid(Integer userid) {
		this.userid = userid;
		return this;
	}

	public String getToken() {
        return token;
    }

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
    
    

	public String getUsername() {
		return username;
	}

	public LoginResponse setUsername(String username) {
		this.username = username;
		return this;
	}

	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", expiresIn=" + expiresIn + ", userid=" + userid + ", username="
				+ username + "]";
	}

	

    
}