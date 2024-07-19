package com.yoon.foundation.service.recipe;

import com.yoon.foundation.common.response.CommonResponse;
import com.yoon.foundation.domain.member.Member;
import com.yoon.foundation.domain.recipe.Ingredient;
import com.yoon.foundation.domain.recipe.Recipe;
import com.yoon.foundation.dto.recipe.RecipeResponseDTO;
import com.yoon.foundation.repository.member.MemberRepository;
import com.yoon.foundation.repository.recipe.IngredientRepository;
import com.yoon.foundation.repository.recipe.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeQueryService {
    private final MemberRepository memberRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public CommonResponse<Object> findRecipe(Long id, Long memberId)   {
        Member member = memberRepository.findMember(memberId);
        Recipe recipe = recipeRepository.findRecipe(id);
        Double servingSize = member.getServingSize();
        Integer scale = (int) Math.ceil(member.getServingSize());
        Integer reducedCo2 = (int) (recipe.getTotalAmount()*scale- recipe.getTotalAmount()*servingSize);
        List<Ingredient> ingredients= ingredientRepository.findIngredientList(id);
        calculateServingSize(ingredients,servingSize);
        RecipeResponseDTO responseDTO = new RecipeResponseDTO(recipe,ingredients,reducedCo2);
        return CommonResponse.success(responseDTO);
    }

    public CommonResponse<Object> findRecipeList(){
        return CommonResponse.success(recipeRepository.findRecipeList());
    }


    private void calculateServingSize(List<Ingredient> ingredients,Double servingSize ){
        for(Ingredient ingredient : ingredients){
            double amount = ingredient.getAmount() * servingSize;
            amount = Math.round(amount * 10) / 10.0;
            ingredient.setAmount(amount);}
    }

}
