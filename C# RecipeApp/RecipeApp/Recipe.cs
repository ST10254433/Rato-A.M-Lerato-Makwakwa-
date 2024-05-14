using RecipeApp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using static RecipeApp.Ingredient;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace RecipeApp
{
    internal class Recipe
    {
        // Public properties for the recipe's name, list of ingredients, and list of steps
        public string Name { get; set; } // The name of the recipe
        public List<Ingredient> Ingredients { get; set; } // List of ingredients in the recipe
        public List<string> Steps { get; set; } // List of steps (instructions) in the recipe

        // Event for notifying when a recipe exceeds 300 calories
        public event RecipeExceedsCaloriesHandler RecipeExceedsCalories;

        // Constructor
        public Recipe(string name)
        {
            Name = name;
            Ingredients = new List<Ingredient>();
            Steps = new List<string>();
        }

        // Method to add an ingredient to the recipe
        public void AddIngredient(Ingredient ingredient)
        {
            Ingredients.Add(ingredient);
        }

        // Method to add a step to the recipe
        public void AddStep(string step)
        {
            Steps.Add(step);
        }

        // Method to calculate total calories of the recipe

        public double CalculateTotalCalories()
        {
            double totalCalories = 0;
            foreach (var ingredient in Ingredients)
            {
                totalCalories += ingredient.Calories * ingredient.Quantity;
            }
            return totalCalories;
        }

        // Method to check if recipe exceeds 300 calories and raise event if so
        public void CheckCalories()
        {
            if (CalculateTotalCalories() > 300)
            {
                RecipeExceedsCalories?.Invoke(Name);
            }
        }

        // Constructor to initialize a Recipe object with specified number of ingredients and steps
        public Recipe(string name, int numIngredients, int numSteps)
        {
            // Create arrays for ingredients and steps with the specified sizes
            Name = name;
            Ingredients = new List<Ingredient>();
            Steps = new List<string>();
        }

        // Method to add an ingredient to the recipe at the specified index
        public void AddIngredient(int index, Ingredient ingredient)
        {
            Ingredients[index] = ingredient;
        }

        // Method to add a step (instruction) to the recipe at the specified index
        public void AddStep(int index, string step)
        {
            Steps[index] = step;
        }

        // Method to reset quantities of all ingredients to their original values
        public void ResetQuantities()
        {
            // Assuming the Ingredient class keeps track of original quantities
            // This method would reset the quantities of all ingredients to their original values
            // Implementation should be added based on the specific requirements
        }

        // Method to scale the recipe's ingredient quantities by a specified factor
        public void ScaleRecipe(double factor)
        {
            // Iterate over each ingredient in the recipe
            foreach (var ingredient in Ingredients)
            {
                // Scale the quantity of the ingredient by the provided factor
                ingredient.Quantity *= factor;
            }
        }
    }
}





