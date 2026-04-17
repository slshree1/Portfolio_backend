package in.sli.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.sli.main.beans.Certificate;
import in.sli.main.beans.Education;
import in.sli.main.beans.Experience;
import in.sli.main.beans.LoginRequest;
import in.sli.main.beans.LoginResponse;
import in.sli.main.beans.ProfileData;
import in.sli.main.beans.Project;
import in.sli.main.beans.ResumeData;
import in.sli.main.beans.Skill;
import in.sli.main.services.CertificateService;
import in.sli.main.services.EducationService;
import in.sli.main.services.EmailService;
import in.sli.main.services.ExperienceService;
import in.sli.main.services.LoginServices;
import in.sli.main.services.ProfileDataService;
import in.sli.main.services.ProjectService;
import in.sli.main.services.ResumeDataService;
import in.sli.main.services.SkillService;

@RestController
@CrossOrigin(origins = "*")
public class MyController {
	@Autowired
	private LoginServices ls;
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
	@Autowired
	private EmailService ems;
	
	
	@PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
		LoginRequest lgrq=ls.findByEmailLoginRequest(request.getEmail());
		if(lgrq!=null) {
			if(lgrq.getPass().equals(request.getPass())) {
				return ResponseEntity.ok(new LoginResponse("success", "Login OK"));
			}
			else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				        .body(new LoginResponse("error", "Invalid Credentials"));
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
			        .body(new LoginResponse("error", "User Not Available"));		
		}
        
    }
	
	@PostMapping("/updatePassword")
	public String updatePassword(@RequestParam("oldPassword") String oldPass,
									@RequestParam("newPassword") String newPass) {
		LoginRequest lr=ls.findByEmailLoginRequest("shreyashlimbikai123@gmail.com");
		if(oldPass.equals(lr.getPass())) {
			try {
				lr.setPass(newPass);
				LoginRequest logreq=ls.updatePass(lr);
				if(logreq!=null) {
					return "Password Updated successfully";
				}
				else {
					return "Error occured while updating pass";
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				return "Error occured while updating password";
			}
		}else {
			return "Old password did not match";
		}
	}
	
	@PostMapping("/saveSkill")
	public boolean addSkill(@RequestBody Skill skill) {
//		System.out.println(skill.getProjectsUsing());
		Skill SavedSkill=ss.addSkill(skill);
		if(SavedSkill==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@PostMapping(value="/saveExperience",
				consumes=MediaType.MULTIPART_FORM_DATA_VALUE
			)
	public boolean addExperience(@RequestPart("experience") Experience experience,
									@RequestPart(value="companyLogo", required=false) MultipartFile companyLogo,
									@RequestPart(value="documents", required=false) MultipartFile documents
			) {
		
		if(experience == null) {
			return false;
		}
		else {
			try {
				Experience e= es.addExperience(experience, companyLogo, documents);
				if(e!=null) {
					return true;					
				}
				else {
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	
	@PostMapping("/saveProject")
	public boolean addProject(@RequestBody Project project) {
		if(project != null) {
			Project prj= ps.addProject(project);
			if(prj!=null) {
				return true;				
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	@PostMapping(value="/saveEducation", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean addEducation(@RequestPart("education") Education education,
								@RequestPart(value="institutionLogo", required=false) MultipartFile institutionLogo,
								@RequestPart(value="certificates", required=false) MultipartFile certificates) {
		
		if(education!=null) {
			try {
				Education ed=eds.addEducation(education, institutionLogo, certificates);				
				if(ed!=null) {
					return true;
				}
				else {
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}else {
			return false;
		}
	}
	
	@PostMapping(value="/updateResume", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean updateResume(@RequestPart("resumeData") ResumeData resumeData,
								@RequestPart(value="resume", required=false) MultipartFile resume) {
		if(resumeData!=null && resume!=null) {
			try {
				ResumeData rd= rds.updateResume(resumeData, resume);
				if(rd!=null) {
					return true;
				}
				else {
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		else {
			return false;			
		}
		
	}
	
	
	@PostMapping(value="/updateProfileData", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean updateProfilePicture(@RequestPart("profileData") ProfileData pd, @RequestPart(value="profilePicture", required=false) MultipartFile profilePicture) {
		
		if(pd!=null && profilePicture!=null) {
			try {
				ProfileData profileData=pds.addProfileData(pd, profilePicture);
				if(profileData!=null) {
					return true;
				}
				else {
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	
	@PostMapping(value="/saveCertificate", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public boolean addCertificate(@RequestPart("certificateData") Certificate cert,
									@RequestPart(value="certificate", required=false) MultipartFile certificate) {
		if(cert!=null && cert!=null) {
			try {
				Certificate testCert= cs.addCertificate(cert, certificate);
				if(testCert != null) {
					return true;
				}
				else {
					return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	
	@GetMapping("/forgotPassword")
	public boolean forgotPassword() {
		System.out.println("forgot password controller called");
		return ems.sendForgotPassEmail();
	}
	
	
}
