package com.ermankurtay.assignment9.controller;

import com.ermankurtay.assignment9.service.FileService;
import com.ermankurtay.assignment9.repository.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() throws IOException {
        List<Recipe> allRecipes = fileService.readFile("recipe.txt");

        return allRecipes.stream()
                .filter(Recipe::getGlutenFree)
                .collect(Collectors.toList());
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() throws IOException {
        List<Recipe> allRecipes = fileService.readFile("recipe.txt");

        return allRecipes.stream()
                .filter(Recipe::getVegan)
                .collect(Collectors.toList());
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() throws IOException {
        List<Recipe> allRecipes = fileService.readFile("recipe.txt");

        return allRecipes.stream()
                .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() throws IOException {
        List<Recipe> allRecipes = fileService.readFile("recipe.txt");

        return allRecipes.stream()
                .filter(Recipe::getVegetarian)
                .collect(Collectors.toList());
    }

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() throws IOException {
        return fileService.readFile("recipe.txt");
    }
}
