package com.arifkoc.issuemanagement.service.impl;

import com.arifkoc.issuemanagement.Entity.Issue;
import com.arifkoc.issuemanagement.dto.IssueDto;
import com.arifkoc.issuemanagement.repo.IssueRepository;
import com.arifkoc.issuemanagement.service.IssueService;
import com.arifkoc.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper){
        this.issueRepository=issueRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issueDto) {
        if(issueDto.getDate() == null)
            throw new IllegalArgumentException("Issue Date Cannot Be Null!!");

        Issue issueDb= modelMapper.map(issueDto,Issue.class);
        issueDb=issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data= issueRepository.findAll(pageable);
        TPage page= new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return true;
    }

    @Override
    public IssueDto update(Long id, IssueDto issueDto) {
        Issue issueDb= issueRepository.getOne(id);
        if(issueDb == null)
            throw new IllegalArgumentException("Project does not exist ID:"+id);
        //Proje kodu kendinden başka varmı kontrolu
        //Issue control=issueRepository.getByProjectCodeAndIdNot(issueDto.getProjectCode(),id);
        //if (control != null )
         //   throw new IllegalArgumentException("Project Code Already Exist");
        //issueDb.setProjectName(issueDto.getProjectName());
        //issueDb.setProjectCode(issueDto.getProjectCode());
        //issueRepository.save(issueDto);
        //modelMapper.map(issueDb,IssueDto.class);
        return null;
    }
}
