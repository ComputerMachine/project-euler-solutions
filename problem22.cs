using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem22
{
    class Program
    {
        static int NameScore(string name)
        {
            string alphabet = "abcdefghijklmnopqrstuvwxyz";
            int score = 0;

            foreach (char letter in name.ToLower())
            {
                int letterScore = alphabet.IndexOf(letter) + 1; // Compensate for the index starting at zero
                score += letterScore;
            }

            return score;
        }

        static void Main(string[] args)
        {
            string path = @"Z:\Users\Galileo\Desktop\p022_names.txt";
            string data = File.ReadAllText(path);

            // Split the string into an array, removing quotation marks and commas
            List<string> names = data.Split(new string[] { "\",\"" }, StringSplitOptions.None).ToList();

            // Remove the quotation mark in the first element that didn't follow the rules of the Split
            names[0] = names[0].TrimStart('"');

            // Sort the list alphabetically
            names.Sort();

            int score = 0;

            for (int i = 0; i < names.Count; i++)
            {
                int name = NameScore(names[i]);
                int namePosition = i + 1; // Compensate for i starting at zero

                score += name * namePosition;
            }

            Console.WriteLine("The total value of all the name scores in the text file is: " + score);
        }
    }
}
