use std::{
    cmp::Reverse,
    collections::BinaryHeap,
    io::{stdin, BufRead, BufReader},
};

const LIMIT: i32 = 1_000_000;

fn main() {
    let mut br = BufReader::new(stdin());

    let mut queries = Vec::new();
    loop {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        if line.is_empty() {
            break;
        }

        queries.push(line);
    }

    println!("{}", solve(&queries));
}

fn solve(queries: &[String]) -> String {
    let mut result = Vec::new();
    let mut pq = BinaryHeap::new();
    let mut total_piece = 0;
    let mut piece_binary_indexed_tree = vec![0; (1 << (LIMIT.ilog2() + 1)) + 1];
    let mut cost_binary_indexed_tree = vec![0; (1 << (LIMIT.ilog2() + 1)) + 1];
    for query in queries {
        let fields: Vec<_> = query.split_whitespace().collect();
        if fields[0] == "ARRIVE" {
            let n: i32 = fields[1].parse().unwrap();
            let c = fields[2].parse().unwrap();

            pq.push((Reverse(c), n));
            total_piece += n as i64;
            update(&mut piece_binary_indexed_tree, c, n as i64);
            update(&mut cost_binary_indexed_tree, c, (n as i64) * (c as i64));
        } else {
            let mut n = fields[1].parse().unwrap();
            let t = fields[2].parse().unwrap();

            if can_sell(
                n,
                t,
                total_piece,
                &piece_binary_indexed_tree,
                &cost_binary_indexed_tree,
            ) {
                result.push("HAPPY");

                while n != 0 {
                    let (Reverse(price), piece) = pq.pop().unwrap();
                    total_piece -= piece as i64;
                    update(&mut piece_binary_indexed_tree, price, -(piece as i64));
                    update(
                        &mut cost_binary_indexed_tree,
                        price,
                        -(piece as i64) * (price as i64),
                    );

                    if piece > n {
                        let rest_piece = piece - n;
                        pq.push((Reverse(price), rest_piece));
                        total_piece += rest_piece as i64;
                        update(&mut piece_binary_indexed_tree, price, rest_piece as i64);
                        update(
                            &mut cost_binary_indexed_tree,
                            price,
                            (rest_piece as i64) * (price as i64),
                        );

                        n = 0;
                    } else {
                        n -= piece;
                    }
                }
            } else {
                result.push("UNHAPPY");
            }
        }
    }

    result.join("\n")
}

fn can_sell(
    n: i32,
    t: i64,
    total_piece: i64,
    piece_binary_indexed_tree: &[i64],
    cost_binary_indexed_tree: &[i64],
) -> bool {
    if total_piece < n as i64 {
        return false;
    }

    let mut price = 0;
    let mut lower = 1;
    let mut upper = LIMIT as usize;
    while lower <= upper {
        let middle = (lower + upper) / 2;
        if compute_prefix_sum(piece_binary_indexed_tree, middle) <= n as i64 {
            price = middle;
            lower = middle + 1;
        } else {
            upper = middle - 1;
        }
    }

    compute_prefix_sum(cost_binary_indexed_tree, price)
        + ((price + 1) as i64) * ((n as i64) - compute_prefix_sum(piece_binary_indexed_tree, price))
        <= t
}

fn compute_prefix_sum(binary_indexed_tree: &[i64], mut index: usize) -> i64 {
    let mut result = 0;
    while index != 0 {
        result += binary_indexed_tree[index];
        index -= ((index as i32) & -(index as i32)) as usize;
    }

    result
}

fn update(binary_indexed_tree: &mut [i64], mut index: usize, delta: i64) {
    while index < binary_indexed_tree.len() {
        binary_indexed_tree[index] += delta;
        index += ((index as i32) & -(index as i32)) as usize;
    }
}
