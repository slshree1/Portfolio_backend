package in.sli.main.services;

import in.sli.main.beans.LoginRequest;

public interface LoginServices {
	public LoginRequest findByEmailLoginRequest(String email);
	public LoginRequest updatePass(LoginRequest logreq);
}
