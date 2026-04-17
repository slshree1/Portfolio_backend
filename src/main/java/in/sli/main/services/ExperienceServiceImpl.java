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

import in.sli.main.beans.Experience;
import in.sli.main.repository.ExperienceRepository;

@Service
public class ExperienceServiceImpl implements ExperienceService{
	@Autowired
	private ExperienceRepository er;
	
	private static final String LOGO_DIR="uploads/logos/";
	private static final String DOC_DIR="uploads/documents/";
	@Override
	public Experience addExperience(Experience exp, MultipartFile companyLogo, MultipartFile documents) throws IOException {
		Files.createDirectories(Paths.get(LOGO_DIR));
		Files.createDirectories(Paths.get(DOC_DIR));
		
		if(companyLogo !=null && !companyLogo.isEmpty()) {
			String logoName= UUID.randomUUID()+"_"+companyLogo.getOriginalFilename();
			Path logoPath = Paths.get(LOGO_DIR + logoName);
            Files.write(logoPath, companyLogo.getBytes());
            exp.setCompanyLogoPath(logoName.toString());
		}
		
		if (documents != null && !documents.isEmpty()) {
            String docName = UUID.randomUUID() + "_" + documents.getOriginalFilename();
            Path docPath = Paths.get(DOC_DIR + docName);
            Files.write(docPath, documents.getBytes());
            exp.setDocumentsPath(docName.toString());
        }
		try {
			return er.save(exp);			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<Experience> getExperience() {
		// TODO Auto-generated method stub
//		return null;
		try {
			return er.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean deleteExperience(int id) {
		// TODO Auto-generated method stub
//		return false;
		try {
			
			Experience exp=er.findById(id).orElse(null);
			if(exp ==null) {
				return false;
			}
			
			if(exp.getCompanyLogoPath() !=null) {
				Path logoPath=Paths.get(LOGO_DIR, exp.getCompanyLogoPath());
				Files.deleteIfExists(logoPath);
			}
			
			
			if(exp.getDocumentsPath()!=null) {
				Path docPath=Paths.get(DOC_DIR, exp.getDocumentsPath());
				Files.deleteIfExists(docPath);
			}
			
			
			
			er.deleteById(id);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
