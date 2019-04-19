package com.proje.repository;

import java.util.List;

import com.proje.model.Education;
/**
 * @author MetinKalinsaz
 */
public interface EducationRepository {

	void saveEducation(Education education);

	void updateEducation(Education education);

	void removeEducation(Education education);

	Education findById(Integer educationId);

	List<Education> findEducations();

	Education findWithAdvertisement(Integer educationId);

}
