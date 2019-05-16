package com.arifkoc.issuemanagement.api;


import com.arifkoc.issuemanagement.dto.IssueDto;
import com.arifkoc.issuemanagement.service.impl.IssueServiceImpl;
import com.arifkoc.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(description = "Issue's APIs",value = ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl){
        this.issueServiceImpl=issueServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id){
        IssueDto ıssueDto=issueServiceImpl.getById(id);
        return ResponseEntity.ok(ıssueDto);
    }

    @PostMapping
    @ApiOperation(value = "create ıssue operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto ıssueDto){
        return ResponseEntity.ok(issueServiceImpl.save(ıssueDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Updeta ıssue operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> updateProject(@Valid @RequestBody IssueDto ıssueDto,@PathVariable(value = "id", required = true) Long id){

        return ResponseEntity.ok(issueServiceImpl.update(id,ıssueDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete Issue operation",response = Boolean.class)
    public  ResponseEntity<Boolean> deleteProject (@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
