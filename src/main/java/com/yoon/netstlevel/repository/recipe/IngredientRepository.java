package com.yoon.netstlevel.repository.recipe;

import com.yoon.netstlevel.domain.recipe.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>,IngredientCustomRepository {
}
