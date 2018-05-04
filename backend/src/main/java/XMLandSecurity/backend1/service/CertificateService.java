package XMLandSecurity.backend1.service;

import XMLandSecurity.backend1.model.IssuerData;
import XMLandSecurity.backend1.model.SubjectData;
import XMLandSecurity.backend1.model.dto.CertificateDTO;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;

public interface CertificateService {

    List<CertificateDTO> getAll();

    Certificate generateCertificate(CertificateDTO certificateDTO);

    SubjectData newSubjectData(CertificateDTO certificate);

    IssuerData newIssuerData(CertificateDTO certificate);

    boolean check(String id);

    String download(String id);

    void revoke(String serialNumber);

    List<X509Certificate> readRevoked();


}