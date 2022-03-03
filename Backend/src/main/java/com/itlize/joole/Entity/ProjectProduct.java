package com.itlize.joole.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="projectProduct")
public class ProjectProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_product_id")
    private Long id;

    private Date dateCreated;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projectId;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }
}
