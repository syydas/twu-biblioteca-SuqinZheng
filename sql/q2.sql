SELECT count(*)
FROM member
WHERE id
NOT IN
(SELECT member_id FROM checkout_item);