//package com.example.damoa.recipeIngredient;
//
//import com.example.damoa.ingredient.Ingredient;
//import com.example.damoa.member.Member;
//import com.example.damoa.recipe.Recipe;
//import com.example.damoa.category.Category;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//@EntityListeners(AuditingEntityListener.class)
//@ToString
//@Table(name = "recipeIngredient")
//public class RecipeIngredient {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "recipe_ingredient_id")
//    private Long recipeIngredientId;
//
//    @ManyToOne
//    @JoinColumn(name = "recipe_id")
//    private Recipe recipe;
//
//    public void setRecipe(Recipe recipe) {
//        this.recipe = recipe;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "ingredient_id")
//    private Ingredient ingredient;
//
//    public void setIngredient(Ingredient ingredient) {
//        this.ingredient = ingredient;
//    }
//
//    public RecipeIngredient() {
//    }
//
//    public RecipeIngredient(Long recipeIngredientId, Recipe recipe, Category category, Ingredient ingredient) {
//        this.recipeIngredientId = recipeIngredientId;
//        this.recipe = recipe;
//        this.category = category;
//        this.ingredient = ingredient;
//    }
//}
