package in.sli.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sli.main.beans.LoginRequest;
import java.util.Optional;


public interface LoginRepository extends JpaRepository<LoginRequest, Integer>{
	Optional<LoginRequest> findByEmail(String email);
}
