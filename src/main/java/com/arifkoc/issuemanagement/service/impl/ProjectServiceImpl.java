package com.arifkoc.issuemanagement.service.impl;

import com.arifkoc.issuemanagement.Entity.Project;
import com.arifkoc.issuemanagement.Entity.User;
import com.arifkoc.issuemanagement.dto.ProjectDto;
import com.arifkoc.issuemanagement.repo.ProjectRepository;
import com.arifkoc.issuemanagement.service.ProjectService;
import com.arifkoc.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final UserServiceImpl userServiceImpl;
    public ProjectServiceImpl(ProjectRepository projectRepository , UserServiceImpl userServiceImpl,ModelMapper modelMapper){
        this.projectRepository=projectRepository;
        this.modelMapper=modelMapper;
        this.userServiceImpl=userServiceImpl;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        Project control=projectRepository.getByProjectCode(projectDto.getProjectCode());
        if (control != null)
            throw new IllegalArgumentException("Project Code Already Exist");
        Project p=modelMapper.map(projectDto,Project.class);
        p.setManager(modelMapper.map(userServiceImpl.getById(projectDto.getManagerId()), User.class));
        p=projectRepository.save(p);
        projectDto.setId(p.getId());
        return projectDto;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p=projectRepository.getOne(id);
        ProjectDto pd=modelMapper.map(p,ProjectDto.class);
        return pd;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {

        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response= new TPage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(),ProjectDto[].class)));
        return response;
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {

        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project projectDb= projectRepository.getOne(id);
        if(projectDb == null)
            throw new IllegalArgumentException("Project does not exist ID:"+id);
        //Proje kodu kendinden başka varmı kontrolu
        Project control=projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(),id);
        if (control != null )
            throw new IllegalArgumentException("Project Code Already Exist");
        projectDb.setProjectName(projectDto.getProjectName());
        projectDb.setProjectCode(projectDto.getProjectCode());
        projectRepository.save(projectDb);
        return modelMapper.map(projectDb,ProjectDto.class);
    }

    public List<ProjectDto> getAll() {
        List<Project> data = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(data,ProjectDto[].class));
    }
}
