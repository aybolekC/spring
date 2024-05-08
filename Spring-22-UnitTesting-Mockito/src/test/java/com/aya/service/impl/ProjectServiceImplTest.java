package com.aya.service.impl;

import com.aya.dto.ProjectDTO;
import com.aya.entity.Project;
import com.aya.mapper.ProjectMapper;
import com.aya.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper mapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_test(){

        //Given
        Project project=new Project();
        ProjectDTO projectDTO=new ProjectDTO();

        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
        when(mapper.convertToDTO(project)).thenReturn(projectDTO);

        //When
        ProjectDTO projectDTO1= projectService.getByProjectCode(anyString());

        //Then
        verify(projectRepository).findByProjectCode(anyString());
        verify(mapper).convertToDTO(any(Project.class));
        assertNotNull(projectDTO1);

    }

    @Test
    void getByProjectCode_exception_test(){
        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));

        Throwable exception= assertThrows(RuntimeException.class,()->projectService.getByProjectCode("AB01"));

        verify(projectRepository).findByProjectCode(anyString());

        assertEquals("Project Not Found", exception.getMessage());
    }

    @Test
    void save_test(){

        ProjectDTO projectDTO=new ProjectDTO();
        Project project=new Project();

        when(mapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDTO);

        verify(projectRepository).save(project);
        verify(mapper).convertToEntity(any(ProjectDTO.class));

    }

}