select h.hacker_id, h.name from Hackers as h
inner join Submissions as s on h.hacker_id = s.hacker_id
inner join Challenges as c on s.challenge_id = c.challenge_id
inner join Difficulty as d on c.difficulty_level = d.difficulty_level
where s.score = d.score
group by h.hacker_id, h.name 
having count(s.hacker_id) > 1 
order by count(h.hacker_id) desc, h.hacker_id;