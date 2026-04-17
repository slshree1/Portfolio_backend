package in.sli.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sli.main.beans.Project;
import in.sli.main.repository.ProjectRepository;
@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectRepository pr;
	@Override
	public Project addProject(Project project) {
		// TODO Auto-generated method stub
		try {
			return pr.save(project);			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		try {
			return pr.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean deleteProject(int id) {
		// TODO Auto-generated method stub
//		return false;
		try {
			pr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public long getProjectCount() {
		// TODO Auto-generated method stub
//		return 0;
		return pr.count();
	}
	
	
}
