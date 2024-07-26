package com.yoon.netstlevel.repository.recipe;

import com.yoon.netstlevel.domain.recipe.Recipe;

import java.util.List;

public interface RecipeCustomRepository {
    Recipe findRecipe(Long id);

    List<Recipe> findRecipeList();
}
