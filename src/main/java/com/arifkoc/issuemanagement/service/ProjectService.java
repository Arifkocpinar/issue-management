package com.arifkoc.issuemanagement.service;

import com.arifkoc.issuemanagement.Entity.Project;
import com.arifkoc.issuemanagement.dto.ProjectDto;
import com.arifkoc.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto projectDto);
}
