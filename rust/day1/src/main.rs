use std::{
    fs::File,
    io::{prelude::*, BufReader},
    path::Path,
};

fn split_file_into_lines(filename: impl AsRef<Path>) -> Vec<String> {
    let file = File::open(filename).expect("Error opening file");
    let buf = BufReader::new(file);
    buf.lines()
        .map(|l| l.expect("Could not parse line"))
        .collect()
}

// Part One

fn sum_of_fuel_requirements(fuel_requirements: &Vec<String>) -> i32 {
    let mut total_fuel = 0;
    for line in fuel_requirements {
        let mass: i32 = line.parse().unwrap();
        total_fuel += mass / 3 - 2;
    }
    total_fuel
}

// Part Two

fn total_sum_of_fuel_requirements(fuel_requirements: &Vec<String>) -> i32 {
    let mut total_fuel = 0;
    for line in fuel_requirements {
        let mut mass: i32 = line.parse().unwrap();
        loop {
            mass = mass / 3 - 2;
            if mass <= 0 {
                break;
            }
            total_fuel += mass;
        }
    }
    total_fuel
}

fn main() {
    let fuel_requirements = split_file_into_lines("src/input.txt");

    let fuel_sum = sum_of_fuel_requirements(&fuel_requirements);
    println!("Fuel requirement: {}", fuel_sum);

    let total_fuel_sum = total_sum_of_fuel_requirements(&fuel_requirements);
    println!("Total fuel requirement: {}", total_fuel_sum);
}
