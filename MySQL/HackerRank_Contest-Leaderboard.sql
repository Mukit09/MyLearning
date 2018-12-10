select h.hacker_id, h.name, sum(s.mx) as totalScore from Hackers as h
inner join (
    select hacker_id, max(score) as mx from Submissions group by hacker_id, challenge_id 
) as s
on s.hacker_id = h.hacker_id
group by h.hacker_id, h.name
having totalScore > 0
order by totalScore desc, hacker_id;