select s.name from Students s
inner join Friends f on f.ID = s.ID
inner join Packages p on s.ID = p.id
inner join Packages p1 on f.friend_id = p1.id
where p.salary < p1.salary
order by p1.salary