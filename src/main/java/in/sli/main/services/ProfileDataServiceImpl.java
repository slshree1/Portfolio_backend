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

import in.sli.main.beans.ProfileData;
import in.sli.main.repository.ProfileDataRepository;
@Service
public class ProfileDataServiceImpl implements ProfileDataService {
	@Autowired
	private ProfileDataRepository pdr;
	
	private static final String IMG_DIR="uploads/images/";
	
	@Override
	public ProfileData addProfileData(ProfileData pd, MultipartFile profilePicture) throws IOException {
		// TODO Auto-generated method stub
//		return null;
		Files.createDirectories(Paths.get(IMG_DIR));
		
		if(profilePicture!=null && !profilePicture.isEmpty()) {
			String profilePictureName=UUID.randomUUID()+"_"+profilePicture.getOriginalFilename();
			Path profilePicturePath=Paths.get(IMG_DIR+profilePictureName);
			Files.write(profilePicturePath, profilePicture.getBytes());
			pd.setProfilePicturePath(profilePictureName);
		}
		
		try {
			return pdr.save(pd);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public List<ProfileData> getProfiles() {
		// TODO Auto-generated method stub
		try {
			return pdr.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public boolean deleteProfile(int id) {
		// TODO Auto-generated method stub
//		return false;
		
		try {
			ProfileData profileData=pdr.findById(id).orElse(null);
			if(profileData==null) {
				return false;
			}
			
			if(profileData.getProfilePicturePath()!=null) {
				Path profileImagePath=Paths.get(IMG_DIR, profileData.getProfilePicturePath());
				Files.deleteIfExists(profileImagePath);
			}
			
			pdr.delete(profileData);
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public ProfileData getTopProfile() {
		// TODO Auto-generated method stub
//		return null;
		try {
			return pdr.findTopByOrderByIdDesc();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
