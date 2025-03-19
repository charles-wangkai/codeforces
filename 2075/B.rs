use std::io::{stdin, BufRead, BufReader};

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
        let k = split.next().unwrap().parse().unwrap();
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        let mut a = Vec::new();
        for _ in 0..n {
            a.push(split.next().unwrap().parse().unwrap());
        }

        println!("{}", solve(&a, k));
    }
}

fn solve(a: &[i32], k: usize) -> i64 {
    if k == 1 {
        return (0..a.len())
            .map(|i| {
                a[i] + (if i == 0 {
                    a[a.len() - 1]
                } else if i == a.len() - 1 {
                    a[0]
                } else {
                    a[0].max(a[a.len() - 1])
                })
            })
            .max()
            .unwrap() as i64;
    }

    (0..a.len())
        .map(|i| compute_max_cost(a, k, i))
        .max()
        .unwrap()
}

fn compute_max_cost(a: &[i32], k: usize, final_index: usize) -> i64 {
    if final_index == 0 || final_index == a.len() - 1 {
        let mut sorted = (0..a.len())
            .filter(|&i| i != final_index)
            .map(|i| a[i])
            .collect::<Vec<_>>();
        sorted.sort_by_key(|x| -x);

        return (a[final_index] as i64) + (0..k).map(|i| sorted[i] as i64).sum::<i64>();
    }

    let left_index = (0..final_index).max_by_key(|&i| a[i]).unwrap();
    let right_index = (final_index + 1..a.len()).max_by_key(|&i| a[i]).unwrap();

    let mut sorted = (0..a.len())
        .filter(|&i| i != final_index && i != left_index && i != right_index)
        .map(|i| a[i])
        .collect::<Vec<_>>();
    sorted.sort_by_key(|x| -x);

    (a[final_index] as i64)
        + (a[left_index] as i64)
        + (a[right_index] as i64)
        + (0..k - 2).map(|i| sorted[i] as i64).sum::<i64>()
}
