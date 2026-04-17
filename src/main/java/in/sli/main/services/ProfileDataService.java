package in.sli.main.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.sli.main.beans.ProfileData;

public interface ProfileDataService {
	ProfileData addProfileData(ProfileData pd, MultipartFile profilePicture)throws IOException;
	List<ProfileData> getProfiles();
	boolean deleteProfile(int id);
	ProfileData getTopProfile();
}	
