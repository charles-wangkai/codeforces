use std::{
    collections::{HashMap, HashSet},
    io::{BufRead, BufReader, stdin},
    iter::FromIterator,
};

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let n: i32 = split.next().unwrap().parse().unwrap();
    let mut a = Vec::new();
    let mut b = Vec::new();
    for _ in 0..n - 1 {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        a.push(split.next().unwrap().parse().unwrap());
        b.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(&a, &b));
}

fn solve(a: &[usize], b: &[usize]) -> String {
    let n = a.len() + 1;

    let mut adj_sets = vec![HashSet::new(); n];
    for i in 0..a.len() {
        adj_sets[a[i] - 1].insert(b[i] - 1);
        adj_sets[b[i] - 1].insert(a[i] - 1);
    }

    let mut ranks = vec![0; n];
    assign(&mut ranks, &mut adj_sets, 0, 0);

    if ranks.iter().any(|&rank| rank >= 26) {
        return "Impossible!".to_string();
    }

    ranks
        .iter()
        .map(|&rank| ((rank as u8) + ('A' as u8)) as char)
        .map(|x| x.to_string())
        .collect::<Vec<_>>()
        .join(" ")
}

fn assign(ranks: &mut [i32], adj_sets: &mut [HashSet<usize>], node: usize, rank: i32) {
    let mut nodes = HashSet::new();
    search(&mut nodes, adj_sets, node);

    let center = find_center(adj_sets, &nodes);

    ranks[center] = rank;

    for adj in adj_sets[center].clone() {
        adj_sets[adj].remove(&center);
        assign(ranks, adj_sets, adj, rank + 1);
    }
}

fn search(nodes: &mut HashSet<usize>, adj_sets: &[HashSet<usize>], node: usize) {
    if !nodes.contains(&node) {
        nodes.insert(node);

        for &adj in &adj_sets[node] {
            search(nodes, adj_sets, adj);
        }
    }
}

fn find_center(adj_sets: &[HashSet<usize>], nodes: &HashSet<usize>) -> usize {
    let mut node_to_degree: HashMap<_, _> =
        HashMap::from_iter(nodes.iter().map(|&node| (node, adj_sets[node].len())));
    let mut removed = HashSet::new();

    let mut leaves: Vec<_> = node_to_degree
        .keys()
        .filter(|node| node_to_degree[node] == 1)
        .copied()
        .collect();
    let mut rest = nodes.len();
    while rest > 2 {
        let mut next_leaves = Vec::new();
        for leaf in leaves {
            rest -= 1;
            removed.insert(leaf);

            for &adj in &adj_sets[leaf] {
                if !removed.contains(&adj) {
                    *node_to_degree.get_mut(&adj).unwrap() -= 1;

                    if node_to_degree[&adj] == 1 {
                        next_leaves.push(adj);
                    }
                }
            }
        }

        leaves = next_leaves;
    }

    nodes
        .iter()
        .find(|node| !removed.contains(node))
        .copied()
        .unwrap()
}
