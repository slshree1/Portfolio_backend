package in.sli.main.services;

import java.util.List;

import in.sli.main.beans.Project;

public interface ProjectService {
	Project addProject(Project project);
	List<Project> getProjects();
	boolean deleteProject(int id);
	long getProjectCount();
}
