package in.sli.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sli.main.beans.Skill;
import in.sli.main.repository.AddSkillRepository;
@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	private AddSkillRepository asr; 
	@Override
	public Skill addSkill(Skill skill) {
		// TODO Auto-generated method stub
		try {
			return asr.save(skill);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Skill> getSkills() {
		// TODO Auto-generated method stub
//		return null;
		try {
			return asr.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean deleteSkill(int id) {
		// TODO Auto-generated method stub
//		return false;
		try {
			asr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
