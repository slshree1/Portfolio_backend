package in.sli.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import in.sli.main.beans.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Integer>{

}
