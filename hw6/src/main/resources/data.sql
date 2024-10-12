-- Insert additional DataModel records
INSERT INTO data_model (name, category, rating, reviews, size, installs, type, price, content_rating, genres)
VALUES 
('ibis Paint X', 'ART_AND_DESIGN', 4.6, 522001, '31M', '50,000,000+', 'Free', 0.0, 'Everyone', 'Art'),
('Autodesk SketchBook', 'ART_AND_DESIGN', 4.3, 123321, '75M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Art'),
('Adobe Illustrator Draw', 'ART_AND_DESIGN', 4.5, 86090, '40M', '5,000,000+', 'Free', 0.0, 'Everyone', 'Design'),
('FlipaClip - Cartoon animation', 'ART_AND_DESIGN', 4.3, 194216, '32M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Animation'),
('Canva', 'ART_AND_DESIGN', 4.7, 2135250, '27M', '100,000,000+', 'Free', 0.0, 'Everyone', 'Design'),
('Tattoo Name On My Photo Editor', 'ART_AND_DESIGN', 4.2, 44829, '20M', '10,000,000+', 'Free', 0.0, 'Teen', 'Photography'),
('Mandala Coloring Book', 'ART_AND_DESIGN', 4.6, 4326, '21M', '100,000+', 'Free', 0.0, 'Everyone', 'Art'),
('3D Color Pixel by Number - Sandbox Art Coloring', 'ART_AND_DESIGN', 4.4, 1518, '37M', '100,000+', 'Free', 0.0, 'Everyone', 'Coloring'),
('Photo Designer - Write your name with shapes', 'ART_AND_DESIGN', 4.7, 3632, '5.5M', '500,000+', 'Free', 0.0, 'Everyone', 'Design'),
('Superheroes Wallpapers | 4K Backgrounds', 'ART_AND_DESIGN', 4.7, 7699, '4.2M', '500,000+', 'Free', 0.0, 'Everyone 10+', 'Wallpapers');


-- Insert additional UserReview records
INSERT INTO user_review (app_id, sentiment, sentiment_polarity, sentiment_subjectivity, review)
VALUES 
(1, 'Positive', 0.9, 0.8, 'Fantastic app for photo editing with great features.'),
(1, 'Negative', 0.3, 0.7, 'Good app, but crashes too often.'),
(2, 'Positive', 0.7, 0.6, 'Great for kids who love coloring, simple and fun.'),
(3, 'Positive', 0.9, 0.7, 'Best launcher ever! Lots of customization options.'),
(4, 'Neutral', 0.5, 0.5, 'Good app, but the drawing tools need improvement.'),
(5, 'Positive', 0.8, 0.7, 'Very easy and fun to use, especially for beginners.'),
(6, 'Positive', 0.9, 0.8, 'Amazing app for sketching, I use it every day!'),
(7, 'Positive', 0.7, 0.6, 'Great app for professional design work, highly recommend.'),
(8, 'Neutral', 0.5, 0.5, 'Good animation app, but needs more features.'),
(9, 'Positive', 0.9, 0.8, 'Best design app for creating stunning graphics.'),
(10, 'Positive', 0.8, 0.7, 'Perfect for superhero fans, awesome wallpapers.'),
(10, 'Negative', 0.2, 0.4, 'Limited number of wallpapers, expected more.');
