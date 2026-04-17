package in.sli.main.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.sli.main.beans.Experience;

public interface ExperienceService {
	Experience addExperience(Experience exp, MultipartFile companyLogo, MultipartFile documents)throws IOException;
	List<Experience> getExperience();
	boolean deleteExperience(int id);
}
