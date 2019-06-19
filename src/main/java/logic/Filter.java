package logic;

import domain.Ingredient;

public interface Filter {
    boolean isSatisfy(Ingredient ingredient);
}