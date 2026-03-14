use std::io::{BufRead, BufReader, stdin};

fn main() {
    let mut br = BufReader::new(stdin());
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let n = split.next().unwrap().parse().unwrap();
    let q = split.next().unwrap().parse().unwrap();

    let mut fenwick_tree = FenwickTree::new(n);

    line.clear();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    for _ in 0..n {
        let ai = split.next().unwrap().parse().unwrap();

        fenwick_tree.add(ai, 1);
    }

    line.clear();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    for _ in 0..q {
        let ki: i32 = split.next().unwrap().parse().unwrap();

        if ki >= 1 {
            fenwick_tree.add(ki as usize, 1);
        } else {
            fenwick_tree.add(find_kth(n, &fenwick_tree, -ki), -1);
        }
    }

    println!(
        "{}",
        if fenwick_tree.compute_prefix_sum(n) == 0 {
            0
        } else {
            find_kth(n, &fenwick_tree, 1)
        }
    );
}

fn find_kth(n: usize, fenwick_tree: &FenwickTree, order: i32) -> usize {
    let mut result = usize::MAX;
    let mut lower = 1;
    let mut upper = n;
    while lower <= upper {
        let middle = (lower + upper) / 2;
        if fenwick_tree.compute_prefix_sum(middle) >= order {
            result = middle;
            upper = middle - 1;
        } else {
            lower = middle + 1;
        }
    }

    result
}

struct FenwickTree {
    a: Vec<i32>,
}

#[allow(dead_code)]
impl FenwickTree {
    fn new(size: usize) -> Self {
        Self {
            a: vec![0; size + 1],
        }
    }

    fn add(&mut self, mut pos: usize, delta: i32) {
        while pos < self.a.len() {
            self.a[pos] += delta;
            pos += ((pos as i32) & -(pos as i32)) as usize;
        }
    }

    fn compute_prefix_sum(&self, mut pos: usize) -> i32 {
        let mut result = 0;
        while pos != 0 {
            result += self.a[pos];
            pos -= ((pos as i32) & -(pos as i32)) as usize;
        }

        result
    }
}
