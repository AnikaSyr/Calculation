//package com.example.budget.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="project_products")
//public class ProjectsProducts {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name="product_id")
//    private Product product;
//
//    @ManyToOne
//    @JoinColumn(name="project_id")
//    private Project project;
//
//    public ProjectsProducts() {
//
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
//
//    private int quantity;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public ProjectsProducts(Product product, Project project, int quantity) {
//        this.product = product;
//        this.project = project;
//        this.quantity = quantity;
//    }
//}
