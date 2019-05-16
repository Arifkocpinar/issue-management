package com.arifkoc.issuemanagement.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@EqualsAndHashCode
@Table(name="project")
@AllArgsConstructor
@NoArgsConstructor

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="project_code",unique = true,length =30 )
    private String projectCode;

    @Column(name = "project_name",length = 300)
    private String projectName;

    @JoinColumn(name="manager_user_id")
    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    private User manager;
}
