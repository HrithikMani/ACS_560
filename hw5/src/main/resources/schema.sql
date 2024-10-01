CREATE TABLE IF NOT EXISTS data_model (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    category VARCHAR(255),
    content_rating VARCHAR(255),
    genres VARCHAR(255),
    installs VARCHAR(255),
    price FLOAT NOT NULL,
    rating FLOAT NOT NULL,
    reviews INT NOT NULL,
    size VARCHAR(255),
    type VARCHAR(255)
);
