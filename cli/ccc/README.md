
```
	                     -=                --,
	                      --=-=             --:.
	                         :-===-=-       ----:.
	                           ::-======--   ---=-:.
	                             .:-=========-----=-.-=
	                               -=::===========-==-:==
	                                 .:--===================
	                                 .::--===----==============
	                       :-=+-:   .:-========:-~-.~-===========
	                :::.  :=***-:  -==============-~^=:-~-=======.
	           ::==***+.  :=***-: -========---=-===-~-%@*;-~-===-:
	       .:=+*******+.  :-==: -======-=-=---=---=--~'"^=+-~-===:.
	    :=***********=:        -====-=-=---/-----------=-=-===========-
	.=***********+.           -======-=--//--::-------------=-==========-
	.*******+=-.             =====-=---/ /__::. :-------------=-=======-:.
	.*****=:                -=-===-=--/__  /:.            ...:--=-====-:    _
	.********+:.           -===-=-=-----/ /:                   --===-:   .:===:.
	.=***********+--.     -====::=-----//.                   -----:.   .:======;
	   .-=+**********+=.  =-===-.:-=--/---:                 --          .:=====;
	        --=********.  -=-===-. --------:.                         .:-======;
	            .:+****.   -=-=-=-. ---------:                    .:===========:
	                :-=;    -=-=-=-: --------=-:               -===========:'
	                        ---------.  ------==--             =======-:'
              ________    __    `':::--- ::------::..          ====:'
   ____      / ____/ /   / /          `" ''::-------::::.      ^'
  |_  /_____/ /   / /   / /                    `'"'`
 _/_ </ ___/ /___/ /___/ /
/____/ /__ \____/_____/_/
     \___/      
```

# 3C CLI

The 3C CLI produces consistent, formatted README.md files for coding challenges.

<br>

## Features

The output structure is designed to scale to multiple sources without collisions.  


- Accepts challenge id, slug, URL, or numeric ranges (e.g., `40-50`)
- Fetches Title, ID, Difficulty, Content (HTML), Tags, Hints, Similar problems
- Parses and normalizes common example/constraints structures
- Flexible output layouts with namespacing by source
- Customizable leaf directory name and templates
- Optional: generate “Similar” problems as a batch
- Robust HTTP behavior (session, CSRF bootstrap, Referer/Origin, retries)
- Debug mode for path and HTTP diagnostics
- Parallel batch generation with `-j/--jobs` (I/O-bound speedup; safe modest thread counts)
- Eleven sources behind one command, each with a short subcommand

Global command: `3c`

| Subcommand                   | Source        | Accepted input                                   | Difficulty tier            |
|------------------------------|---------------|--------------------------------------------------|----------------------------|
| `lc`, `leetcode`             | LeetCode      | id, slug, URL, range, `--potd`                   | Easy / Medium / Hard       |
| `cg`, `golf`, `codegolf`     | CodeGolf      | hole id or name, `--all`, `--latest`, `--random` | —                          |
| `ac`, `atcoder`              | AtCoder       | task id, contest id (all tasks), URL             | rating colour (estimate)   |
| `cf`, `codeforces`           | Codeforces    | `1850A`, `1850/A`, contest id (all problems), URL | problem rating            |
| `cw`, `codewars`             | Codewars      | kata slug, id, URL                               | kyu / dan rank             |
| `codingame`, `cgame`         | CodinGame     | puzzle id, URL                                   | puzzle level               |
| `hr`, `hackerrank`           | HackerRank    | challenge slug, URL (contests included)          | Easy / Medium / Hard / …   |
| `kt`, `kattis`               | Kattis        | problem id, URL (any `*.kattis.com`)             | Easy / Medium / Hard       |
| `pe`, `euler`, `projecteuler`| Project Euler | number, range, URL                               | —                          |
| `spoj`, `sp`                 | SPOJ          | problem code, URL                                | —                          |
| `tc`, `topcoder`             | Topcoder      | problem id, class name, URL                      | division + level           |

Every subcommand has its own `--help` with examples, e.g. `3c cf --help`.

<br>

---

<br>

## Install

Recommended: install globally with pipx.

```powershell
# Windows (PowerShell)
winget install pipx
pipx ensurepath
# Close & reopen your shell
cd <path-to-your-cloned-3C-repo>
pipx install .
```

```bash
# macOS / Linux
python3 -m pip install --user pipx
python3 -m pipx ensurepath
# Close & reopen your shell
cd <path-to-your-cloned-3C-repo>
pipx install .
```

