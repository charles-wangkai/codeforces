use std::{
    collections::BTreeSet,
    io::{BufRead, BufReader, stdin},
};

fn main() {
    let mut br = BufReader::new(stdin());

    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let n = split.next().unwrap().parse().unwrap();
    let m = split.next().unwrap().parse().unwrap();
    let mut line = String::new();
    br.read_line(&mut line).unwrap();
    let mut split = line.split_whitespace();
    let mut a = Vec::new();
    for _ in 0..n {
        a.push(split.next().unwrap().parse().unwrap());
    }
    let mut pos = Vec::new();
    let mut x = Vec::new();
    for _ in 0..m {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        pos.push(split.next().unwrap().parse().unwrap());
        x.push(split.next().unwrap().parse().unwrap());
    }

    println!("{}", solve(&a, &pos, &x));
}

fn solve(a: &[i32], pos: &[usize], x: &[i32]) -> String {
    let n = a.len();

    let mut ranges = BTreeSet::new();
    let mut begin_index = 0;
    for i in 1..=n {
        if i == n || a[i] != a[i - 1] {
            ranges.insert((begin_index, i - 1, a[begin_index]));
            begin_index = i;
        }
    }

    let mut awesomeness: i64 = ranges
        .iter()
        .map(|&(begin_index, end_index, _)| compute_contribution(n, begin_index, end_index))
        .sum();

    let mut result = Vec::new();
    for i in 0..pos.len() {
        let index = pos[i] - 1;

        let &middle_range = ranges.range(..(index, usize::MAX, -1)).next_back().unwrap();
        if x[i] != middle_range.2 {
            ranges.remove(&middle_range);
            awesomeness -= compute_contribution(n, middle_range.0, middle_range.1);

            let left_range = ranges.range(..middle_range).next_back().copied();
            let left_range_impacted =
                left_range.is_some_and(|range| range.1 + 1 == index && range.2 == x[i]);

            let right_range = ranges.range(middle_range..).next().copied();
            let right_range_impacted =
                right_range.is_some_and(|range| range.0 - 1 == index && range.2 == x[i]);

            if left_range_impacted {
                ranges.remove(&left_range.unwrap());
                awesomeness -=
                    compute_contribution(n, left_range.unwrap().0, left_range.unwrap().1);

                if right_range_impacted {
                    ranges.remove(&right_range.unwrap());
                    awesomeness -=
                        compute_contribution(n, right_range.unwrap().0, right_range.unwrap().1);

                    let range = (left_range.unwrap().0, right_range.unwrap().1, x[i]);
                    ranges.insert(range);
                    awesomeness += compute_contribution(n, range.0, range.1);
                } else {
                    for range in [
                        (left_range.unwrap().0, index, x[i]),
                        (index + 1, middle_range.1, middle_range.2),
                    ] {
                        if range.0 <= range.1 {
                            ranges.insert(range);
                            awesomeness += compute_contribution(n, range.0, range.1);
                        }
                    }
                }
            } else if right_range_impacted {
                ranges.remove(&right_range.unwrap());
                awesomeness -=
                    compute_contribution(n, right_range.unwrap().0, right_range.unwrap().1);

                for range in [
                    (middle_range.0, index.wrapping_sub(1), middle_range.2),
                    (index, right_range.unwrap().1, right_range.unwrap().2),
                ] {
                    if range.1 != usize::MAX && range.0 <= range.1 {
                        ranges.insert(range);
                        awesomeness += compute_contribution(n, range.0, range.1);
                    }
                }
            } else {
                for range in [
                    (middle_range.0, index.wrapping_sub(1), middle_range.2),
                    (index, index, x[i]),
                    (index + 1, middle_range.1, middle_range.2),
                ] {
                    if range.1 != usize::MAX && range.0 <= range.1 {
                        ranges.insert(range);
                        awesomeness += compute_contribution(n, range.0, range.1);
                    }
                }
            }
        }

        result.push(awesomeness);
    }

    result
        .iter()
        .map(|x| x.to_string())
        .collect::<Vec<_>>()
        .join("\n")
}

fn compute_contribution(n: usize, begin_index: usize, end_index: usize) -> i64 {
    compute_subarray_num(n)
        - compute_subarray_num(begin_index)
        - compute_subarray_num(n - 1 - end_index)
}

fn compute_subarray_num(length: usize) -> i64 {
    (length as i64) * ((length as i64) + 1) / 2
}
