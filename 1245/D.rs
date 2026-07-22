use std::collections::HashMap;
use std::io::{BufRead, BufReader, stdin};

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let n = split.next().unwrap().parse().unwrap();
    let mut x = Vec::new();
    let mut y = Vec::new();
    for _ in 0..n {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        x.push(split.next().unwrap().parse().unwrap());
        y.push(split.next().unwrap().parse().unwrap());
    }
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let mut c = Vec::new();
    for _ in 0..n {
        c.push(split.next().unwrap().parse().unwrap());
    }
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let mut k = Vec::new();
    for _ in 0..n {
        k.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(&x, &y, &c, &k));
}

fn solve(x: &[i32], y: &[i32], c: &[i32], k: &[i32]) -> String {
    let n = x.len();

    let mut edges = Vec::new();
    for i in 0..c.len() {
        edges.push(Edge {
            node1: 0,
            node2: i + 1,
            distance: c[i] as i64,
        });
    }
    for i in 0..n {
        for j in i + 1..n {
            edges.push(Edge {
                node1: i + 1,
                node2: j + 1,
                distance: ((k[i] + k[j]) as i64)
                    * (((x[i] - x[j]).abs() + (y[i] - y[j]).abs()) as i64),
            });
        }
    }
    edges.sort_unstable_by_key(|edge| edge.distance);

    let mut dsu = Dsu::new(n + 1);
    let mut chosen = Vec::new();
    for edge in edges {
        let leader1 = dsu.find(edge.node1);
        let leader2 = dsu.find(edge.node2);
        if leader2 != leader1 {
            dsu.union(leader1, leader2);
            chosen.push(edge);
        }
    }

    let stations = chosen
        .iter()
        .filter(|edge| edge.node1 == 0)
        .map(|edge| edge.node2)
        .collect::<Vec<_>>();
    let connections = chosen
        .iter()
        .filter(|edge| edge.node1 != 0)
        .collect::<Vec<_>>();

    format!(
        "{}\n{}\n{}\n{}\n{}",
        chosen.iter().map(|edge| edge.distance).sum::<i64>(),
        stations.len(),
        stations
            .iter()
            .map(|x| x.to_string())
            .collect::<Vec<_>>()
            .join(" "),
        connections.len(),
        connections
            .iter()
            .map(|connection| format!("{} {}", connection.node1, connection.node2))
            .collect::<Vec<_>>()
            .join("\n")
    )
}

struct Edge {
    node1: usize,
    node2: usize,
    distance: i64,
}

struct Dsu {
    parent_or_sizes: Vec<i32>,
}

#[allow(dead_code)]
impl Dsu {
    fn new(n: usize) -> Self {
        Self {
            parent_or_sizes: vec![-1; n],
        }
    }

    fn find(&mut self, a: usize) -> usize {
        if self.parent_or_sizes[a] < 0 {
            return a;
        }

        self.parent_or_sizes[a] = self.find(self.parent_or_sizes[a] as usize) as i32;

        self.parent_or_sizes[a] as usize
    }

    fn union(&mut self, a: usize, b: usize) {
        let a_leader = self.find(a);
        let b_leader = self.find(b);
        if a_leader != b_leader {
            self.parent_or_sizes[a_leader] += self.parent_or_sizes[b_leader];
            self.parent_or_sizes[b_leader] = a_leader as i32;
        }
    }

    fn get_size(&mut self, a: usize) -> usize {
        let leader = self.find(a);

        -self.parent_or_sizes[leader] as usize
    }

    fn build_leader_to_group(&mut self) -> HashMap<usize, Vec<usize>> {
        let mut leader_to_group = HashMap::new();
        for i in 0..self.parent_or_sizes.len() {
            leader_to_group
                .entry(self.find(i))
                .or_insert(Vec::new())
                .push(i);
        }

        leader_to_group
    }
}