Dev install (editable) into a venv:

```bash
python -m venv .venv
# PowerShell: .\.venv\Scripts\Activate.ps1
source .venv/bin/activate
pip install -e .
```

Verify:

```bash
3c --help
3c lc --help
```

### Requirements

- Python version 3.9 or later.
- Internet connection.

<br>

---

<br>

## Usage (example source LeetCode)

Basic:

```bash
# Single problem
3c lc 3508

# Range (inclusive)
3c lc 40-50

# By URL
3c lc https://leetcode.com/problems/maximum-binary-tree-ii/

# By slug
3c lc maximum-binary-tree-ii

# Also generate one-hop similar problems
3c lc 998 --also-similar

# Today's LeetCode Problem of the Day 
3c lc --potd
```

Parallel batch:

```bash
# 6 parallel threads (I/O-bound; reduces wall time for large ranges)
3c lc 100-150 -j 6

# Or via environment variable:
export 3C_JOBS=6
3c lc 100-150
```

Guidelines:
- Default jobs: `1` (sequential).
- Use `4–8` for big batches; watch for API rate limiting.
- Reduce if many retries or 429/499 statuses appear.

Common flags:

```bash
# Set base directory to write into (default: current dir or $3C_OUT_DIR)
--out-dir <path>

# Legacy mode: kept for compatibility; maps to a modern layout under the hood
--mode {by-difficulty,flat}

# Flexible layout (preferred):
--layout {source-difficulty-id,difficulty-source-id,source-id,flat}

# Leaf directory name pattern:
--namefmt "{id}"                 # default
--namefmt "{id}-{slug}"          # readable, collision resistant
--namefmt "{source}-{id}"        # include source in leaf

# Other useful switches:
--no-id-subdir                   # write directly under difficulty/base (no <id> folder)
--fail-on-paid                   # skip paid-only problems
--no-normalize-examples          # embed raw HTML content
--no-contest-tag                 # skip contest tag lookup
--filename README.md             # output filename
--template /path/to/template.j2  # custom Jinja2 template
--also-similar                   # include similar problems
--debug                          # print HTTP and output path diagnostics
-j / --jobs N                    # parallel threads (default from $3C_JOBS or 1)
```

Examples:

```bash
# Default
# Writes to repo root, or to the location of `3C_OUT_DIR` ENV-variable, if it is assigned a custom value  
3c lc 3508
# -> ./Challenges/LeetCode/Medium/3508/README.md

# Default layout (source + difficulty + id) into cwd
3c lc 3508 --out-dir .
# -> cwd/Challenges/LeetCode/Medium/3508/README.md

# “Flat-by-source” with readable leaf name
3c lc 50 --layout source-id --namefmt "{id}-{slug}"
# -> ./Challenges/LeetCode/50-powx-n/README.md

# Legacy flat mode (internally coerced to source-id to avoid cross-source collisions)
3c lc 64 --mode flat
# -> ./Challenges/LeetCode/64/README.md

# Generate a batch, then write under a custom out dir
3c lc 40-45 --out-dir E:/directory
# -> E:/directory/Challenges/LeetCode/<difficulty>/<id>/README.md
```

<br>

---

<br>

## Other sources

All sources other than LeetCode and CodeGolf share one set of options and one template
(`cli/ccc/cli/templates/problem_readme.md.j2`). Several problems can be passed at once; duplicates are
fetched only once.

```bash
# AtCoder: a task, a whole contest, or a URL
3c ac abc300_a
3c ac abc300 -j 4
3c ac https://atcoder.jp/contests/dp/tasks/dp_a

# Codeforces: a problem, a whole contest, or a URL (gyms with HTML statements included)
3c cf 1850A 4/A
3c cf 1850
3c cf https://codeforces.com/problemset/problem/4/A

# Codewars / CodinGame / HackerRank / Kattis: slug (as in the URL) or URL
3c cw valid-braces
3c codingame the-descent
3c hr sherlock-and-anagrams
3c kt hello https://open.kattis.com/problems/10kindsofpeople

# Project Euler: numbers and inclusive ranges
3c pe 1 96 100-110 -j 4

# Topcoder: archive problem id or class name
3c tc MinesweeperStrings 1259

# SPOJ: problem code
3c spoj TEST
```

Shared options:

