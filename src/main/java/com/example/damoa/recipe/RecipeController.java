package com.example.damoa.recipe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public String createRecipe(Model model) {
        model.addAttribute("recipeDTO", new RecipeDTO());
        return "/html/recipe/write";
    }

    @PostMapping("/recipe")
    public String createRecipe(@ModelAttribute("recipeDTO") RecipeDTO recipeDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        System.out.println("PostMapping recipe if");

        if (bindingResult.hasErrors()) {
            return "/html/recipe/write";
        }

        System.out.println("PostMapping recipe try");

        try {
            recipeService.createRecipe(recipeDTO);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("recipeFailed", "레시피 작성 실패");
            return "/html/recipe/write";
        }

        System.out.println("PostMapping recipe return");

        String recipeId = String.valueOf(recipeDTO.getRecipeId());

//        redirectAttributes.addAttribute("recipeId", recipeId);
        redirectAttributes.addFlashAttribute("recipeDTO", recipeDTO); // redirect 시 데이터 전달 -> redirect 되는 URL로 데이터 전달 가능 -> 접근 가능
        // TODO : 1. Recipe 에 저장된 ID를 가져와서 넘기기 2. Recipe 에서 DTO에 생성 시간 넘기고 DTO에서 시간 불러오기
        return "redirect:/recipe/" + recipeId;
    }


    @GetMapping("/recipe/{recipeId}")
    public String detailRecipe(@PathVariable Long recipeId, Model model) {
        model.addAttribute("recipe", recipeService.detailRecipe(recipeId));
        return "/html/recipe/detail";
    }

//    @GetMapping("/recipe/update/{recipeId}")
//    public String updateRecipe(@PathVariable Long recipeId, Model model, RecipeDTO recipeDTO) {
//        Recipe recipe = recipeService.findRecipeById(recipeId);
////        model.addAttribute("recipe", recipe);
//        model.addAttribute("recipeDTO", recipeDTO);
//        System.out.println("update GetMapping");
//        return "/html/recipe/edit";
//    }

    @GetMapping("/recipe/update/{recipeId}")
    public String updateRecipe(@PathVariable Long recipeId, Model model, RecipeDTO recipeDTO) {
        Recipe recipe = recipeService.findRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        recipeDTO.setRecipeName(recipe.getRecipeName());
        recipeDTO.setRecipeAuthorId(recipe.getRecipeAuthorId());
        recipeDTO.setRecipeLevel(recipe.getRecipeLevel());
        recipeDTO.setRecipeCalorie(recipe.getRecipeCalorie());
        recipeDTO.setRecipeCookingTime(recipe.getRecipeCookingTime());
        recipeDTO.setRecipeContent(recipe.getRecipeContent());
        model.addAttribute("recipeDTO", recipeDTO);
        System.out.println("update GetMapping");
        return "/html/recipe/edit";
    }

//    @PostMapping("/recipe/update")
//    public String updateRecipe(@ModelAttribute("recipeDTO") RecipeDTO recipeDTO) {
//        // recipeDTO에는 레시피 ID도 포함되어야 함
//        recipeService.updateRecipe(recipeDTO.getRecipeId(), recipeDTO);
//        return "redirect:/recipe/list";
//    }

    @PostMapping("/recipe/update/{recipeId}")
    public String updateRecipe(@PathVariable Long recipeId, RecipeDTO recipeDTO) { // @ModelAttribute("recipeDTO")
        // recipeId와 recipeDTO를 사용하여 업데이트 로직 수행
        System.out.println("update PostMapping 시작");
        recipeDTO.setRecipeId(recipeId); // recipeId를 recipeDTO에 설정
        recipeService.updateRecipe(recipeDTO);
        System.out.println("update PostMapping 끝");
        return "redirect:/recipe/list";
    }


//    @GetMapping("/recipe/update/{recipeId}")
//    public String updateRecipe(@PathVariable Long recipeId, Model model) {
//        model.addAttribute("recipe", recipeService.detailRecipe(recipeId));
//        return "/html/recipe/edit";
//    }
//
//    @PostMapping("/recipe/update")
//    public String updateRecipe(RecipeDTO recipeDTO) {
//        recipeService.updateRecipe(recipeDTO);
//        return "redirect:/recipe/list";
//    }

    @GetMapping("/recipe/delete/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteRecipe(recipeId);
        return "redirect:/recipe/list";
    }

    @GetMapping("/recipe/list")
    public String list(Model model) {
        model.addAttribute("recipeList", recipeService.listRecipe());
        return "/html/recipe/list";
    }

}
