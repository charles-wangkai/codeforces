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
    let n = a.len() + 1;

    let mut adj_vecs = vec![Vec::new(); n];
    for i in 0..a.len() {
        adj_vecs[a[i] - 1].push(b[i] - 1);
        adj_vecs[b[i] - 1].push(a[i] - 1);
    }

    let mut parents = vec![0; n];
    let mut depths = vec![0; n];
    search(&mut parents, &mut depths, &adj_vecs, usize::MAX, 0, 0);

    let mut ancestors = vec![vec![None; (n.ilog2() as usize) + 1]; n];
    for i in 1..parents.len() {
        ancestors[i][0] = Some(parents[i]);
    }
    for j in 1..ancestors[0].len() {
        for i in 0..ancestors.len() {
            ancestors[i][j] = ancestors[i][j - 1].and_then(|a| ancestors[a][j - 1])
        }
    }

    let block_size = 1.max(n.isqrt());

    let mut result = Vec::new();
    let mut min_distances = vec![i32::MAX; n];
    let mut red_nodes = HashSet::new();
    let mut pending = Vec::new();
    pending.push(0);
    for i in 0..t.len() {
        if i % block_size == 0 {
            red_nodes.extend(&pending);
            pending.clear();

            build_min_distances(&mut min_distances, &adj_vecs, &red_nodes);
        }

        if t[i] == 1 {
            pending.push(v[i] - 1);
        } else {
            let mut min_distance = min_distances[v[i] - 1];
            for &node in &pending {
                min_distance =
                    min_distance.min(compute_distance(&depths, &ancestors, v[i] - 1, node));
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

fn build_min_distances(
    min_distances: &mut [i32],
    adj_vecs: &[Vec<usize>],
    red_nodes: &HashSet<usize>,
) {
    min_distances.fill(i32::MAX);

    let mut queue = VecDeque::new();
    for &red_node in red_nodes {
        min_distances[red_node] = 0;
        queue.push_back(red_node);
    }

    while let Some(head) = queue.pop_front() {
        for &adj in &adj_vecs[head] {
            if min_distances[adj] == i32::MAX {
                min_distances[adj] = min_distances[head] + 1;
                queue.push_back(adj);
            }
        }
    }
}

fn compute_distance(
    depths: &[i32],
    ancestors: &[Vec<Option<usize>>],
    node1: usize,
    node2: usize,
) -> i32 {
    depths[node1] + depths[node2] - depths[find_lca(&depths, &ancestors, node1, node2)] * 2
}

fn find_lca(depths: &[i32], ancestors: &[Vec<Option<usize>>], mut u: usize, mut v: usize) -> usize {
    if depths[u] < depths[v] {
        return find_lca(depths, ancestors, v, u);
    }

    let depth_diff = depths[u] - depths[v];
    for i in 0..ancestors[0].len() {
        if ((depth_diff >> i) & 1) == 1 {
            u = ancestors[u][i].unwrap();
        }
    }

    if u == v {
        return u;
    }

    for i in (0..ancestors[0].len()).rev() {
        if ancestors[u][i] != ancestors[v][i] {
            u = ancestors[u][i].unwrap();
            v = ancestors[v][i].unwrap();
        }
    }

    ancestors[u][0].unwrap()
}

fn search(
    parents: &mut [usize],
    depths: &mut [i32],
    adj_vecs: &[Vec<usize>],
    parent: usize,
    node: usize,
    depth: i32,
) {
    parents[node] = parent;
    depths[node] = depth;

    for &adj in &adj_vecs[node] {
        if adj != parent {
            search(parents, depths, adj_vecs, node, adj, depth + 1);
        }
    }
}