```bash
--out-dir <path>                 # base directory (default: current dir or $3C_OUT_DIR)
--layout {source-difficulty-id,difficulty-source-id,source-id,flat}
--namefmt "{id}-{slug}"          # leaf directory name
--no-id-subdir                   # no per-problem directory
--filename README.md             # output filename
--template /path/to/template.j2  # custom Jinja2 template
-j / --jobs N                    # parallel fetches (default from $3C_JOBS or 1)
--refresh                        # re-download cached source indexes
--force / --no-overwrite         # overwrite policy for existing files
--dry-run                        # print what would be written
```

Source-specific options: `3c ac --no-difficulty` skips the difficulty estimate.

The command exits with status `1` if any problem could not be generated, so it can be used in scripts.

### Where the data comes from

| Source        | Method                                                                                           |
|---------------|--------------------------------------------------------------------------------------------------|
| AtCoder       | Task page scrape (English statement preferred). Difficulty and task → contest mapping from the community [AtCoder Problems](https://kenkoooo.com/atcoder/) dataset. |
| Codeforces    | Problem page scrape for statement, limits, rating and tags. Official API (`problemset.problems`) as metadata fallback. |
| Codewars      | Official REST API `api/v1/code-challenges/<id-or-slug>` (Markdown description).                  |
| CodinGame     | The site's anonymous JSON service `services/Puzzle/findProgressByPrettyId`.                      |
| HackerRank    | The site's REST endpoint `rest/contests/<contest>/challenges/<slug>`.                            |
| Kattis        | Problem page scrape.                                                                             |
| Project Euler | Documented minimal endpoints `minimal=<n>` and `minimal=problems`.                               |
| SPOJ          | Problem page scrape.                                                                             |
| Topcoder      | Static problem archive `archive.topcoder.com` (statement pages and `assets/problems.json`).      |

Requests identify themselves as `3c-cli/<version>`, are retried with backoff on transient errors
(429/5xx, honouring `Retry-After`) and reuse one connection pool per worker thread.

### Known limitations

- **Anti-bot challenges are not bypassed.** Some sites answer automated clients with a challenge page
  depending on network and time of day. SPOJ (and LeetCode) do this frequently; the problem is then
  reported as failed. For Codeforces the README is still generated from API metadata, with a note that
  the statement is missing; re-run with `--force` later to complete it.
- **HackerRank formulas in sample explanations** are published as images without source and appear as
  `⟨formula⟩`. The statement, input format and constraints keep their `$...$` math.
- **Codeforces gym problems** that only ship a PDF statement cannot be converted.
- **AtCoder difficulty** is an estimate by AtCoder Problems, not an official figure, and is missing for
  very old or very new tasks (those are written without a difficulty directory).
- **Private or running contests** are not accessible; no login is performed for these sources.

Problem statements remain the property of their respective sites and authors. Generated files are meant
for personal reference; check a source's terms before redistributing them.

<br>

---

<br>

## Output layouts

The CLI supports four layouts; all keep sources separate to prevent overwriting when more sources are added.
Everything is written below `<out>/Challenges/`, `<source>` is the source's name (`LeetCode`, `AtCoder`,
`Codeforces`, `ProjectEuler`, ...) and `<difficulty>` is the tier from the table above: `Easy`/`Medium`/`Hard`
for LeetCode, lower-cased for the other sources (`medium`, `6-kyu`, `1500`, `brown`, `div-1-easy`, ...).
Sources or problems without a tier skip that level.

- `source-difficulty-id` (default)  
	 &emsp;&emsp;`<out>/Challenges/<source>/<difficulty>/<leaf>/README.md`  
	 &emsp;&emsp;`./Challenges/LeetCode/Medium/3508/README.md`


- `difficulty-source-id`  
        &emsp;&emsp;`<out>/Challenges/<difficulty>/<source>/<leaf>/README.md`  
        &emsp;&emsp;`./Challenges/Medium/LeetCode/3508/README.md`


- `source-id`  
	&emsp;&emsp;`<out>/Challenges/<source>/<leaf>/README.md`  
	&emsp;&emsp;`./Challenges/LeetCode/3508/README.md`  


- `flat`  
	&emsp;&emsp;`<out>/Challenges/<leaf>/README.md`  
	&emsp;&emsp;`./Challenges/3508/README.md`  

Leaf directory name (`<leaf>`) defaults to `{id}`; customize with `--namefmt`:
- `{id}-{slug}` → `998-maximum-binary-tree-ii`
- `{source}-{id}` → `LeetCode-998`

## Configuration

Environment variables:

- `3C_OUT_DIR` — default base output directory if `--out-dir` is not provided.
	- Windows (PowerShell):
	  ```powershell
	  [Environment]::SetEnvironmentVariable("3C_OUT_DIR", "<output-path>", "User")
	  ```
	- macOS/Linux:
	  ```bash
	  echo 'export 3C_OUT_DIR="$HOME/path/to/3C"' >> ~/.bashrc
	  source ~/.bashrc
	  ```
