SELECT REPEAT(
    '* ', @NUMBER := @NUMBER + 1
) FROM information_schema.tables, (
    SELECT @NUMBER:=0
)t limit 20