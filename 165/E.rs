use std::io::{BufRead, BufReader, stdin};

const BIT_NUM: usize = 22;

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let n = split.next().unwrap().parse().unwrap();
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let mut a = Vec::new();
    for _ in 0..n {
        a.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(&a));
}

fn solve(a: &[i32]) -> String {
    let mut sorted_masks = (0..1 << BIT_NUM).collect::<Vec<usize>>();
    sorted_masks.sort_unstable_by_key(|mask| mask.count_ones());

    let mut dp = vec![-1; 1 << BIT_NUM];
    for &ai in a {
        dp[ai as usize] = ai;
    }
    for mask in sorted_masks {
        if dp[mask] != -1 {
            for b in 0..BIT_NUM {
                if ((mask >> b) & 1) == 0 {
                    dp[mask + (1 << b)] = dp[mask];
                }
            }
        }
    }

    a.iter()
        .map(|&ai| dp[(ai as usize) ^ ((1 << BIT_NUM) - 1)])
        .map(|x| x.to_string())
        .collect::<Vec<_>>()
        .join(" ")
}
