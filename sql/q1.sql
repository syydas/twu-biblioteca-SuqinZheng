SELECT m.name
FROM member AS m, book AS b, checkout_item AS c
WHERE m.id = c.member_id
    AND b.id = c.book_id
    AND b.title = 'The Hobbit';