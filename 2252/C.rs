use std::{
    cmp::Reverse,
    collections::BinaryHeap,
    io::{BufRead, BufReader, stdin},
};

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let t = split.next().unwrap().parse().unwrap();
    for _ in 0..t {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        let n = split.next().unwrap().parse().unwrap();
        let m = split.next().unwrap().parse().unwrap();
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        let mut v = Vec::new();
        for _ in 0..n {
            v.push(split.next().unwrap().parse().unwrap());
        }
        let mut a = vec![Vec::new(); n];
        for r in 0..n {
            let mut line = String::new();
            br.read_line(&mut line).unwrap();
            let mut split = line.split_whitespace();
            for _ in 0..m {
                a[r].push(split.next().unwrap().parse().unwrap());
            }
        }

        println!("{}", solve(&a, &v));
    }
}

fn solve(a: &[Vec<i32>], v: &[i32]) -> usize {
    let m = a[0].len();

    let mut result = m;
    let mut lower = 1;
    let mut upper = m - 1;
    while lower <= upper {
        let middle = (lower + upper) / 2;
        if check(a, v, middle) {
            result = middle;
            upper = middle - 1;
        } else {
            lower = middle + 1;
        }
    }

    result
}

fn check(a: &[Vec<i32>], v: &[i32], removed_num: usize) -> bool {
    let n = a.len();
    let m = a[0].len();

    let mut pq = BinaryHeap::new();
    let mut chosen_sum = 0i64;

    for r in (0..n).rev() {
        for c in 0..m {
            pq.push(Reverse(a[r][c]));
            chosen_sum += a[r][c] as i64;

            if pq.len() == removed_num + 1 {
                chosen_sum -= pq.pop().unwrap().0 as i64;
            }
        }

        if chosen_sum >= v[r] as i64 {
            return true;
        }
    }

    false
}
