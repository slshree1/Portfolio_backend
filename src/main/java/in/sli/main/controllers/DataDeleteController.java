package in.sli.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.sli.main.services.CertificateService;
import in.sli.main.services.EducationService;
import in.sli.main.services.ExperienceService;
import in.sli.main.services.ProfileDataService;
import in.sli.main.services.ProjectService;
import in.sli.main.services.ResumeDataService;
import in.sli.main.services.SkillService;

@RestController
@CrossOrigin(origins="*")
public class DataDeleteController {
	@Autowired
	private SkillService ss;
	@Autowired
	private ExperienceService es;
	@Autowired
	private ProjectService ps;
	@Autowired
	private EducationService eds;
	@Autowired
	private ResumeDataService rds;
	@Autowired
	private ProfileDataService pds;
	@Autowired
	private CertificateService cs;
	
	@DeleteMapping("/deleteSkill/{id}")
	public boolean deleteSkill(@PathVariable int id) {
		return ss.deleteSkill(id);
	}
	
	@DeleteMapping("/deleteExperience/{id}")
	public boolean deleteExperience(@PathVariable int id) {
		return es.deleteExperience(id);
	}
	
	@DeleteMapping("/deleteProject/{id}")
	public boolean deleteProject(@PathVariable int id) {
		return ps.deleteProject(id);
	}
	
	@DeleteMapping("/deleteEducation/{id}")
	public boolean deleteEducation(@PathVariable int id) {
		return eds.deleteEducation(id);
	}
	
	@DeleteMapping("/deleteResume/{id}")
	public boolean deleteResume(@PathVariable int id) {
		return rds.deleteResume(id);
	}
	
	@DeleteMapping("/deleteProfileData/{id}")
	public boolean deleteProfileData(@PathVariable int id) {
		return pds.deleteProfile(id);
	}
	
	@DeleteMapping("/deleteCertificate/{id}")
	public boolean deleteCertificate(@PathVariable int id) {
		return cs.deleteCertificate(id);
	}
}
