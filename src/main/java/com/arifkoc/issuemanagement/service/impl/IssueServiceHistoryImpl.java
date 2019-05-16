package com.arifkoc.issuemanagement.service.impl;

import com.arifkoc.issuemanagement.Entity.IssueHistory;
import com.arifkoc.issuemanagement.repo.IssueHistoryRepository;
import com.arifkoc.issuemanagement.service.IssueServiceHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceHistoryImpl implements IssueServiceHistory {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueServiceHistoryImpl(IssueHistoryRepository issueHistoryRepository){
        this.issueHistoryRepository=issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory.getDate()==null){
            throw new IllegalArgumentException("Issue can not be null");
        }
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {

        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
