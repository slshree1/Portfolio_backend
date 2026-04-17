package in.sli.main.beans;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String logo;
	@Column
	private String category;
	@Column
	private String experienceLevel;
	@Column
	private float experienceYears;
	@Column
	private int rating;
	@Column
	private String use_purpose;
	@Column
	private String description;
	@Column
	private List<String> projectsUsing;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	public float getExperienceYears() {
		return experienceYears;
	}
	public void setExperienceYears(float experienceYears) {
		this.experienceYears = experienceYears;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getProjectsUsing() {
		return projectsUsing;
	}
	public void setProjectsUsing(List<String> projectsUsing) {
		this.projectsUsing = projectsUsing;
	}
	public String getUse_purpose() {
		return use_purpose;
	}
	public void setUse_purpose(String use_purpose) {
		this.use_purpose = use_purpose;
	}
	
	
}
