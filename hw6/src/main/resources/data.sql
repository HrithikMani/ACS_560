-- Insert initial data into data_model
INSERT INTO data_model (name, category, rating, reviews, size, installs, type, price, content_rating, genres)
VALUES 
('ibis Paint X', 'ART_AND_DESIGN', 4.6, 522001, '31M', '50,000,000+', 'Free', 0.0, 'Everyone', 'Art'),
('Autodesk SketchBook', 'ART_AND_DESIGN', 4.3, 123321, '75M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Art'),
('Adobe Illustrator Draw', 'ART_AND_DESIGN', 4.5, 86090, '40M', '5,000,000+', 'Free', 0.0, 'Everyone', 'Design'),
('FlipaClip - Cartoon animation', 'ART_AND_DESIGN', 4.3, 194216, '32M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Animation'),
('Canva', 'ART_AND_DESIGN', 4.7, 2135250, '27M', '100,000,000+', 'Free', 0.0, 'Everyone', 'Design');

-- Insert initial data into user_review
INSERT INTO user_review (data_model_id, sentiment, sentiment_polarity, sentiment_subjectivity, review)
VALUES 
(1, 'Positive', 0.9, 0.8, 'Fantastic app for photo editing with great features.'),
(1, 'Negative', 0.3, 0.7, 'Good app, but crashes too often.'),
(2, 'Positive', 0.7, 0.6, 'Great for kids who love coloring, simple and fun.'),
(3, 'Positive', 0.9, 0.7, 'Best launcher ever! Lots of customization options.'),
(4, 'Neutral', 0.5, 0.5, 'Good app, but the drawing tools need improvement.'),
(5, 'Positive', 0.8, 0.7, 'Very easy and fun to use, especially for beginners.');
