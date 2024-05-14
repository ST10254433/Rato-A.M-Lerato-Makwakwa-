using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace RecipeApp
{
    internal class Ingredient
    {
        // Define delegate for notifying when a recipe exceeds 300 calories
        public delegate void RecipeExceedsCaloriesHandler(string recipeName);
        // Public properties for the ingredient's name, quantity, and unit of measurement
        public string Name { get; set; } // The name of the ingredient
        public double Quantity { get; set; } // The quantity of the ingredient
        public string Unit { get; set; } // The unit of measurement for the ingredient
        public double Calories { get; set; } // The number of calories in the ingredient
        public string FoodGroup { get; set; } // The food group that the ingredient belongs to.
        public string ingredients { get; set; }

        // Constructor for the Ingredient class
        public Ingredient(string name, double quantity, string unit, double calories, string foodGroup)
        {
            // Assigning the provided name, quantity, and unit to the respective properties
            Name = name;
            Quantity = quantity;
            Unit = unit;
            Calories = calories;
            FoodGroup = foodGroup;
        }
    }
}

