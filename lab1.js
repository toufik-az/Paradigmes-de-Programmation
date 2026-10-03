const readline = require("readline/promises");

const quest = [
  "I enjoy going to parties with lots of people.",
  "I find it easy to start conversations with strangers.",
  "I feel comfortable being the center of attention.",
  "I prefer working in a group rather than alone.",
  "I feel more energized after spending time with other people.",
  "I feel more energized after spending time alone.",
  "I prefer listening over talking in group discussions.",
  "I need quiet time to recharge after socializing.",
  "I prefer a quiet night in over a big social event.",
  "I think carefully before speaking in a group."
];


function count(answers) {
  return answers.filter(answer => answer === true).length;
}

function decide(answers) {
  const ext = count(answers.slice(0, 5));
  const intro = count(answers.slice(5, 10));

  if (ext > intro) return "Extrovert";
  if (intro > ext) return "Introvert";
  return "Balanced (Ambivert)";
}

async function main() {
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });
  const answers = [];
  console.log("Personality Test\n");

  for (let i = 0; i < quest.length; i++) {
    let answer;

    do {
      answer = await rl.question(`${i + 1}. ${quest[i]} (T/F): `);
      answer = answer.trim().toLowerCase();
    } while (answer !== "t" && answer !== "f");

    answers.push(answer === "t");
  }

  rl.close();

  const ext = count(answers.slice(0, 5));
  const intro = count(answers.slice(5, 10));

  console.log(`\nExtrovert score: ${ext}`);
  console.log(`Introvert score: ${intro}`);
  console.log(`Result: ${decide(answers)}`);
}

module.exports = { count, decide };
if (require.main === module) main();
