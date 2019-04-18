package com.proje.service;

import java.util.List;

import com.proje.model.Education;

public interface EducationService {

	void saveEducation(Education education);

	void updateEducation(Education education);

	void removeEducation(Education education);

	Education findById(Integer educationId);

	List<Education> findEducations();

	Education findWithAdvertisement(Integer educationId);
}
