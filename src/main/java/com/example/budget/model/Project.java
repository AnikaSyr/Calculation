package com.example.budget.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date date;

    @OneToMany
    @JoinColumn(name="id_project")
    List<ProductCopy> productCopies;

    @ManyToOne
    private Client client;

    @OneToMany
    @JoinColumn(name="id_project")
    List<Department> departments;



    public Project() {
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Project(Long id, String name, Date date, List<ProductCopy> productCopies, Client client, List<Department> departments) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.productCopies = productCopies;
        this.client = client;
        this.departments = departments;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ProductCopy> getProductCopies() {
        return productCopies;
    }

    public void setProductCopies(List<ProductCopy> productCopies) {
        this.productCopies = productCopies;
    }
}
