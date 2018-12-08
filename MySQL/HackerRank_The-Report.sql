select if(g.grade < 8, NULL, s.name) as name, g.grade, s.marks from  Students as s
inner join Grades as g on s.marks>=g.min_mark && s.marks<=g.max_mark
order by g.grade desc,
    case 
        when name is NULL then s.marks else name
    end;