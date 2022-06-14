package com.example.budget.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate date;

    @ManyToMany
    @JoinTable(name = "project_products",
    joinColumns = @JoinColumn(name = "project_id"),
    inverseJoinColumns = @JoinColumn(name="product_id"))
    List<Product> products;

    @ManyToOne
    private Client client;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDate() {
        return date;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<ProductCopy> productsCopies;

    public List<ProductCopy> getProductsCopies() {
        return productsCopies;
    }

    public void setProductsCopies(List<ProductCopy> productsCopies) {
        this.productsCopies = productsCopies;
    }

    @ManyToMany
    @JoinTable(name = "project_departments",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name="department_id"))
    List<Department> departments;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Project() {
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
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



    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Project(String name, LocalDate date, List<Product> products, Client client, List<ProductCopy> productsCopies, List<Department> departments) {
        this.name = name;
        this.date = date;
        this.products = products;
        this.client = client;
        this.productsCopies = productsCopies;
        this.departments = departments;
    }
}
