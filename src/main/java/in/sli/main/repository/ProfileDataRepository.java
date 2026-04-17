package in.sli.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sli.main.beans.ProfileData;

public interface ProfileDataRepository extends JpaRepository<ProfileData, Integer> {
	ProfileData findTopByOrderByIdDesc();
}
