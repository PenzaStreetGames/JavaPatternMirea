CREATE TABLE "user" (
    id       BIGSERIAL PRIMARY KEY,
    login    TEXT UNIQUE NOT NULL,
    password TEXT        NOT NULL
);

CREATE INDEX user_login_idx ON "user" (login);
CREATE INDEX user_password_idx ON "user" (password);