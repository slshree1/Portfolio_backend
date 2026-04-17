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

import in.sli.main.beans.ResumeData;
import in.sli.main.repository.ResumeDataRepository;
@Service
public class ResumeServiceImpl implements ResumeDataService{
	@Autowired
	private ResumeDataRepository rdr;
	
	private static final String DOC_DIR="uploads/documents/";
	
	@Override
	public ResumeData updateResume(ResumeData resumeData, MultipartFile resume) throws IOException {
		// TODO Auto-generated method stub
		Files.createDirectories(Paths.get(DOC_DIR));
		
		if(resume!=null && !resume.isEmpty()) {
			String docName=UUID.randomUUID()+"_"+resume.getOriginalFilename();
			Path docPath=Paths.get(DOC_DIR+docName);
			Files.write(docPath, resume.getBytes());
			resumeData.setResumePath(docName.toString());
		}
		
		try {
			return rdr.save(resumeData);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
//		return null;
	}
	
	@Override
	public List<ResumeData> getResume() {
		// TODO Auto-generated method stub
//		return null;
		try {
			return rdr.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean deleteResume(int id) {
		// TODO Auto-generated method stub
//		return false;
		try {
			ResumeData rd=rdr.findById(id).orElse(null);
			
			if(rd==null) {
				return false;
			}
			
			if(rd.getResumePath()!=null) {
				Path rpath=Paths.get(DOC_DIR, rd.getResumePath());
				Files.deleteIfExists(rpath);
			}
			
			rdr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
