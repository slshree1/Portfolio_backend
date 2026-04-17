package in.sli.main.controllers;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sli.main.beans.DocRequest;
import in.sli.main.beans.ResumeData;
import in.sli.main.beans.contact.ColabRequest;
import in.sli.main.beans.contact.GeneralMessage;
import in.sli.main.beans.contact.JobOffer;
import in.sli.main.beans.contact.MeetingRequest;
import in.sli.main.beans.contact.ProjectRequest;
import in.sli.main.beans.contact.StartupData;
import in.sli.main.repository.ResumeDataRepository;
import in.sli.main.services.EmailService;
import org.springframework.core.io.Resource;

@RestController
@CrossOrigin(origins = "*")
public class ContactController {
	@Autowired
	private EmailService ms;
	
	@Autowired
	private ResumeDataRepository rdr;
	
	@PostMapping("/sendGeneralMessage")
	public boolean generalMessage(@RequestBody GeneralMessage generalMessage) {
		String body="Name: "+generalMessage.getFullName()+"\n"
				+"Email: "+generalMessage.getEmail()+"\n"
				+"Subject: "+generalMessage.getSubject()+"\n"
				+"Message: "+generalMessage.getMessage()+"\n";
		return ms.sendEmail(generalMessage.getEmail(),"New General Message from "+generalMessage.getFullName(), body);
		
//		return true;
	}
	
	@PostMapping("/sendJobOfferMessage")
	public boolean jobOfferMessage(@RequestBody JobOffer jobOffer) {
		
		if(jobOffer!=null) {
			String body="Name: "+jobOffer.getName()+"\n"
					+"CompanyName: "+jobOffer.getCompany()+"\n"
					+"Position: "+jobOffer.getPosition()+"\n"
					+"Employment Type: "+jobOffer.getEmploymentType()+"\n"
					+"Details: "+jobOffer.getDetails()+"\n"
					+"Contact Details: "+jobOffer.getContactDetails();
			return ms.sendEmail("shreyashlimbikai123@gmail.com","New Offer from "+jobOffer.getCompany(), body);
//			return true;
		}
		else {
			return false;
		}
	}
	@PostMapping("/sendProjectRequest")
	public boolean projectRequest(@RequestBody ProjectRequest projectRequest) {
		if(projectRequest!=null) {
			String body="Name: "+projectRequest.getName()+"\n"
					+"Email: "+projectRequest.getEmail()+"\n"
					+"Project Title: "+projectRequest.getProjectTitle()+"\n"
					+"Project Type: "+projectRequest.getProjectType()+"\n"
					+"Budget: "+projectRequest.getBudget()+"\n"
					+"Timeline: "+projectRequest.getTimeline();
			
			return ms.sendEmail(projectRequest.getEmail(),"New project request received from "+projectRequest.getName(), body);
//			return true;
		}
		else {
			return false;
		}
	}
	
	@PostMapping("/sendColabRequest")
	public boolean colabRequest(@RequestBody ColabRequest colabRequest) {
		if(colabRequest!=null) {
			
			
			String body="Name: "+colabRequest.getName()+"\n"
						+"Role: "+colabRequest.getRole()+"\n"
						+"Project/Idea Description: "+colabRequest.getProjectIdeaDesc()+"\n"
						+"Required Skills: "+colabRequest.getSkills()+"\n"
						+"Contact Details: "+colabRequest.getContactDetails();
			return ms.sendEmail("shreyashlimbikai123@gmail.com","New Collaboration Request received from "+colabRequest.getName(), body);
//			return true;
		}
		else {
			return false;
		}
	}
	
	@GetMapping("/downloadResume")
	public ResponseEntity<Resource> downloadResume() throws IOException{
		 ResumeData latestResume = rdr.findTopByOrderByIdDesc();
	        if (latestResume == null) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        Path filePath = Paths.get("uploads/documents/"+latestResume.getResumePath());
	        System.out.println(filePath);
	        Resource resource;
	        try {
	            resource = new UrlResource(filePath.toUri());
	        } catch (Exception e) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        if (!resource.exists() || !resource.isReadable()) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        // Get the filename from the path
	        String filename = "Resume_Latest.pdf";
	        if (latestResume.getResumePath() != null && latestResume.getResumePath().contains("/")) {
	            filename = latestResume.getResumePath().substring(latestResume.getResumePath().lastIndexOf("/") + 1);
	        }
	        
	        return ResponseEntity.ok()
	                .contentType(MediaType.APPLICATION_PDF)
	                .header(
	                    HttpHeaders.CONTENT_DISPOSITION,
	                    "attachment; filename=\"" + filename + "\""
	                )
	                .body(resource);
	}
	
	@PostMapping("/request-meeting")
	public boolean requestMeeting(@RequestBody MeetingRequest meetingRequest) {
		if(meetingRequest!=null) {
			String body="Name: "+meetingRequest.getName()+"\n"
					+"Email: "+meetingRequest.getEmail()+"\n"
					+"Phone: "+meetingRequest.getPhone()+"\n"
					+"Address: "+meetingRequest.getAddress()+"\n"
					+"Intro: "+meetingRequest.getIntro()+"\n"
					+"Agenda: "+meetingRequest.getAgenda()+"\n"
					+"Mode: "+meetingRequest.getMode()+"\n"
					+"Date: "+meetingRequest.getDate()+"\n"
					+"Time: "+meetingRequest.getTime();
			return ms.sendEmail(meetingRequest.getEmail(), "Meeting Request from "+meetingRequest.getName(), body);
//			return true;
		}
		else {
			return false;
		}
	}
	
	
	@PostMapping("/startup-idea")
	public boolean startupRequest(@RequestBody StartupData startupData) {
		
		if(startupData!=null) {
			String data="Name: "+startupData.getFullName()+"\n"
					+"Email: "+startupData.getEmail()+"\n"
					+"Phone/Whatsapp: "+startupData.getPhone()+"\n"
					+"StartUp Name: "+startupData.getStartUpName()+"\n"
					+"Idea Summary: "+startupData.getIdea()+"\n"
					+"Problem Being Solved: "+startupData.getProblem()+"\n"
					+"Proposed Solution: "+startupData.getSolution()+"\n"
					+"Target Audience/User: "+startupData.getTargetAudience()+"\n"
					+"Current Stage: "+startupData.getCurrentStage()+"\n"
					+"Have You Build Anything: "+startupData.getHaveYouBuild()+"\n"
					+"Looking For: "+startupData.getLookingFor()+"\n"
					+"Expected Role: "+startupData.getExpectedRole()+"";
			try {
				ms.sendEmail(startupData.getEmail(), "New StartUp Idea", data);
				return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
//			return true;
		}
		else {
			return false;
		}
		
	}
	
	@PostMapping("/sendDocRequest")
	public boolean sendDocRequest(@RequestBody DocRequest dr) {
		if(dr!=null) {
			String data="Name: "+dr.getName()+"\n"
					+"Email: "+dr.getEmail()+"\n"
					+"Phone: "+dr.getPhone()+"\n"
					+"Purpose Of Document Request: "+dr.getPurpose()+"\n"
					+"Body: "+dr.getBody();
			try {
				ms.sendEmail(dr.getEmail(), "Document Request", data);
				return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
//		return true;
	}
	
	
}
