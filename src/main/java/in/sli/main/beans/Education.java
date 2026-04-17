package in.sli.main.beans;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Education {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String degree;
	@Column
	private String instituteName;
	@Column
	private String universityBoard;
	@Column
	private String location;
	@Column
	private LocalDate startDate;
	@Column
	private LocalDate endDate;
	@Column
	private String percentageCgpa;
	@Column
	private String courseTime;
	@Column
	private String fieldOfStudy;
	@Column
	private String institutionLogoPath;
	@Column
	private String certificatesPath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getUniversityBoard() {
		return universityBoard;
	}
	public void setUniversityBoard(String universityBoard) {
		this.universityBoard = universityBoard;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getPercentageCgpa() {
		return percentageCgpa;
	}
	public void setPercentageCgpa(String percentageCgpa) {
		this.percentageCgpa = percentageCgpa;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}
	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}
	public String getInstitutionLogoPath() {
		return institutionLogoPath;
	}
	public void setInstitutionLogoPath(String institutionLogoPath) {
		this.institutionLogoPath = institutionLogoPath;
	}
	public String getCertificatesPath() {
		return certificatesPath;
	}
	public void setCertificatesPath(String certificatesPath) {
		this.certificatesPath = certificatesPath;
	}
	
	
}
