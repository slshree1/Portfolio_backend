package in.sli.main.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.sli.main.beans.Education;
import in.sli.main.repository.EducationRepository;
@Service
public class EducationServiceImpl implements EducationService{
	@Autowired
	private EducationRepository er;
	
	
	private static final String LOGO_DIR="uploads/logos/";
	private static final String DOC_DIR="uploads/documents/";
	
	
	@Override
	public Education addEducation(Education edu, MultipartFile institutionLogo, MultipartFile certificates)throws IOException {
		Files.createDirectories(Paths.get(LOGO_DIR));
		Files.createDirectories(Paths.get(DOC_DIR));
		
		
		if(institutionLogo !=null && !institutionLogo.isEmpty()) {
			String logoName= UUID.randomUUID()+"_"+institutionLogo.getOriginalFilename();
			Path logoPath = Paths.get(LOGO_DIR + logoName);
            Files.write(logoPath, institutionLogo.getBytes());
            edu.setInstitutionLogoPath(logoName);
		}
		
		if (certificates != null && !certificates.isEmpty()) {
			
            String docName = UUID.randomUUID() + "_" + certificates.getOriginalFilename();
            Path docPath = Paths.get(DOC_DIR + docName);
//            Path docPath = Paths.get(docName);
            Files.write(docPath, certificates.getBytes());
            edu.setCertificatesPath(docName);
        }
		try {
			return er.save(edu);			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Education> getEducation() {
		// TODO Auto-generated method stub
		try {
			return er.findAll();			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public boolean deleteEducation(int id) {
		// TODO Auto-generated method stub
//		return false;
		try {
			Education edu=er.findById(id).orElse(null);
			
			if(edu==null) {
				return false;
			}
			
			if(edu.getInstitutionLogoPath()!=null) {
				Path logoPath=Paths.get(LOGO_DIR, edu.getInstitutionLogoPath());
				Files.deleteIfExists(logoPath);
			}
			
			if(edu.getCertificatesPath()!=null) {
				Path docPath=Paths.get(DOC_DIR, edu.getCertificatesPath());
				Files.deleteIfExists(docPath);
			}
			
			er.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
