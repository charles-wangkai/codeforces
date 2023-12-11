#![allow(non_snake_case)]

use std::{
    collections::HashMap,
    io::{stdin, BufRead, BufReader},
};

const MAX_N: usize = 10_000_000;

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let N = split.next().unwrap().parse().unwrap();
    let K = split.next().unwrap().parse().unwrap();
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let mut s = Vec::new();
    for _ in 0..K {
        s.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(N, &s));
}

fn solve(N: usize, s: &[usize]) -> String {
    let mut is_non_selfs = [0u128; MAX_N / 128 + 1];
    for i in 1..=N {
        let non_self = i + (compute_digit_sum(i as i32) as usize);
        if non_self <= N {
            is_non_selfs[non_self / 128] |= 1u128 << (non_self % 128);
        }
    }

    let mut pos_to_value = HashMap::new();
    for &si in s {
        pos_to_value.insert(si, 0);
    }

    let mut pos = 0;
    for i in 1..=N {
        if ((is_non_selfs[i / 128] >> (i % 128)) & 1) == 0 {
            pos += 1;
            if pos_to_value.contains_key(&pos) {
                pos_to_value.insert(pos, i);
            }
        }
    }

    format!(
        "{}\n{}",
        pos,
        s.iter()
            .map(|si| pos_to_value[si])
            .map(|x| x.to_string())
            .collect::<Vec<_>>()
            .join(" ")
    )
}

fn compute_digit_sum(mut x: i32) -> i32 {
    let mut result = 0;
    while x != 0 {
        result += x % 10;
        x /= 10;
    }

    result
}
