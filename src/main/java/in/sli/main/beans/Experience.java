package in.sli.main.beans;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class Experience {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String jobTitle;
	@Column
	private String companyName;
	@Column
	private String workType;
	@Column
	private LocalDate startDate;
	@Column
	private LocalDate endDate;
	@Column
	private String location;
	@Column
	private String description;
	@Column
	private List<String> technologiesUsed;
	@Column
	private List<String> projectsWorkedOn;
	@Column
	private String companyLogoPath;
	@Column
	private String documentsPath;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getTechnologiesUsed() {
		return technologiesUsed;
	}
	public void setTechnologiesUsed(List<String> technologiesUsed) {
		this.technologiesUsed = technologiesUsed;
	}
	public List<String> getProjectsWorkedOn() {
		return projectsWorkedOn;
	}
	public void setProjectsWrokedOn(List<String> projectsWorkedOn) {
		this.projectsWorkedOn = projectsWorkedOn;
	}
	public String getCompanyLogoPath() {
		return companyLogoPath;
	}
	public void setCompanyLogoPath(String companyLogoPath) {
		this.companyLogoPath = companyLogoPath;
	}
	public String getDocumentsPath() {
		return documentsPath;
	}
	public void setDocumentsPath(String documentsPath) {
		this.documentsPath = documentsPath;
	}
	
	
}
