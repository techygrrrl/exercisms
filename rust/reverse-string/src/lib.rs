use unicode_segmentation::UnicodeSegmentation;

pub fn reverse(input: &str) -> String {
    let mut output = String::new();
    let letters = input.graphemes(true).collect::<Vec<&str>>();
    let count = letters.len();

    for i in (0..count).rev() {
        let letter = letters[i];
        output.push_str(letter);
    }

    output
}
