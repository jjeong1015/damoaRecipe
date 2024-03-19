package com.example.damoa.recipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RecipeDTO {

    private Long recipeId;

    private String recipeAuthorId;

    private String recipeName;

    private String recipeContent;

    private String recipeCalorie;

    private String recipeCookingTime;

    private Integer recipeLevel;

    private Integer recipeLike;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private RecipeStatus recipeStatus;

    public RecipeDTO(String recipeName, String recipeAuthorId , String recipeContent, String recipeCalorie, String recipeCookingTime, Integer recipeLevel) {
        this.recipeName = recipeName;
        this.recipeAuthorId = recipeAuthorId;
        this.recipeContent = recipeContent;
        this.recipeCalorie = recipeCalorie;
        this.recipeCookingTime = recipeCookingTime;
        this.recipeLevel = recipeLevel;
    }
}
