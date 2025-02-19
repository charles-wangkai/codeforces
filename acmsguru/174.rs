#![allow(non_snake_case)]

use std::{
    collections::HashMap,
    io::{stdin, BufRead, BufReader},
};

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let M = split.next().unwrap().parse().unwrap();
    let mut x1 = Vec::new();
    let mut y1 = Vec::new();
    let mut x2 = Vec::new();
    let mut y2 = Vec::new();
    for _ in 0..M {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        x1.push(split.next().unwrap().parse().unwrap());
        y1.push(split.next().unwrap().parse().unwrap());
        x2.push(split.next().unwrap().parse().unwrap());
        y2.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(&x1, &y1, &x2, &y2));
}

fn solve(x1: &[i32], y1: &[i32], x2: &[i32], y2: &[i32]) -> usize {
    let mut point_to_index = HashMap::new();
    for i in 0..x1.len() {
        let point = Point { x: x1[i], y: y1[i] };
        if !point_to_index.contains_key(&point) {
            point_to_index.insert(point, point_to_index.len());
        }

        let point = Point { x: x2[i], y: y2[i] };
        if !point_to_index.contains_key(&point) {
            point_to_index.insert(point, point_to_index.len());
        }
    }

    let mut parents = vec![usize::MAX; point_to_index.len()];
    for i in 0..x1.len() {
        let root1 = find_root(
            &mut parents,
            point_to_index
                .get(&Point { x: x1[i], y: y1[i] })
                .copied()
                .unwrap(),
        );
        let root2 = find_root(
            &mut parents,
            point_to_index
                .get(&Point { x: x2[i], y: y2[i] })
                .copied()
                .unwrap(),
        );
        if root2 == root1 {
            return i + 1;
        }

        parents[root2] = root1;
    }

    0
}

fn find_root(parents: &mut [usize], node: usize) -> usize {
    if parents[node] == usize::MAX {
        return node;
    }

    parents[node] = find_root(parents, parents[node]);

    parents[node]
}

#[derive(Hash, PartialEq, Eq, Debug)]
struct Point {
    x: i32,
    y: i32,
}
