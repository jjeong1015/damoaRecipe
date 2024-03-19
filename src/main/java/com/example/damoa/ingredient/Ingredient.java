//package com.example.damoa.ingredient;
//
//import com.example.damoa.recipe.RecipeStatus;
//import com.example.damoa.recipeIngredient.RecipeIngredient;
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
//@Table(name = "ingredient")
//public class Ingredient {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ingredient_id")
//    private Long ingredientId;
//
//    @Column(nullable = false)
//    private String ingredientName;
//
//    @Column(nullable = false)
//    private String ingredientUnit;
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
//    private IngredientStatus ingredientStatus;
//
//    @OneToMany(mappedBy = "ingredient")
//    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();
//
//    public Ingredient() {
//    }
//
//    public Ingredient(Long ingredientId, String ingredientName, String ingredientUnit, LocalDateTime createdAt, LocalDateTime updatedAt, IngredientStatus ingredientStatus, List<RecipeIngredient> recipeIngredients) {
//        this.ingredientId = ingredientId;
//        this.ingredientName = ingredientName;
//        this.ingredientUnit = ingredientUnit;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.ingredientStatus = ingredientStatus;
//        this.recipeIngredients = recipeIngredients;
//    }
//
//    public void updateIngredient(String ingredientName, String ingredientUnit) {
//        this.ingredientName = ingredientName;
//        this.ingredientUnit = ingredientUnit;
//
//    }
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
//}
