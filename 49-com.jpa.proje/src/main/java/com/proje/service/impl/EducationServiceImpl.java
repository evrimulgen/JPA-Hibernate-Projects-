package com.proje.service.impl;

import java.util.List;

import com.proje.model.Education;
import com.proje.repository.EducationRepository;
import com.proje.repository.impl.EducationRepositoryImpl;
import com.proje.service.EducationService;

public class EducationServiceImpl implements EducationService {

	private EducationRepository educationRepository = new EducationRepositoryImpl();

	@Override
	public void saveEducation(final Education education) {

		this.educationRepository.saveEducation(education);

	}

	@Override
	public void updateEducation(final Education education) {

		this.educationRepository.updateEducation(education);
	}

	@Override
	public void removeEducation(final Education education) {

		this.educationRepository.removeEducation(education);
	}

	@Override
	public Education findById(final Integer educationId) {

		Education education = this.educationRepository.findById(educationId);

		return education;
	}

	@Override
	public List<Education> findEducations() {

		List<Education> educations = this.educationRepository.findEducations();

		return educations;
	}

	@Override
	public Education findWithAdvertisement(final Integer educationId) {

		Education education = this.educationRepository.findWithAdvertisement(educationId);

		return education;
	}

}
