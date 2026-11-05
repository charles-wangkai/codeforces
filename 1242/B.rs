use std::{
    collections::{HashSet, VecDeque},
    io::{BufRead, BufReader, stdin},
};

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let n = split.next().unwrap().parse().unwrap();
    let m = split.next().unwrap().parse().unwrap();
    let mut a = Vec::new();
    let mut b = Vec::new();
    for _ in 0..m {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        a.push(split.next().unwrap().parse().unwrap());
        b.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(n, &a, &b));
}

fn solve(n: usize, a: &[usize], b: &[usize]) -> i32 {
    let one_weight_edges: HashSet<_> = (0..a.len())
        .flat_map(|i| {
            [
                Edge {
                    node1: a[i] - 1,
                    node2: b[i] - 1,
                },
                Edge {
                    node1: b[i] - 1,
                    node2: a[i] - 1,
                },
            ]
        })
        .collect();

    let mut result = -1;
    let mut queue = VecDeque::new();
    let mut rests: HashSet<_> = (0..n).collect();
    while !queue.is_empty() || !rests.is_empty() {
        if queue.is_empty() {
            let rest = rests.iter().next().copied().unwrap();
            rests.remove(&rest);
            queue.push_back(rest);

            result += 1;
        } else {
            let head = queue.pop_front().unwrap();

            for rest in rests.iter().copied().collect::<Vec<_>>() {
                if !one_weight_edges.contains(&Edge {
                    node1: head,
                    node2: rest,
                }) {
                    rests.remove(&rest);
                    queue.push_back(rest);
                }
            }
        }
    }

    result
}

#[derive(Hash, Eq, PartialEq)]
struct Edge {
    node1: usize,
    node2: usize,
}
