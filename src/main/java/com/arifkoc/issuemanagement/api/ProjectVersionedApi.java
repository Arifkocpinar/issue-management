package com.arifkoc.issuemanagement.api;

import com.arifkoc.issuemanagement.dto.ProjectDto;
import com.arifkoc.issuemanagement.service.impl.ProjectServiceImpl;
import com.arifkoc.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(description = "Projects APIs",value = ApiPaths.ProjectCtrl.CTRL)
public class ProjectVersionedApi {

    @Autowired
    ProjectServiceImpl projectServiceImpl;

    @GetMapping(value = "/{id}",params = "version=1")
    @ApiOperation(value = "Get By Id operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV1(@PathVariable(value = "id", required = true) Long id){
        ProjectDto projectDto=projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @GetMapping(value = "/{id}",params = "version=2")
    @ApiOperation(value = "Get By Id operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV2(@PathVariable(value = "id", required = true) Long id){
        ProjectDto projectDto=projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }
}
