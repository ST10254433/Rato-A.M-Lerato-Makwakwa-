using RecipeApp;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace RecipeApp
{
    internal class Steps
    {
        // Public properties for the step number and description
        public int Number { get; set; } // The number of the step (e.g., 1, 2, 3)
        public string Description { get; set; } // The description of the step (instructions)

        // Constructor for the Steps class
        public Steps(int number, string description)
        {
            // Assigning the provided number and description to the respective properties
            Number = number;
            Description = description;
        }
    }
}

