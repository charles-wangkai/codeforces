// https://blog.csdn.net/just_sort/article/details/69625818

use std::{
    collections::HashMap,
    io::{BufRead, BufReader, stdin},
};

const BASE: i32 = 31;
const MODULUS: i32 = 1_000_000_007;
const STATE_LENGTH_LIMIT: usize = 10;

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let n = split.next().unwrap().parse().unwrap();
    let mut genomes = Vec::new();
    for _ in 0..n {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        genomes.push(split.next().unwrap().parse().unwrap());
    }
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let m = split.next().unwrap().parse().unwrap();
    let mut prefixes = Vec::new();
    let mut suffixes = Vec::new();
    for _ in 0..m {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        prefixes.push(split.next().unwrap().parse().unwrap());
        suffixes.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(&genomes, &prefixes, &suffixes));
}

fn solve(genomes: &[String], prefixes: &[String], suffixes: &[String]) -> String {
    let mut prefix_hashes: Vec<_> = (0..genomes.len())
        .map(|i| vec![0; genomes[i].len()])
        .collect();
    let mut suffix_hashes: Vec<_> = (0..genomes.len())
        .map(|i| vec![0; genomes[i].len()])
        .collect();
    let mut state_to_count = HashMap::new();
    let mut large_indices = Vec::new();
    for i in 0..genomes.len() {
        for j in 0..prefix_hashes[i].len() {
            prefix_hashes[i][j] = add_mod(
                multiply_mod(if j == 0 { 0 } else { prefix_hashes[i][j - 1] }, BASE),
                (genomes[i].as_bytes()[j] - b'a') as i32,
            );
        }

        for j in (0..suffix_hashes[i].len()).rev() {
            suffix_hashes[i][j] = add_mod(
                multiply_mod(
                    if j == suffix_hashes[i].len() - 1 {
                        0
                    } else {
                        suffix_hashes[i][j + 1]
                    },
                    BASE,
                ),
                (genomes[i].as_bytes()[j] - b'a') as i32,
            );
        }

        for prefix_length in 1..=genomes[i].len().min(STATE_LENGTH_LIMIT) {
            for suffix_length in 1..=genomes[i].len().min(STATE_LENGTH_LIMIT) {
                let state = build_state(
                    prefix_length,
                    prefix_hashes[i][prefix_length - 1],
                    suffix_length,
                    suffix_hashes[i][suffix_hashes[i].len() - suffix_length],
                );

                state_to_count
                    .entry(state)
                    .and_modify(|count| *count += 1)
                    .or_insert(1);
            }
        }

        if genomes[i].len() > STATE_LENGTH_LIMIT {
            large_indices.push(i);
        }
    }

    (0..prefixes.len())
        .map(|i| {
            let mut prefix_hash = 0;
            for j in 0..prefixes[i].len() {
                prefix_hash = add_mod(
                    multiply_mod(prefix_hash, BASE),
                    (prefixes[i].as_bytes()[j] - b'a') as i32,
                );
            }

            let mut suffix_hash = 0;
            for j in (0..suffixes[i].len()).rev() {
                suffix_hash = add_mod(
                    multiply_mod(suffix_hash, BASE),
                    (suffixes[i].as_bytes()[j] - b'a') as i32,
                );
            }

            let max_side_length = prefixes[i].len().max(suffixes[i].len());

            if max_side_length <= STATE_LENGTH_LIMIT {
                state_to_count
                    .get(&build_state(
                        prefixes[i].len(),
                        prefix_hash,
                        suffixes[i].len(),
                        suffix_hash,
                    ))
                    .copied()
                    .unwrap_or(0)
            } else {
                large_indices
                    .iter()
                    .filter(|&&index| {
                        genomes[index].len() >= max_side_length
                            && prefix_hashes[index][prefixes[i].len() - 1] == prefix_hash
                            && suffix_hashes[index][suffix_hashes[index].len() - suffixes[i].len()]
                                == suffix_hash
                    })
                    .count()
            }
        })
        .map(|x| x.to_string())
        .collect::<Vec<_>>()
        .join("\n")
}

fn build_state(
    prefix_length: usize,
    prefix_hash: i32,
    suffix_length: usize,
    suffix_hash: i32,
) -> String {
    format!(
        "{},{},{},{}",
        prefix_length, prefix_hash, suffix_length, suffix_hash
    )
}

fn add_mod(x: i32, y: i32) -> i32 {
    (x + y).rem_euclid(MODULUS)
}

fn multiply_mod(x: i32, y: i32) -> i32 {
    ((x as i64) * (y as i64)).rem_euclid(MODULUS as i64) as i32
}
