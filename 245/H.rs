use std::io::{BufRead, BufReader, stdin};

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let s: String = split.next().unwrap().parse().unwrap();
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let q = split.next().unwrap().parse().unwrap();
    let mut l = Vec::new();
    let mut r = Vec::new();
    for _ in 0..q {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        l.push(split.next().unwrap().parse().unwrap());
        r.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(&s, &l, &r));
}

fn solve(s: &str, l: &[usize], r: &[usize]) -> String {
    let n = s.len();

    let mut palindromes = vec![vec![false; n]; n];
    let mut fenwick_tree = FenwickTree::new(n);
    for i in 0..n {
        for offset in 0..=1 {
            let mut begin_index = i;
            let mut end_index = i + offset;
            while end_index < n && s.as_bytes()[begin_index] == s.as_bytes()[end_index] {
                palindromes[begin_index][end_index] = true;
                fenwick_tree.add(end_index + 1, 1);

                if begin_index == 0 {
                    break;
                }
                begin_index -= 1;

                end_index += 1;
            }
        }
    }

    let mut sorted_query_indices: Vec<_> = (0..l.len()).collect();
    sorted_query_indices.sort_by_key(|&i| l[i]);

    let mut result = vec![0; sorted_query_indices.len()];
    let mut begin_index = 0;
    for query_index in sorted_query_indices {
        while begin_index + 1 < l[query_index] {
            for end_index in begin_index..n {
                if palindromes[begin_index][end_index] {
                    fenwick_tree.add(end_index + 1, -1);
                }
            }

            begin_index += 1;
        }

        result[query_index] = fenwick_tree.compute_prefix_sum(r[query_index]);
    }

    result
        .iter()
        .map(|x| x.to_string())
        .collect::<Vec<_>>()
        .join("\n")
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
