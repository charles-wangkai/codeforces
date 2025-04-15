#![allow(non_snake_case)]

use std::{
    collections::HashSet,
    io::{stdin, BufRead, BufReader},
};

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let N = split.next().unwrap().parse().unwrap();
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let A0 = split.next().unwrap().parse().unwrap();
    let B0 = split.next().unwrap().parse().unwrap();

    println!("{}", solve(N, A0, B0));
}

fn solve(N: i32, A0: i32, B0: i32) -> String {
    let mut seen = HashSet::new();
    let mut a = A0 % N;
    let mut b = B0 % N;
    loop {
        let pair = Pair { a, b };
        if seen.contains(&pair) {
            break;
        }

        seen.insert(pair);

        a = (a + A0) % N;
        b = (b + B0) % N;
    }

    let mut pairs: Vec<_> = seen.iter().collect();
    pairs.sort_unstable_by_key(|pair| (pair.a, pair.b));

    format!(
        "{}\r\n{}",
        pairs.len(),
        pairs
            .iter()
            .map(|pair| format!("{} {}", pair.a, pair.b))
            .collect::<Vec<_>>()
            .join("\r\n")
    )
}

#[derive(Hash, PartialEq, Eq)]
struct Pair {
    a: i32,
    b: i32,
}
