package in.sli.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sli.main.beans.ResumeData;

public interface ResumeDataRepository extends JpaRepository<ResumeData, Integer>{
	ResumeData findTopByOrderByIdDesc();
}
