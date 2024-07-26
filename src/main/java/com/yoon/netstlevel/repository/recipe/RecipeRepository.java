package com.yoon.netstlevel.repository.recipe;

import com.yoon.netstlevel.domain.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository  extends JpaRepository<Recipe,Long>, RecipeCustomRepository {
}
