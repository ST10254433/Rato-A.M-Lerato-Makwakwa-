using System.Collections.Generic;
using System.Numerics;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace RecipeApp
{
    internal class Program
    {

        public delegate void RecipeCaloriesExceededHandler(string recipeName, double totalCalories);

        static void Main(string[] args)
        {
            // Initialize a new User object
            User user = new User();

            // Prompt for user details and capture them
            Console.WriteLine("Enter User Details:");
            Console.Write("Name: ");
            user.Name = Console.ReadLine(); // Get the user's first name
            Console.Write("Surname: ");
            user.Surname = Console.ReadLine(); // Get the user's surname

            // Collection to store all recipes
            List<Recipe> recipes = new List<Recipe>();

            // Flag to control entering recipes
            bool EnterRecipe = true;

            while (EnterRecipe)
            {
                // Prompt for recipe name
                Console.WriteLine("\nEnter Recipe Name:");
                Console.Write("Name: ");
                string recipeName = Console.ReadLine();

                // Create a new Recipe object
                Recipe recipe = new Recipe(recipeName);

                // Collection to store ingredients for the current recipe
                List<Ingredient> ingredients = new List<Ingredient>();

                // Flag to control entering ingredients
                bool EnterIngredients = true;

                while (EnterIngredients)
                {
                    Console.WriteLine($"Enter details for Ingredient {ingredients.Count + 1}:");
                    Console.Write("Name: ");
                    string name = Console.ReadLine();
                    Console.Write("Quantity: ");
                    double quantity = Convert.ToDouble(Console.ReadLine());
                    Console.Write("Unit of Measurement: ");
                    string unit = Console.ReadLine();
                    Console.Write("Calories: ");
                    int calories = Convert.ToInt32(Console.ReadLine());
                    Console.Write("Food Group: ");
                    string foodGroup = Console.ReadLine();

                    // Create and add Ingredient to the current recipe
                    Ingredient ingredient = new Ingredient(name, quantity, unit, calories, foodGroup);
                    ingredients.Add(ingredient);

                    Console.Write("Do you want to add another ingredient? (y/n): ");
                    char choice = Console.ReadLine().ToLower()[0];
                    EnterIngredients = (choice == 'y');
                }

                // Add ingredients to the recipe
                foreach (var ingredient in ingredients)
                {
                    recipe.AddIngredient(ingredient);
                }

                // Prompt for steps
                Console.WriteLine("\nEnter Steps for Recipe:");
                bool continueEnteringSteps = true;
                while (continueEnteringSteps)
                {
                    Console.WriteLine($"Enter description for Step {recipe.Steps.Count + 1}:");
                    string description = Console.ReadLine();
                    recipe.AddStep(description);

                    Console.Write("Do you want to add another step? (y/n): ");
                    char choice = Console.ReadLine().ToLower()[0];
                    continueEnteringSteps = (choice == 'y');
                }

                // Add recipe to the collection
                recipes.Add(recipe);

                // Check if the total calories of the recipe exceed 300
                recipe.RecipeExceedsCalories += NotifyRecipeExceedsCalories;
                recipe.CheckCalories();

                Console.Write("Do you want to add another recipe? (y/n): ");
                char continueChoice = Console.ReadLine().ToLower()[0];
                EnterRecipe = (continueChoice == 'y');
            }

            // Display all recipes in alphabetical order by name
            Console.WriteLine("\nAll Recipes:");
            recipes.Sort((x, y) => x.Name.CompareTo(y.Name));
            foreach (var recipe in recipes)
            {
                Console.WriteLine(recipe.Name);
            }

            // Prompt to choose a recipe to display details
            Console.Write("\nEnter the name of the recipe to display details: ");
            string chosenRecipeName = Console.ReadLine();
            Recipe chosenRecipe = recipes.Find(r => r.Name.Equals(chosenRecipeName, StringComparison.OrdinalIgnoreCase));
            if (chosenRecipe != null)
            {
                // Display details of the chosen recipe
                Console.WriteLine($"\nDetails of Recipe '{chosenRecipe.Name}':");
                Console.WriteLine($"Total Calories: {chosenRecipe.CalculateTotalCalories()}");
                Console.WriteLine("\nIngredients:");
                foreach (var ingredient in chosenRecipe.Ingredients)
                {
                    Console.WriteLine($"{ingredient.Name}: {ingredient.Quantity} {ingredient.Unit}");
                }
                Console.WriteLine("\nSteps:");
                foreach (var step in chosenRecipe.Steps)
                {
                    Console.WriteLine(step);
                }
            }
            else
            {
                Console.WriteLine("Recipe not found.");
            }
        }

        // Delegate method to notify when a recipe exceeds 300 calories
        static void NotifyRecipeExceedsCalories(string recipeName)
        {
            Console.WriteLine($"Warning: Recipe '{recipeName}' exceeds 300 calories.");
        }
    }
}






