package com.yoon.netstlevel.repository.recipe;

import com.yoon.netstlevel.domain.recipe.Ingredient;

import java.util.List;

public interface IngredientCustomRepository {
    List<Ingredient> findIngredientList(Long id);
}
