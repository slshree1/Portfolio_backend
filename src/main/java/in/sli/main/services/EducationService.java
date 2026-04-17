package in.sli.main.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.sli.main.beans.Education;

public interface EducationService {
	Education addEducation(Education edu, MultipartFile institutionLogo, MultipartFile certificates)throws IOException;
	List<Education> getEducation();
	boolean deleteEducation(int id);
}
