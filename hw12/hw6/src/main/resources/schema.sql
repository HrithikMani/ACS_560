-- Drop existing tables if they exist
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS user_review;
DROP TABLE IF EXISTS data_model;
SET FOREIGN_KEY_CHECKS=1;

-- Create the DataModel table
CREATE TABLE data_model (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    category VARCHAR(100),
    rating DECIMAL(2, 1),
    reviews INT,
    size VARCHAR(50),
    installs VARCHAR(50),
    type VARCHAR(50),
    price DECIMAL(5, 2),
    content_rating VARCHAR(50),
    genres VARCHAR(100)
);

-- Create the UserReview table with a foreign key relationship to DataModel
CREATE TABLE user_review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_model_id BIGINT NOT NULL,  -- Changed column name to align with code
    sentiment VARCHAR(50),
    sentiment_polarity DECIMAL(3, 2),
    sentiment_subjectivity DECIMAL(3, 2),
    review TEXT,
    FOREIGN KEY (data_model_id) REFERENCES data_model(id) ON DELETE CASCADE  -- Added ON DELETE CASCADE for relational integrity
);
ALTER TABLE user_review ADD COLUMN comment VARCHAR(255);
