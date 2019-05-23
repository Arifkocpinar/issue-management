package com.arifkoc.issuemanagement.api;

import com.arifkoc.issuemanagement.Entity.Project;
import com.arifkoc.issuemanagement.dto.ProjectDto;
import com.arifkoc.issuemanagement.service.impl.ProjectServiceImpl;
import com.arifkoc.issuemanagement.util.ApiPaths;
import com.arifkoc.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(description = "Projects APIs",value = ApiPaths.ProjectCtrl.CTRL)
@CrossOrigin
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl){
        this.projectServiceImpl=projectServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get pagination operation",response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable){
        return ResponseEntity.ok(projectServiceImpl.getAllPageable(pageable));
    }
    @GetMapping()
    @ApiOperation(value = "Get All operation",response = ProjectDto.class,responseContainer = "List")
    public ResponseEntity<List<ProjectDto>> getAll(Pageable pageable){
        List<ProjectDto> list=projectServiceImpl.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id){
        ProjectDto projectDto=projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "create project operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto){
        ProjectDto projectDtoo=projectDto;
        return ResponseEntity.ok(projectServiceImpl.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "update project operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@Valid @RequestBody ProjectDto projectDto,@PathVariable(value = "id", required = true) Long id){

        return ResponseEntity.ok(projectServiceImpl.update(id,projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete operation",response = Boolean.class)
    public  ResponseEntity<Boolean> deleteProject (@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
