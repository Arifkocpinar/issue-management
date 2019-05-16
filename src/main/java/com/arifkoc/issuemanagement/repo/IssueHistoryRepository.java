package com.arifkoc.issuemanagement.repo;

import com.arifkoc.issuemanagement.Entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
}
