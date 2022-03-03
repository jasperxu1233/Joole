package com.itlize.joole.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "projects")
@EntityListeners(AuditingEntityListener.class)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Long id;

    private String projectName;


    @ManyToOne(targetEntity = User.class)
    @Column(name = "user_id")
    private User owner;

    @JsonIgnore
    @OneToMany (targetEntity = ProjectProduct.class,
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY,
            mappedBy = "projects")
    private List<ProjectProduct> projectProductList;

    @CreatedDate
    @Column(name = "project_created_date")
    private Date timeCreated;

    @LastModifiedDate
    @Column(name = "project_modified_date")
    private Date lastUpdated;

    public Project(Long id, String projectName, User owner,
                   List<ProjectProduct> projectProductList,
                   Date timeCreated, Date lastUpdated) {
        this.id = id;
        this.projectName = projectName;
        this.owner = owner;
        this.projectProductList = projectProductList;
        this.timeCreated = timeCreated;
        this.lastUpdated = lastUpdated;
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<ProjectProduct> getProjectProductList() {
        return projectProductList;
    }

    public void setProjectProductList(List<ProjectProduct> projectProductList) {
        this.projectProductList = projectProductList;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
