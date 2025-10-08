# LeetCode README Generator

A small tool to generate formatted README.md files for LeetCode problems in your local repo.

## Features

- Accepts problem number, slug, or full URL
- Fetches Title, ID, Difficulty, Content (HTML), Tags, Hints, Similar problems
- Renders to README.md using your preferred format
- Places the file by difficulty (default) or flat into a directory you choose

## Install

```bash
cd scripts
python3 -m venv .venv
. .venv/bin/activate
pip install -r requirements.txt
```

Optional for paid-only content or hints:

```bash
cp .env.example .env
# Edit .env, then export the values
export $(grep -v '^#' .env | xargs)
```

## Usage

```bash
# From repo root or scripts/ dir

# By URL
python scripts/leetcode_readme_gen.py https://leetcode.com/problems/design-task-manager/

# By number
python scripts/leetcode_readme_gen.py 3408

# By slug
python scripts/leetcode_readme_gen.py design-task-manager

# Place by difficulty into ./medium/README.md (default behavior)
python scripts/leetcode_readme_gen.py 3408 --mode by-difficulty --out-dir .

# Place into a flat directory with custom filename
python scripts/leetcode_readme_gen.py 3408 --mode flat --out-dir ./problems --filename README.md

# Fail if the problem is paid-only (otherwise it will still generate if public fields are accessible)
python scripts/leetcode_readme_gen.py 3408 --fail-on-paid
```

Generated structure (default):

```
./easy/README.md or ./medium/README.md or ./hard/README.md
```

## Notes

- The `content` from LeetCode is HTML, embedded directly in the README under "Description". This keeps examples and constraints accurate without complex parsing.
- Tags, Hints, Similar problems are populated where available.
- You can refine or extend the template in `scripts/templates/leetcode_readme.md.j2` to match your exact house style.
- If LeetCode changes their API or if mapping number -> slug fails, pass the slug or full problem URL directly.
- Respect LeetCode’s Terms of Service. Use authenticated requests only with your own account.