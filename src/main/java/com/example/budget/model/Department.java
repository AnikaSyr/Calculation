package com.example.budget.model;


import javax.persistence.*;

import java.util.List;


@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Product> products;

    @OneToMany(mappedBy = "department")
    private List<ProductCopy> productsCopies;

    @ManyToMany
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Department(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Department() {

    }

    public List<ProductCopy> getProductsCopies() {
        return productsCopies;
    }

    public void setProductsCopies(List<ProductCopy> productsCopies) {
        this.productsCopies = productsCopies;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
