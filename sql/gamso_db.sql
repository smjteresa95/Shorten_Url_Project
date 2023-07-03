CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
    email TEXT NOT NULL,
    pw VARCHAR(15) NOT NULL,
    usage_count INT DEFAULT 0,
    signup_date DATETIME DEFAULT now()
);

CREATE TABLE url(
	id INT NOT NULL, 
	original_url TEXT NOT NULL,
    shorten_url TEXT NOT NULL,
    shorten_date DATETIME DEFAULT now(),
    CONSTRAINT fk_id FOREIGN KEY (id) REFERENCES users(id)
);

INSERT INTO users (email, pw) VALUES 
			("asd@naver.com", "1234"),
            ("zxc@google.com","4567"),
            ("qwe@gamso.kr", "99");

SELECT * FROM users;
INSERT INTO url (id,original_url, shorten_url) VALUES 
				(1,"www.naver.com","gamso.kr/11sxw2"),
                (2,"www.google.com","gamso.kr/32sad"),
                (2,"www.naver.com","gamso.kr/32sad"),
                (3,"www.daum.com", "gamso.kr/weq22");

