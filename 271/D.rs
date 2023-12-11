use std::{
    collections::HashSet,
    io::{stdin, BufRead, BufReader},
};

const BASE_1: i64 = 31;
const BASE_2: i64 = 37;

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let s: String = split.next().unwrap().parse().unwrap();
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let goods: String = split.next().unwrap().parse().unwrap();
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let k = split.next().unwrap().parse().unwrap();

    println!("{}", solve(&s, &goods, k));
}

fn solve(s: &str, goods: &str, k: i32) -> i32 {
    let mut elements = HashSet::new();
    for i in 0..s.len() {
        let mut bad_count = 0;
        let mut hash1 = 0;
        let mut hash2 = 0;
        for j in i..s.len() {
            if goods.as_bytes()[(s.as_bytes()[j] - b'a') as usize] == b'0' {
                bad_count += 1;
                if bad_count == k + 1 {
                    break;
                }
            }

            hash1 = hash1 * BASE_1 + ((s.as_bytes()[j] - b'a' + 1) as i64);
            hash2 = hash2 * BASE_2 + ((s.as_bytes()[j] - b'a' + 1) as i64);

            elements.insert((hash1, hash2));
        }
    }

    elements.len() as i32
}
