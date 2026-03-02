// https://codeforces.com/blog/entry/8800

use std::{
    collections::{HashSet, VecDeque},
    io::{BufRead, BufReader, stdin},
};

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let n: i32 = split.next().unwrap().parse().unwrap();
    let m = split.next().unwrap().parse().unwrap();
    let mut a = Vec::new();
    let mut b = Vec::new();
    for _ in 0..n - 1 {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        a.push(split.next().unwrap().parse().unwrap());
        b.push(split.next().unwrap().parse().unwrap());
    }
    let mut t = Vec::new();
    let mut v = Vec::new();
    for _ in 0..m {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        t.push(split.next().unwrap().parse().unwrap());
        v.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(&a, &b, &t, &v));
}

fn solve(a: &[usize], b: &[usize], t: &[i32], v: &[usize]) -> String {
    let tree = Tree::new(
        &a.iter().map(|ai| ai - 1).collect::<Vec<_>>(),
        &b.iter().map(|bi| bi - 1).collect::<Vec<_>>(),
    );

    let block_size = 1.max(tree.n.isqrt());

    let mut result = Vec::new();
    let mut min_distances = vec![i32::MAX; tree.n];
    let mut red_nodes = HashSet::new();
    let mut pending = Vec::new();
    pending.push(0);
    for i in 0..t.len() {
        if i % block_size == 0 {
            red_nodes.extend(&pending);
            pending.clear();

            build_min_distances(&mut min_distances, &tree, &red_nodes);
        }

        if t[i] == 1 {
            pending.push(v[i] - 1);
        } else {
            let mut min_distance = min_distances[v[i] - 1];
            for &node in &pending {
                min_distance = min_distance.min(tree.compute_distance(v[i] - 1, node));
            }

            result.push(min_distance);
        }
    }

    result
        .iter()
        .map(|x| x.to_string())
        .collect::<Vec<_>>()
        .join("\n")
}

fn build_min_distances(min_distances: &mut [i32], tree: &Tree, red_nodes: &HashSet<usize>) {
    min_distances.fill(i32::MAX);

    let mut queue = VecDeque::new();
    for &red_node in red_nodes {
        min_distances[red_node] = 0;
        queue.push_back(red_node);
    }

    while let Some(head) = queue.pop_front() {
        for &adj in &tree.adj_vecs[head] {
            if min_distances[adj] == i32::MAX {
                min_distances[adj] = min_distances[head] + 1;
                queue.push_back(adj);
            }
        }
    }
}

#[allow(dead_code)]
struct Tree {
    n: usize,
    u: Vec<usize>,
    v: Vec<usize>,
    adj_vecs: Vec<Vec<usize>>,
    depths: Vec<i32>,
    ancestors: Vec<Vec<usize>>,
}

#[allow(dead_code)]
impl Tree {
    fn new(u: &[usize], v: &[usize]) -> Self {
        let n = u.len() + 1;

        let mut adj_vecs = vec![Vec::new(); n];
        for i in 0..u.len() {
            adj_vecs[u[i]].push(v[i]);
            adj_vecs[v[i]].push(u[i]);
        }

        let mut tree = Self {
            n,
            u: u.to_vec(),
            v: v.to_vec(),
            adj_vecs,
            depths: vec![0; n],
            ancestors: vec![vec![usize::MAX; (n.ilog2() as usize) + 1]; n],
        };
        tree.init_iterative();

        tree
    }

    fn init_iterative(&mut self) {
        let mut stack = vec![(0, usize::MAX, 0)];

        while let Some((node, parent, depth)) = stack.pop() {
            self.depths[node] = depth;
            self.ancestors[node][0] = parent;

            for i in 1..self.ancestors[node].len() {
                if self.ancestors[node][i - 1] != usize::MAX {
                    self.ancestors[node][i] = self.ancestors[self.ancestors[node][i - 1]][i - 1];
                }
            }

            for &adj in &self.adj_vecs[node] {
                if adj != parent {
                    stack.push((adj, node, depth + 1));
                }
            }
        }
    }

    fn find_lca(&self, mut node1: usize, mut node2: usize) -> usize {
        if self.depths[node1] < self.depths[node2] {
            return self.find_lca(node2, node1);
        }

        for i in (0..self.ancestors[node1].len()).rev() {
            if self.ancestors[node1][i] != usize::MAX {
                if self.depths[self.ancestors[node1][i]] >= self.depths[node2] {
                    node1 = self.ancestors[node1][i];
                }
            }
        }

        if node1 == node2 {
            return node1;
        }

        for i in (0..self.ancestors[0].len()).rev() {
            if self.ancestors[node1][i] != self.ancestors[node2][i] {
                node1 = self.ancestors[node1][i];
                node2 = self.ancestors[node2][i];
            }
        }

        self.ancestors[node1][0]
    }

    fn compute_distance(&self, node1: usize, node2: usize) -> i32 {
        self.depths[node1] + self.depths[node2] - self.depths[self.find_lca(node1, node2)] * 2
    }
}
