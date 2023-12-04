use std::io::{stdin, stdout, BufRead, BufReader, Stdin, Write};

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
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        let mut s = Vec::new();
        for _ in 0..n {
            s.push(split.next().unwrap().parse().unwrap());
        }

        solve(&mut br, &s);
    }
}

fn solve(br: &mut BufReader<Stdin>, s: &[i32]) {
    println!("{}", mex(s));
    stdout().flush().unwrap();

    loop {
        let mut line = String::new();
        br.read_line(&mut line).unwrap();
        let mut split = line.split_whitespace();
        let y: i32 = split.next().unwrap().parse().unwrap();
        if y == -1 {
            break;
        }

        println!("{}", y);
        stdout().flush().unwrap();
    }
}

fn mex(s: &[i32]) -> i32 {
    let mut result = 0;
    let mut index = 0;
    while index != s.len() && s[index] == result {
        result += 1;
        index += 1;
    }

    result
}
