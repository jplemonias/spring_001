CREATE TABLE IF NOT EXISTS users (
   id INTEGER PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   champion VARCHAR(255) NOT NULL,
   hp INTEGER NOT NULL
);