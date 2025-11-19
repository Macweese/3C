[//]: # (# \#exclude\<scoring>)


<span style="background: rgba(255,0,0,0.2); border: 1px solid rgba(48,163,184,0.15); padding: 2px 10px; border-radius: 6px; font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace; font-size: 22px; font-weight: bold; color:#FF4810;">Hard 9.1</span>
<span style="padding: 0px 0px 0px 30px; font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace; font-size: 18px;">Solve ratio:</span>
<span style="font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace; font-size: 18px; color:#FF4810;">0.00479</span>
<span style="padding: 0px 0px 0px 30px; font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace; font-size: 18px;">Full solves:</span>
<span style="font-family: ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, monospace; font-size: 18px; color:#FF4810;">34</span>

[Kattis #exclude\<scoring>](https://open.kattis.com/problems/excludescoring)

## Description

You are participating in a programming contest cup. The cup consists of a series of programming contests, followed by a final at the end of the season for the top $ 15 $ ranked contestants in the cup. With only one contest left to go before the final, you are starting to wonder if your performance in the earlier contests has been good enough to already secure you a spot in the finals. If so, you could succumb to your laziness and skip the last contest.

The ranking of the cup works as follows. In each contest, a contestant earns some number of points between $0$ and $ 101 $ (the details of this are described below). Their _aggregate score_ is then defined to be the _sum of the four highest scores_ achieved. For instance if a contestant got $ 45 $, $ 15 $, $ 32 $, $0$, $ 30 $, and $ 20 $ points over $6$ contests, their aggregate score is $ 45 + 32 + 30 + 20 = 127 $. The _rank_ of a contestant X in _the cup_ is defined to be $1$ plus the number of contestants that have a strictly larger aggregate score than X.

The score a contestant earns from a contest is based on the rank they achieve _in that contest_, according to the following table.


| $\text{Rank}$ | $\text{Points}$ | $\text{Rank}$ | $\text{Points}$ | $\text{Rank}$ | $\text{Points}$ |
|---------------|-----------------|---------------|-----------------|---------------|-----------------|
| $1$           | $100$           | $11$          | $24$            | $21$          | $10$            |
| $2$           | $75$            | $12$          | $22$            | $22$          | $9$             |
| $3$           | $60$            | $13$          | $20$            | $23$          | $8$             |
| $4$           | $50$            | $14$          | $18$            | $24$          | $7$             |
| $5$           | $45$            | $15$          | $16$            | $25$          | $6$             |
| $6$           | $40$            | $16$          | $15$            | $26$          | $5$             |
| $7$           | $36$            | $17$          | $14$            | $27$          | $4$             |
| $8$           | $32$            | $18$          | $13$            | $28$          | $3$             |
| $9$           | $29$            | $19$          | $12$            | $29$          | $2$             |
| $10$          | $26$            | $20$          | $11$            | $30$          | $1$             |

If a contestant gets a worse rank than $ 30 $, they get $0$ points. If two or more contestants get the same rank in the contest, they are instead assigned the average points of all the corresponding ranks. This average is always rounded up to the closest integer. For example, if three contestants are tied for second place they all receive $\lceil \frac{75+60+50}{3} \rceil = 62 $ points, and the next contestant will have rank $5$ and receives $ 45 $ points (or less, if there is a tie also for $5$'th place. This applies also at rank $ 30 $ e.g., if $ 4711 $ contestants are tied for $ 30 $'th place, they all receive $1$ point.

Contestants may participate in every contest either on-site or online. If they compete on-site, they get $1$ extra point, no matter their original number of points. If a contestant does not participate in a contest, they get $0$ points.

## Input

The first line of input contains two integers $n$ and $m$ ($ 2 \le n \le 10 $, $ 1 \le m \le 10^5 $), where $n$ is the number of contests in the cup (excluding the final), and $m$ is the number of people who participated in any of the first $ n - 1 $ contests.

Then follow $m$ lines, each describing a contestant. Each such line consists of $ n - 1 $ integers $ 0 \le s_1,...,s_{n-1} \le 101 $, where $ s_i $ is the score that this contestant received in the $i$th contest.

The first contestant listed is you. The point values in the input might not correspond to actual points from a contest.

## Output

Output a single integer $r$, the worst possible rank you might end up in after the last contest, assuming you do not participate in it.

### Sample Input 1

<table class="sample" summary="sample data">
      <tbody><tr>
        <th>Sample Input 1</th>
        <th>Sample Output 1</th>
      </tr>
      <tr>
        <td>
          <pre>4 2
50 50 75
25 25 25
</pre>
        <span class="copy-to-clipboard far fa-clone"></span></td>
        <td>
          <pre>2
</pre>
        <span class="copy-to-clipboard far fa-clone"></span></td>
      </tr>
    </tbody></table>

<table class="sample" summary="sample data">
      <tbody><tr>
        <th>Sample Input 2</th>
        <th>Sample Output 2</th>
      </tr>
      <tr>
        <td>
          <pre>5 2
50 50 50 50
25 25 25 25
</pre>
        <span class="copy-to-clipboard far fa-clone"></span></td>
        <td>
          <pre>1

</pre>
        <span class="copy-to-clipboard far fa-clone"></span></td>
      </tr>
    </tbody></table>

<table class="sample" summary="sample data">
      <tbody><tr>
        <th>Sample Input 3</th>
        <th>Sample Output 3</th>
      </tr>
      <tr>
        <td>
          <pre>2 4
90
1
3
2
</pre>
        <span class="copy-to-clipboard far fa-clone"></span></td>
        <td>
          <pre>3
</pre>
        <span class="copy-to-clipboard far fa-clone"></span></td>
      </tr>
    </tbody></table>


<br>

**Notes**


---

## Statistics

<section class="strip strip-item">
            <div class="flex flex-wrap w-full gap-3">
                <div class="w-full basis-1/3@md flex flex-col gap-3" style="basis: 100%;">
                                            <div class="problem-statistics-difficulty-container">
                                                        <span class="self-center whitespace-nowrap difficulty_number difficulty_number-problem_view difficulty_hard">
                                9.1
                            </span>
                            <div class="flex flex-col gap-2 self-center">
                                <span class="info_label">Difficulty</span>
                                <span class="text-lg font-bold text-blue-200">Hard</span>
                            </div>
                        </div>
                        <hr class="my-2">
                                        <table class="table2 condensed mt-5">
                        <tbody><tr>
                            <td style="min-width:230px">Submissions</td>
                            <td style="min-width:50px"><span>3147</span></td>
                        </tr>
                        <tr>
                            <td>Accepted submissions</td>
                            <td><span>104</span></td>
                        </tr>
                        <tr>
                            <td>Submission ratio</td>
                            <td>
                                                                    <span>3.30%</span>
                                                            </td>
                        </tr>
                        <tr>
                            <td>Authors</td>
                            <td><span>678</span></td>
                        </tr>
                        <tr>
                            <td>Full solves <a href="https://support.kattis.com/support/solutions/articles/79000147257-why-do-problems-such-as-travelling-salesperson-2d-have-0-full-solves-">[?]</a></td>
                            <td><span>34</span></td>
                        </tr>
                        <tr>
                            <td>Full solve Ratio</td>
                            <td>
                                                                    <span>4.79%</span>
                                                            </td>
                        </tr>
                    </tbody></table>
                </div>
                <div class="w-full basis-full basis-2/3@md mt-5">
                    <canvas id="stats-donut" style="max-width: 100%; max-height: 400px; display: block; box-sizing: border-box; height: 400px; width: 700px;" width="1400" height="800"></canvas>
                    <script nonce="" type="application/json" id="status-donut-data">
                        {
                                "data": ["104","1908","151","454","524","6"],
                                "labels": ["Accepted","Wrong Answer","Time Limit Exceeded","Run-Time Error","Compile Error","Other"],
                                "backgroundColor": ["#55B369","#E84F67","#F3B74D","#75A9D4","#C45A9C","#000"]
                        }
                    </script>
                </div>
            </div>
</section>