package com.arifkoc.issuemanagement.service;

import com.arifkoc.issuemanagement.Entity.Issue;
import com.arifkoc.issuemanagement.dto.IssueDto;
import com.arifkoc.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IssueService {

    IssueDto save(IssueDto issueDto);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    IssueDto update(Long id,IssueDto ıssueDto);


}
