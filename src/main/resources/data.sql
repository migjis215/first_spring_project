INSERT INTO article(id, title, content) VALUES (1, 'aaa', '111');
INSERT INTO article(id, title, content) VALUES (2, 'bbb', '222');
INSERT INTO article(id, title, content) VALUES (3, 'ccc', '333');

-- article
INSERT INTO article(id, title, content) VALUES (4, 'for', '444');
INSERT INTO article(id, title, content) VALUES (5, 'the', '555');
INSERT INTO article(id, title, content) VALUES (6, 'comments', '666');

-- comment
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'nick_1', 'comment');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'nick_2', 'comment');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'nick_3', 'comment');

INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'nick_1', 'comment');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'nick_2', 'comment');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'nick_3', 'comment');

INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'nick_1', 'comment');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'nick_2', 'comment');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'nick_3', 'comment');
