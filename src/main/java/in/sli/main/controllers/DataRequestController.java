package in.sli.main.controllers;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.sli.main.beans.Certificate;
import in.sli.main.beans.Education;
import in.sli.main.beans.Experience;
import in.sli.main.beans.ProfileData;
import in.sli.main.beans.Project;
import in.sli.main.beans.ResumeData;
import in.sli.main.beans.Skill;
import in.sli.main.services.CertificateService;
import in.sli.main.services.EducationService;
import in.sli.main.services.ExperienceService;
import in.sli.main.services.ProfileDataService;
import in.sli.main.services.ProjectService;
import in.sli.main.services.ResumeDataService;
import in.sli.main.services.SkillService;

@RestController
@CrossOrigin(origins="*")
public class DataRequestController {
	@Autowired
	private EducationService es;
	@Autowired
	private ProjectService ps;
	@Autowired
	private ExperienceService exs;
	@Autowired
	private SkillService ss;
	@Autowired
	private ResumeDataService rds;
	@Autowired
	private ProfileDataService pds;
	@Autowired
	private CertificateService cr;
	
	@GetMapping("/getEducation")
	public List<Education> getEducation() {
		System.out.println("Education Data Requested");
		List<Education> eduList= es.getEducation();
		if(eduList!=null) {
			return eduList;
		}
		else {
			return Collections.emptyList();
		} 
	}
	
	@GetMapping("/getInstituteLogo/{fileName}")
	public ResponseEntity<Resource> institutionLogoRequest(@PathVariable String fileName) throws IOException{
		Path filePath=Paths.get("uploads/logos/").resolve(fileName).normalize();
		Resource resource=new UrlResource(filePath.toUri());
		if(!resource.exists()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(resource);
	}
	
	@GetMapping("/educationDocuments/{fileName}")
	public ResponseEntity<Resource> getEducationDocuments(@PathVariable String fileName) throws IOException{
		System.out.println("documents controller called");
		if(fileName.contains("..")) {
			System.out.println("first if condition");
			return ResponseEntity.badRequest().build();
		}
		
		Path filePath=Paths.get("uploads/documents/").resolve(fileName).normalize();
		System.out.println(filePath.toString());
		Resource resource=new UrlResource(filePath.toUri());
		if(!resource.exists()) {
			System.out.println("second if confition");
			return ResponseEntity.notFound().build();
		}
		System.out.println("controller returned the document link");
		System.out.println(resource.toString());
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+fileName+"\"").body(resource);
	}
	
	@GetMapping("/getProjects")
	public List<Project> getProject(){
		System.out.println("Project Data Requested");
		List<Project> proList=ps.getProjects();
		for(Project prj: proList) {
			System.out.println(prj.getId());
			System.out.println(prj.getProjectTitle());
		}
		if(proList!=null) {
			return proList;
		}
		else {
			return Collections.emptyList();
		}
	}
	
	@GetMapping("/getExperience")
	public List<Experience> getExperience(){
		System.out.println("Experience Data Requested");
		List<Experience> expList= exs.getExperience();
		if(expList!=null) {
			return expList;
		}else {
			return Collections.emptyList();
		}
	}
	
	
	@GetMapping("/getSkills")
	public List<Skill> getSkills() {
		List<Skill> listSkill=ss.getSkills();
		if(listSkill!=null) {
			return listSkill;
		}
		else {
			return Collections.emptyList();
		}
	} 
	
	@GetMapping("/getResume")
	public List<ResumeData> getResume(){
		List<ResumeData> rdl=rds.getResume();
//		return rdl;
		if(rdl!=null) {
			return rdl;
		}
		else {
			return Collections.emptyList();
		}
	}
	
	@GetMapping("/getProfiles")
	public List<ProfileData> getProfiles(){
		List<ProfileData> pdl=pds.getProfiles();
		if(pdl!=null) {
			return pdl;
		}else {
			return Collections.emptyList();
		}
	}
	
	@GetMapping("/getProfile")
	public ProfileData getProfile() {
		return pds.getTopProfile();
	}
	
	@GetMapping("/getProfileImage/{ImagePath}")
	public ResponseEntity<Resource> getProfileImage(@PathVariable String ImagePath)throws IOException{
		System.out.println("Profile Image Request Controller called");
		Path ImgPath=Paths.get("uploads/images/").resolve(ImagePath).normalize();
		Resource resourcee=new UrlResource(ImgPath.toUri());
		if(!resourcee.exists()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(resourcee);
	}
	
	@GetMapping("/getProjectsCount")
	public long getProjectCount() {
		return ps.getProjectCount();
	}
	
	
	@GetMapping("/getTotalExperience")
	public long getTotalExperience() {
		List<Experience> exlist=exs.getExperience();
		long totalMonths=0;
		for(Experience exp: exlist) {
			totalMonths=totalMonths+(ChronoUnit.MONTHS.between(exp.getStartDate(), exp.getEndDate()));	
		}
		return totalMonths/12;
	}
	
	@GetMapping("/getCertificates")
	public List<Certificate> getCertificates(){
		List<Certificate> certlist=cr.getAllCertificates();
		if(certlist!=null) {
			return certlist;
		}else {
			return Collections.emptyList();
		}
	}
	
}
