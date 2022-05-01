package com.hyberlet.task_24.service;

import com.hyberlet.task_24.model.Student;
import com.hyberlet.task_24.model.University;
import com.hyberlet.task_24.model.dto.UniversityDto;
import com.hyberlet.task_24.repository.StudentRepository;
import com.hyberlet.task_24.repository.UniversityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UniversityServiceTests {

    @Mock
    private MailService mailService;
    @Mock
    private UniversityRepository universityRepository;

    @InjectMocks
    private UniversityService universityService;

    @Test
    public void createUniversity() {
        University university = new University();
        university.setName("mirea");
        university.setCreationDate(LocalDate.parse("1947-05-28"));
        Mockito.when(universityRepository.getUniversitiesByName(university.getName()))
                .thenReturn(List.of(university));

        University mirea = new University();
        mirea.setName("mirea");
        mirea.setCreationDate(LocalDate.parse("1947-05-28"));
        universityService.saveUniversity(mirea);
        Mockito.verify(universityRepository).save(mirea);
        University isMirea = universityService.getUniversitiesByName("mirea").get(0);
        Mockito.verify(universityRepository).getUniversitiesByName("mirea");
        Assertions.assertEquals(mirea.getName(), isMirea.getName());
        Assertions.assertEquals(mirea.getCreationDate(), isMirea.getCreationDate());
    }

    @Test
    public void getAllUniversities() {
        University university = new University();
        university.setName("mirea");
        university.setCreationDate(LocalDate.parse("1947-05-28"));
        University university1 = new University();
        university1.setName("pgu");
        university1.setCreationDate(LocalDate.parse("1943-07-03"));
        Mockito.when(universityRepository.findAll())
                .thenReturn(List.of(university, university1));

        List<UniversityDto> universities = universityService.getUniversities();
        Mockito.verify(universityRepository).findAll();
        Assertions.assertEquals(2, universities.size());
        Assertions.assertEquals(List.of(university.getDto(), university1.getDto()), universities);
    }

}
