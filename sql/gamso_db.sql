CREATE TABLE users(
                      member_number INT PRIMARY KEY AUTO_INCREMENT,
                      id VARCHAR(20) NOT NULL,
                      email TEXT NOT NULL,
                      pw VARCHAR(15) NOT NULL,
                      signup_date DATETIME DEFAULT now()
);

CREATE TABLE url(
                    member_number INT NOT NULL,
                    original_url TEXT NOT NULL,
                    shorten_url TEXT NOT NULL,
                    shorten_date DATETIME DEFAULT now(),
                    CONSTRAINT fk_member_number FOREIGN KEY (member_number) REFERENCES users(member_number)
);

INSERT INTO users (id, email, pw) VALUES
                                      ("asd", "hjk@naver.com", "1234"),
                                      ("zxccxvxcv", "hyt@google.com", "4567"),
                                      ("qwe", "bnm@naver.com", "99");

INSERT INTO url (member_number, original_url, shorten_url) VALUES
                                                               (1,"www.naver.com","gamso.kr/11sxw2"),
                                                               (2,"www.google.com","gamso.kr/32sad"),
                                                               (2,"www.naver.com","gamso.kr/32sad"),
                                                               (2,"www.daum.com", "gamso.kr/weq22");

SELECT * FROM users;
SELECT * FROM url;

drop table url;
drop table users;
