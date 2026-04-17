package in.sli.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sli.main.beans.Skill;

public interface AddSkillRepository extends JpaRepository<Skill, Integer>{
	
}
