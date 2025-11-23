
```
	                      -=               --,
	                       --=-=            --:.
	                          :-===-=-      ----:.
	                            ::-======--  ---=-:.
	                   ==-        .:-=========----=-.-=
	                     :-========-=::===========-==-:==
	                          .:--==========================
	                              .::--======----==============
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

Currently supported sources:
- LeetCode
- CodeGolf


Global command: `3c`

| Subcommand               | Source   |
|--------------------------|----------|
| `lc`, `leetcode`         | LeetCode |
| `cg`, `golf`, `codegolf` | CodeGolf |

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
# -> ./leetcode/medium/3508/README.md

# Default layout (source + difficulty + id) into cwd
3c lc 3508 --out-dir .
# -> cwd/leetcode/medium/3508/README.md

# “Flat-by-source” with readable leaf name
3c lc 50 --layout source-id --namefmt "{id}-{slug}"
# -> ./leetcode/50-powx-n/README.md

# Legacy flat mode (internally coerced to source-id to avoid cross-source collisions)
3c lc 64 --mode flat
# -> ./leetcode/64/README.md

# Generate a batch, then write under a custom out dir
3c lc 40-45 --out-dir E:/directory
# -> E:/directory/leetcode/64/README.md
```

<br>

---

<br>

## Output layouts

The CLI supports four layouts; all keep sources separate to prevent overwriting when more sources are added.

- `source-difficulty-id` (default)  
	 &emsp;&emsp;`<out>/<source>/<difficulty>/<leaf>/README.md`  
	 &emsp;&emsp;`./leetcode/medium/3508/README.md`


- `difficulty-source-id`  
        &emsp;&emsp;`<out>/<difficulty>/<source>/<leaf>/README.md`  
        &emsp;&emsp;`./medium/leetcode/3508/README.md`


- `source-id`  
	&emsp;&emsp;`<out>/<source>/<leaf>/README.md`  
	&emsp;&emsp;`./leetcode/3508/README.md`  


- `flat`  
	&emsp;&emsp;`<out>/<leaf>/README.md`  
	&emsp;&emsp;`./3508/README.md`  

Leaf directory name (`<leaf>`) defaults to `{id}`; customize with `--namefmt`:
- `{id}-{slug}` → `998-maximum-binary-tree-ii`
- `{source}-{id}` → `leetcode-998`

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
- `3C_JOBS` — default parallel jobs for `lc` generation (`1` if unset)

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
- Problem map (`/api/problems/all/`)
- Contest lookups

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
	- Use `--check-network` to perform check api connection
- 400/403/429/499 from GraphQL:
	- Set `LEETCODE_SESSION` and `LEETCODE_CSRF` from your browser session
	- Re-run with `--debug` to see HTTP statuses and retries
	- Try again after a short delay (temporary edge/CDN conditions)
- Unexpected output location:
	- Check `--layout` and `--namefmt`
	- Print debug info with `--debug` to see the resolved `out_root` and computed `out_dir`
- Template path errors:
	- Ensure the path passed to `--template` exists and is readable

<br>

---

<br>

## Roadmap

- Additional sources (ProjectEuler, Codeforces, etc.)
- Shared metadata per problem
- Extended batch workflows
- Smarter rate limit adaptation (dynamic throttle)
- Testing (unit + integration), linting, type checks...
- Cross-platform checks (perms, locales)
- Packaging & OS package manager targets 
- Logging improvements; rotating logs, error reporting, retries, cache improvements

Under consideration:
- cli submission
- AC info (mem, time)

