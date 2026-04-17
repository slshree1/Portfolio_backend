package in.sli.main.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.sli.main.beans.Certificate;

public interface CertificateService {
	Certificate addCertificate(Certificate cert, MultipartFile certificate)throws IOException;
	List<Certificate> getAllCertificates();
	boolean deleteCertificate(int id);
}
