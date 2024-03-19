package com.example.damoa.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findByRecipeId(Long recipeId);
    Optional<Recipe> findByRecipeAuthorId(String recipeAuthorId);
    Optional<Recipe> findByRecipeName(String recipeName);
    Optional<Recipe> findByRecipeContent(String recipeContent);

    Optional<Recipe> findByRecipeCalorie(String recipeCalorie);

    Optional<Recipe> findByRecipeCookingTime(String recipeCookingTime);

    Optional<Recipe> findByRecipeLevel(Integer recipeLevel);

    // Optional<Recipe> findByRecipeLike(Integer recipeLike);
}
