package com.arifkoc.issuemanagement.repo;

import com.arifkoc.issuemanagement.Entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {

    List<IssueHistory> getByIssueIdOrderById(Long id);
}
