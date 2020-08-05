INSERT INTO book (title) VALUES ('The Pragmatic Programmer'); 
INSERT INTO member (name) VALUES ('Suqin Zheng');
INSERT INTO checkout_item (book_id, member_id) VALUES
((SELECT id FROM book WHERE title = 'The Pragmatic Programmer'), (SELECT id FROM member WHERE name = 'Suqin Zheng'));
SELECT m.name
FROM member AS m, book AS b, checkout_item AS c
WHERE m.id = c.member_id
    AND b.id = c.book_id
    AND b.title = 'The Pragmatic Programmer';
