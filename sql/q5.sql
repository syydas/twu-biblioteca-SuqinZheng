SELECT name
FROM member
WHERE id IN
    (SELECT member_id
    FROM checkout_item
    GROUP BY member_id
    HAVING COUNT(*) > 1);