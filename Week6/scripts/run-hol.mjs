import { readdirSync } from "node:fs";
import { spawn } from "node:child_process";
import { fileURLToPath } from "node:url";
import { dirname, join } from "node:path";

const here = dirname(fileURLToPath(import.meta.url));
const rootPath = join(here, "..");
const appsPath = join(rootPath, "React-HOL");

const number = String(process.argv[2] ?? "1").padStart(2, "0");
const folder = readdirSync(appsPath).find((name) =>
  name.startsWith(`${number}-`)
);

if (!folder) {
  console.error("HOL not found. Enter a number from 1 to 19.");
  process.exit(1);
}

console.log(`Starting ${folder}...`);

const child = spawn(`npm run start --workspace=${folder}`, {
  cwd: rootPath,
  stdio: "inherit",
  shell: true
});

child.on("error", (error) => {
  console.error("Unable to start application:", error.message);
  process.exit(1);
});

child.on("exit", (code) => {
  process.exit(code ?? 0);
});