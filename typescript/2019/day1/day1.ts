import { modulesMassList } from "./inputs";

/* Part One */

const sumOfFuelRequirements = modulesMassList
  .map((mass) => Math.floor(mass / 3) - 2)
  .reduce((total, current) => total + current);

console.log("Sum of fuel requirements: ", sumOfFuelRequirements);

/* Part Two */

const sumOfAllFuelRequirements = modulesMassList
  .map((mass) => {
    let fuelRequirements = 0;
    while (mass > 0) {
      mass = Math.floor(mass / 3) - 2;
      if (mass > 0) fuelRequirements += mass;
    }
    return fuelRequirements;
  })
  .reduce((total, current) => total + current);

console.log("Sum of all fuel requirements: ", sumOfAllFuelRequirements);
