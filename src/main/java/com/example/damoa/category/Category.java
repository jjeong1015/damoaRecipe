//package com.example.damoa.category;
//
//import com.example.damoa.image.Image;
//import com.example.damoa.ingredient.IngredientStatus;
//import com.example.damoa.recipe.Recipe;
//import com.example.damoa.recipeIngredient.RecipeIngredient;
//import com.example.damoa.review.Review;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//@EntityListeners(AuditingEntityListener.class)
//@ToString
//@Table(name = "category")
//public class Category {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "category_id")
//    private Integer categoryId;
//
//    @Column(nullable = false)
//    private String categoryType;
//
//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @Version
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
//
//    @Enumerated(EnumType.STRING)
//    private CategoryStatus categoryStatus;
//
//    @OneToMany(mappedBy = "category")
//    private List<Recipe> recipes = new ArrayList<>();
//
//    @OneToMany(mappedBy = "category")
//    private List<Review> reviews = new ArrayList<>();
//
//    @OneToMany(mappedBy = "category")
//    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();
//
//    @OneToMany(mappedBy = "category")
//    private List<Image> images = new ArrayList<>();
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    public Category() {
//    }
//
//    public Category(Integer categoryId, String categoryType, LocalDateTime createdAt, LocalDateTime updatedAt, CategoryStatus categoryStatus, List<Recipe> recipes, List<Review> reviews, List<RecipeIngredient> recipeIngredients, List<Image> images) {
//        this.categoryId = categoryId;
//        this.categoryType = categoryType;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.categoryStatus = categoryStatus;
//        this.recipes = recipes;
//        this.reviews = reviews;
//        this.recipeIngredients = recipeIngredients;
//        this.images = images;
//    }
//}
