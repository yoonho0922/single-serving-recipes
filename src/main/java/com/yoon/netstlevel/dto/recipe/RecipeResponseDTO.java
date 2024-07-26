package com.yoon.netstlevel.dto.recipe;

import com.yoon.netstlevel.domain.recipe.Ingredient;
import com.yoon.netstlevel.domain.recipe.Recipe;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeResponseDTO {
    private Recipe recipe;
    private List<Ingredient> ingredients;
    private Integer reducedCo2;

}
