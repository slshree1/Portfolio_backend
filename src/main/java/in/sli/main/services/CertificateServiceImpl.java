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

import in.sli.main.beans.Certificate;
import in.sli.main.repository.CertificateRepository;

@Service
public class CertificateServiceImpl implements CertificateService{
	@Autowired
	private CertificateRepository cr;
	
	
	
	private static final String DOC_DIR="uploads/documents/";
	@Override
	public Certificate addCertificate(Certificate cert, MultipartFile certificate) throws IOException {
		// TODO Auto-generated method stub
//		return null;
		Files.createDirectories(Paths.get(DOC_DIR));
		
		if(certificate !=null && !certificate.isEmpty()) {
			
			String certificateName=UUID.randomUUID()+"_"+certificate.getOriginalFilename();
			Path certificatePath=Paths.get(DOC_DIR+certificateName);
			Files.write(certificatePath, certificate.getBytes());
			cert.setCertificatePath(certificateName);
			System.out.println("certificate file got ");
			System.out.println("Path"+certificatePath);
			System.out.println("certificateName: "+certificateName);
			
		}
		
		try {
			return cr.save(cert);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public List<Certificate> getAllCertificates() {
		// TODO Auto-generated method stub
//		return null;
		try {
			return cr.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean deleteCertificate(int id) {
		// TODO Auto-generated method stub
		try {
			Certificate cert=cr.findById(id).orElse(null);
			
			if(cert==null) {
				return false;
			}
			if(cert.getCertificatePath()!=null) {
				Path certPath=Paths.get(DOC_DIR, cert.getCertificatePath());
				Files.deleteIfExists(certPath);
			}
			cr.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
