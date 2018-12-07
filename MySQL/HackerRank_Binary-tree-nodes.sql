select temp.N, if(
    temp.p is NULL, Root, if(
        (select count() from BST where P = temp.N)0, Inner, Leaf
    )
) from BST as temp order by N;