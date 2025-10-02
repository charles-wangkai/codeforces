use std::{
    cmp::Reverse,
    collections::{BTreeMap, BTreeSet},
    io::{BufRead, BufReader, stdin},
    ops::Bound::{Excluded, Unbounded},
};

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
    let mut value_to_indices = BTreeMap::new();
    for i in 0..a.len() {
        if !value_to_indices.contains_key(&Reverse(a[i])) {
            value_to_indices.insert(Reverse(a[i]), Vec::new());
        }
        value_to_indices.get_mut(&Reverse(a[i])).unwrap().push(i);
    }

    let mut result = vec![0; a.len()];
    let mut length = 1;
    let mut ranges = BTreeSet::new();
    for &Reverse(value) in value_to_indices.keys() {
        for &index in &value_to_indices[&Reverse(value)] {
            let lower = ranges
                .range((Unbounded, Excluded((index, index))))
                .next_back()
                .copied();
            let higher = ranges
                .range((Excluded((index, index)), Unbounded))
                .next()
                .copied();
            let current_length: usize;

            if let Some((lower_left, lower_right)) = lower
                && lower_right + 1 == index
            {
                if let Some((higher_left, higher_right)) = higher
                    && higher_left == index + 1
                {
                    ranges.remove(&lower.unwrap());
                    ranges.remove(&higher.unwrap());
                    ranges.insert((lower_left, higher_right));

                    current_length = higher_right - lower_left + 1;
                } else {
                    ranges.remove(&lower.unwrap());
                    ranges.insert((lower_left, lower_right + 1));

                    current_length = lower_right - lower_left + 2;
                }
            } else if let Some((higher_left, higher_right)) = higher
                && higher_left == index + 1
            {
                ranges.remove(&higher.unwrap());
                ranges.insert((higher_left - 1, higher_right));

                current_length = higher_right - higher_left + 2;
            } else {
                ranges.insert((index, index));

                current_length = 1;
            }

            while current_length >= length {
                result[length - 1] = value;
                length += 1;
            }
        }
    }

    result
        .iter()
        .map(|x| x.to_string())
        .collect::<Vec<_>>()
        .join(" ")
}
