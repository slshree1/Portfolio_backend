package in.sli.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sli.main.beans.LoginRequest;
import in.sli.main.repository.LoginRepository;
@Service
public class LoginServiceImpl implements LoginServices{
	@Autowired
	private LoginRepository lr;
	
	
	@Override
	public LoginRequest findByEmailLoginRequest(String email) {
		// TODO Auto-generated method stub
		return lr.findByEmail(email).orElse(null);
	}
	
	@Override
	public LoginRequest updatePass(LoginRequest logreq) {
		// TODO Auto-generated method stub
		try {
			return lr.save(logreq);			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
//		return false;
	}
}
