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

        Throwable exception= assertThrows(RuntimeException.class,()->projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode(anyString());


        assertEquals(exception.getMessage(),"Project Not Found");
    }

}