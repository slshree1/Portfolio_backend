package in.sli.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sli.main.beans.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
