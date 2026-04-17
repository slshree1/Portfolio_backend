package in.sli.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sli.main.beans.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}
