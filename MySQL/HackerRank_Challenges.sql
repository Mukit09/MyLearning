select h.hacker_id, h.name, count(c.challenge_id) as cnt from Hackers as h
inner join Challenges as c on c.hacker_id = h.hacker_id group by h.hacker_id, h.name
having cnt = (
    select count(challenge_id) as cnt1 from Challenges group by hacker_id order by cnt1 desc limit 1
)
or cnt in (
    select dummy.cnt1 from (
        select count(*) as cnt1 from Challenges group by hacker_id
    ) as dummy group by dummy.cnt1 having count(dummy.cnt1) = 1
)
order by cnt desc, h.hacker_id;