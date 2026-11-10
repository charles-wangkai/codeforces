use std::io::{BufRead, BufReader, stdin};

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
        let x = split.next().unwrap().parse().unwrap();
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        let mut a = Vec::new();
        for _ in 0..n {
            a.push(split.next().unwrap().parse().unwrap());
        }

        println!("{}", solve(&a, k, x));
    }
}

fn solve(a: &[i32], k: i32, x: i32) -> String {
    let mut sleep_time = -1;
    let mut lower = 0;
    let mut upper = x;
    while lower <= upper {
        let middle = (lower + upper) / 2;
        if check(a, k, x, middle) {
            sleep_time = middle;
            lower = middle + 1;
        } else {
            upper = middle - 1;
        }
    }

    let ranges = build_ranges(a, x, sleep_time);

    let mut result = vec![0; k as usize];
    let mut pos = 0;
    let mut range_index = 0;
    for i in 0..result.len() {
        if range_index != ranges.len() && ranges[range_index].begin == pos {
            pos = ranges[range_index].end + 1;
            range_index += 1;
        }

        result[i] = pos;
        pos += 1;
    }

    result
        .iter()
        .map(|x| x.to_string())
        .collect::<Vec<_>>()
        .join(" ")
}

//     List<Range> ranges = buildRanges(a, x, sleepTime);

//     int[] result = new int[k];
//     int pos = 0;
//     int rangeIndex = 0;
//     for (int i = 0; i < result.length; ++i) {
//       if (rangeIndex != ranges.size() && ranges.get(rangeIndex).begin == pos) {
//         pos = ranges.get(rangeIndex).end + 1;
//         ++rangeIndex;
//       }

//       result[i] = pos;
//       ++pos;
//     }

//     return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
//   }

fn check(a: &[i32], k: i32, x: i32, time: i32) -> bool {
    let ranges = build_ranges(a, x, time);

    x + 1
        - ranges
            .iter()
            .map(|range| range.end - range.begin + 1)
            .sum::<i32>()
        >= k
}

fn build_ranges(a: &[i32], x: i32, time: i32) -> Vec<Range> {
    if time == 0 {
        return Vec::new();
    }

    let mut ranges: Vec<_> = a
        .iter()
        .map(|ai| Range {
            begin: 0.max(ai - (time - 1)),
            end: x.min(ai + (time - 1)),
        })
        .collect();
    ranges.sort_by_key(|range| range.begin);

    let mut merged: Vec<Range> = Vec::new();
    for &range in &ranges {
        if merged.is_empty() || range.begin > merged.last().unwrap().end + 1 {
            merged.push(range);
        } else {
            merged.last_mut().unwrap().end = merged.last().unwrap().end.max(range.end);
        }
    }

    merged
}

#[derive(Copy, Clone)]
struct Range {
    begin: i32,
    end: i32,
}
