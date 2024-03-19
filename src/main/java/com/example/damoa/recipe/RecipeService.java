package com.example.damoa.recipe;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    public RecipeDTO createRecipe(RecipeDTO recipeDTO) { // public void createRecipe(RecipeDTO recipeDTO)
        System.out.println("RecipeService 도착");

        try {
//            Recipe recipe = new Recipe(recipeDTO.getRecipeId(), recipeDTO.getRecipeName(), recipeDTO.getRecipeAuthorId(), recipeDTO.getRecipeContent(), recipeDTO.getRecipeCalorie(), recipeDTO.getRecipeCookingTime(), recipeDTO.getRecipeLevel());
            Recipe recipe = new Recipe(recipeDTO.getRecipeName(), recipeDTO.getRecipeAuthorId(), recipeDTO.getRecipeContent(), recipeDTO.getRecipeCalorie(), recipeDTO.getRecipeCookingTime(), recipeDTO.getRecipeLevel());
            Recipe savedRecipe = recipeRepository.save(recipe);
            System.out.println(recipe + "recipe");
            recipeDTO.setRecipeId(savedRecipe.getRecipeId()); // 자동으로 생성된 recipeId를 recipeDTO에 설정

            return recipeDTO;
        } catch (Exception e) {
            e.printStackTrace(); // 예외를 로그에 출력하거나 원하는 방식으로 처리
            throw new RuntimeException("Recipe creation failed", e);
        }
    }


    public Recipe detailRecipe(Long recipeId) {
        return recipeRepository.findByRecipeId(recipeId).orElse(null);
    }

    public Recipe findRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe with ID " + recipeId + " not found"));
    }

    public Recipe updateRecipe(RecipeDTO recipeDTO) {
        System.out.println("updateRecipe Service 도착");
        Long recipeId = recipeDTO.getRecipeId();
        Recipe existingRecipe = findRecipeById(recipeId);

        // 업데이트할 정보로 기존 레시피 수정
        existingRecipe.setRecipeName(recipeDTO.getRecipeName());
        existingRecipe.setRecipeContent(recipeDTO.getRecipeContent());
        existingRecipe.setRecipeCalorie(recipeDTO.getRecipeCalorie());
        existingRecipe.setRecipeCookingTime(recipeDTO.getRecipeCookingTime());
        existingRecipe.setRecipeLevel(recipeDTO.getRecipeLevel());
        System.out.println("existingRecipe");
        // 수정된 레시피를 저장
        return recipeRepository.save(existingRecipe);
    }

//    public Recipe updateRecipe(Long recipeId, RecipeDTO recipeDTO) throws RecipeNotFoundException {
//        Recipe updateRecipe = recipeRepository.findById(recipeId).orElse(null);
//        // 레시피가 존재할 경우에만 업데이트 수행
//        if (updateRecipe != null) {
//            // 업데이트할 정보로 기존 레시피 수정
//            updateRecipe.setRecipeName(recipeDTO.getRecipeName());
//            updateRecipe.setRecipeContent(recipeDTO.getRecipeContent());
//            updateRecipe.setRecipeCalorie(recipeDTO.getRecipeCalorie());
//            updateRecipe.setRecipeCookingTime(recipeDTO.getRecipeCookingTime());
//            updateRecipe.setRecipeLevel(recipeDTO.getRecipeLevel());
//
//            // 수정된 레시피를 저장
//            return recipeRepository.save(updateRecipe);
//        } else {
//            // 레시피가 존재하지 않으면 예외처리 또는 적절한 처리 수행
//            throw new RecipeNotFoundException("Recipe with ID " + recipeId + " not found");
//        }
//    }

    public void deleteRecipe(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }


    public List<Recipe> listRecipe() {
        return recipeRepository.findAll(Sort.by(Sort.Direction.DESC, "recipeId"));
    }


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

//    Optional<Recipe> findByRecipeId(Long recipeId) {
//        return recipeRepository.findByRecipeId(recipeId);
//
//    }
//    Optional<Recipe> findByRecipeAuthorId(String recipeAuthorId) {
//        return recipeRepository.findByRecipeAuthorId(recipeAuthorId);
//
//    }
//    Optional<Recipe> findByRecipeName(String recipeName) {
//        return recipeRepository.findByRecipeName(recipeName);
//    }
//    Optional<Recipe> findByRecipeContent(String recipeContent) {
//        return recipeRepository.findByRecipeContent(recipeContent);
//    }
//
//    Optional<Recipe> findByRecipeCalorie(String recipeCalorie) {
//        return recipeRepository.findByRecipeCalorie(recipeCalorie);
//    }
//
//    Optional<Recipe> findByRecipeCookingTime(String recipeCookingTime) {
//        return recipeRepository.findByRecipeCookingTime(recipeCookingTime);
//    }
//
//    Optional<Recipe> findByRecipeLevel(Integer recipeLevel) {
//        return recipeRepository.findByRecipeLevel(recipeLevel);
//    }
//
//    Optional<Recipe> findByRecipeLike(Integer recipeLike) {
//        return recipeRepository.findByRecipeLike(recipeLike);
//    }
//    public Optional<Recipe> updateRecipe(String recipeName, RecipeDTO recipeDTO) {
//        Recipe recipe = recipeRepository.findByRecipeName(recipeName).orElseThrow(() -> new IllegalArgumentException("recipeName이 " + recipeName + "인 멤버 존재하지 않음"));
//        Recipe updateRecipe = recipe;
//        updateRecipe.setRecipeName(recipeDTO.getRecipeName());
//        updateRecipe.setRecipeContent(recipeDTO.getRecipeContent());
//        updateRecipe.setRecipeCalorie(recipeDTO.getRecipeCalorie());
//        updateRecipe.setRecipeCookingTime(recipeDTO.getRecipeCookingTime());
//        updateRecipe.setRecipeLevel(recipeDTO.getRecipeLevel());
//
//        return Optional.of(recipeRepository.save(updateRecipe));
//    }
//
//    public void deleteRecipe(Long recipeId) {
//        recipeRepository.deleteById(recipeId);
//    }

}
