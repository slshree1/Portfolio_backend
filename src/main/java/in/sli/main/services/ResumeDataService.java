package in.sli.main.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.sli.main.beans.ResumeData;

public interface ResumeDataService {
	ResumeData updateResume(ResumeData resumeData, MultipartFile resume)throws IOException;
	List<ResumeData> getResume();
	boolean deleteResume(int id);
}
