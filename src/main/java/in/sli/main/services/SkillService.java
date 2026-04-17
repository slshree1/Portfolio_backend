package in.sli.main.services;

import java.util.List;

import in.sli.main.beans.Skill;

public interface SkillService {
	Skill addSkill(Skill skill);
	List<Skill> getSkills();
	boolean deleteSkill(int id);
}
