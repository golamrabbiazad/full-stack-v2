CREATE TABLE student
(
    id       INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name     TEXT NOT NULL,
    email    TEXT NOT NULL,
    password TEXT NOT NULL,
    gender   TEXT NOT NULL
)