- `3C_CACHE_DIR` — cache directory (default: `~/.3c/cache` or `%USERPROFILE%\.3c\cache`)
- `3C_LAYOUT` — default layout (default: `source-difficulty-id`)
- `3C_NAMEFMT` — default leaf directory format (default: `{id}`)
- `3C_JOBS` — default parallel jobs for batch generation (`1` if unset)

Authentication (optional but recommended for reliability and paid-only metadata):
- `LEETCODE_SESSION` — your browser’s LeetCode session cookie
- `LEETCODE_CSRF` — your browser’s csrftoken

Set at runtime (PowerShell):

```powershell
$env:LEETCODE_SESSION = "<your-session-cookie>"
$env:LEETCODE_CSRF = "<your-csrf-token>"
```

Set in bash:

```bash
export LEETCODE_SESSION="<your-session-cookie>"
export LEETCODE_CSRF="<your-csrf-token>"
```

<br>

## Templates

The default Jinja2 template lives at:  
`cli/ccc/cli/templates/<source_template>.md.j2`  

Pass `--template /path/to/template.j2` to use your own.

<br>

## Caching

The tool caches:
- LeetCode: problem map (`/api/problems/all/`) and contest lookups
- CodeGolf: hole list (1 day)
- AtCoder: difficulty estimates and task → contest map (1 week)
- Codeforces: problem set metadata, only when needed as a fallback (1 day)
- Project Euler: problem index (1 day)
- Topcoder: archive index, only when a problem is addressed by name (1 week)

Pass `--refresh` to a source command to rebuild its cached indexes.

Default locations:
- Linux/macOS: `~/.3c/cache`
- Windows: `%USERPROFILE%\.3c\cache`

Override with `3C_CACHE_DIR`.

## Parallelism Notes

- Uses Python threads (`ThreadPoolExecutor`).
- Workload is I/O-bound (network + disk); GIL release during I/O enables concurrency.
- Contest cache writes are protected by a lock to avoid race conditions.
- Sessions are reused per thread via thread-local storage to reduce connection overhead.

<br>

---

<br>

## Troubleshooting

- Command not found:
	- Run `pipx ensurepath` then restart your shell; reinstall via `pipx install .`
- Run `doctor` for health check
	- Use `--show-env` to inspect env vars
	- Use `--check-network` to probe every source and see which ones answer (or challenge) from your network
- 400/403/429/499 from GraphQL:
	- Set `LEETCODE_SESSION` and `LEETCODE_CSRF` from your browser session
	- Re-run with `--debug` to see HTTP statuses and retries
	- Try again after a short delay (temporary edge/CDN conditions)
- Unexpected output location:
	- Check `--layout` and `--namefmt`
	- Print debug info with `--debug` to see the resolved `out_root` and computed `out_dir`
- "answered with an anti-bot challenge":
	- The site refused automated access from your network for now; retry later (see Known limitations)
- Template path errors:
	- Ensure the path passed to `--template` exists and is readable

<br>

---

<br>

## Development

```bash
pip install -e ".[dev]"
pytest
```

The test suite runs offline: HTTP and the cache directory are stubbed, and parsers are exercised against
small fixtures in `cli/tests/`.

Adding a source means adding one module under `cli/ccc/cli/providers/` with a `StatementProvider`
subclass that implements `expand()` (CLI input → problem references) and `fetch()` (reference → `Problem`).
Argument parsing, layouts, overwrite policy, parallelism and rendering are inherited; providers are
discovered automatically.

<br>

---

<br>

## Roadmap / wish to implement

Done:
- [x] Additional sources: AtCoder, Codeforces, Codewars, CodinGame, HackerRank, Kattis, Project Euler,
  SPOJ, Topcoder
- [x] Unit tests for the shared core and the new providers

Open:
- Move LeetCode and CodeGolf onto the shared provider base (HTTP client, cache, template context)
- Shared metadata per problem
- Extended batch workflows (`--latest`, `--random`, tag/difficulty filters for more sources)
- Smarter rate limit adaptation (dynamic throttle)
- Integration tests against recorded responses, linting, type checks...
- Cross-platform checks (perms, locales)
- Packaging & OS package manager targets 
- Logging improvements; rotating logs, error reporting, retries, cache improvements

Under consideration:
- cli submission
- AC info (mem, time)

