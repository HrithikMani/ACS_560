INSERT INTO data_model (name, category, rating, reviews, size, installs, type, price, content_rating, genres)
VALUES 
('Procreate Pocket', 'ART_AND_DESIGN', 4.7, 124000, '32M', '1,000,000+', 'Paid', 4.99, 'Everyone', 'Art'),
('Prisma Photo Editor', 'PHOTOGRAPHY', 4.5, 450000, '12M', '10,000,000+', 'Free', 0.0, 'Teen', 'Photography'),
('Alight Motion', 'VIDEO_PLAYERS', 4.4, 670000, '54M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Video'),
('Afterlight', 'PHOTOGRAPHY', 4.3, 58000, '29M', '5,000,000+', 'Paid', 2.99, 'Everyone', 'Photography'),
('ArtFlow', 'ART_AND_DESIGN', 4.2, 94000, '22M', '1,000,000+', 'Free', 0.0, 'Everyone', 'Art'),
('PicsKit - Free Photo Editor', 'PHOTOGRAPHY', 4.4, 78000, '40M', '1,000,000+', 'Free', 0.0, 'Teen', 'Photography'),
('Mojo - Video Stories Editor', 'VIDEO_PLAYERS', 4.5, 280000, '47M', '5,000,000+', 'Free', 0.0, 'Everyone', 'Video'),
('VivaCut', 'VIDEO_PLAYERS', 4.3, 67000, '31M', '10,000,000+', 'Free', 0.0, 'Teen', 'Video'),
('Film Maker Pro', 'VIDEO_PLAYERS', 4.7, 123000, '60M', '5,000,000+', 'Free', 0.0, 'Everyone', 'Video'),
('Motionleap', 'PHOTOGRAPHY', 4.6, 124000, '45M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Photography'),
('PhotoDirector', 'PHOTOGRAPHY', 4.5, 430000, '27M', '50,000,000+', 'Free', 0.0, 'Everyone', 'Photography'),
('Glitch Video Effects', 'VIDEO_PLAYERS', 4.4, 89000, '21M', '1,000,000+', 'Free', 0.0, 'Everyone', 'Video'),
('CapCut - Video Editor', 'VIDEO_PLAYERS', 4.6, 2100000, '72M', '100,000,000+', 'Free', 0.0, 'Everyone', 'Video'),
('Canva Stories', 'ART_AND_DESIGN', 4.8, 1340000, '30M', '100,000,000+', 'Free', 0.0, 'Everyone', 'Art'),
('LightX Photo Editor', 'PHOTOGRAPHY', 4.4, 79000, '26M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Photography'),
('Pixlr', 'PHOTOGRAPHY', 4.3, 53000, '29M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Photography'),
('Sketchbook', 'ART_AND_DESIGN', 4.7, 123000, '56M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Art'),
('Adobe Spark Post', 'ART_AND_DESIGN', 4.4, 340000, '24M', '5,000,000+', 'Free', 0.0, 'Everyone', 'Art'),
('VIMAGE 3D', 'PHOTOGRAPHY', 4.2, 45000, '32M', '1,000,000+', 'Free', 0.0, 'Everyone', 'Photography'),
('StoryZ Photo Motion', 'PHOTOGRAPHY', 4.3, 63000, '37M', '1,000,000+', 'Free', 0.0, 'Everyone', 'Photography'),
('Kwai', 'VIDEO_PLAYERS', 4.5, 820000, '55M', '100,000,000+', 'Free', 0.0, 'Teen', 'Video'),
('PowerDirector', 'VIDEO_PLAYERS', 4.6, 950000, '58M', '50,000,000+', 'Free', 0.0, 'Everyone', 'Video'),
('PhotoRoom', 'PHOTOGRAPHY', 4.8, 115000, '20M', '1,000,000+', 'Free', 0.0, 'Everyone', 'Photography'),
('InCollage', 'PHOTOGRAPHY', 4.7, 720000, '16M', '10,000,000+', 'Free', 0.0, 'Everyone', 'Photography'),
('Fotor Photo Editor', 'PHOTOGRAPHY', 4.1, 62000, '41M', '1,000,000+', 'Free', 0.0, 'Everyone', 'Photography');


INSERT INTO user_review (data_model_id, sentiment, sentiment_polarity, sentiment_subjectivity, review)
VALUES 
(1, 'Positive', 0.9, 0.8, 'Amazing app for professional art on the go.'),
(1, 'Neutral', 0.5, 0.6, 'Good, but could use more layers for detailed work.'),
(2, 'Positive', 0.8, 0.7, 'Great app for transforming photos with filters.'),
(2, 'Negative', 0.2, 0.6, 'Limited filters without a subscription.'),
(3, 'Positive', 0.7, 0.65, 'Excellent for video editing, lots of options.'),
(3, 'Negative', 0.3, 0.7, 'Crashes often on older devices.'),
(4, 'Positive', 0.85, 0.75, 'Powerful editor with great color options.'),
(4, 'Neutral', 0.6, 0.65, 'Good app but has a steep learning curve.'),
(5, 'Positive', 0.9, 0.8, 'Very responsive, ideal for quick sketches.'),
(5, 'Negative', 0.3, 0.7, 'Free version is too limited in features.'),
(6, 'Positive', 0.7, 0.6, 'Easy to use with nice features.'),
(6, 'Neutral', 0.5, 0.5, 'Decent but too many ads for a simple editor.'),
(7, 'Positive', 0.8, 0.75, 'Fantastic for creating video stories.'),
(7, 'Negative', 0.3, 0.6, 'Free version has too many limitations.'),
(8, 'Positive', 0.85, 0.7, 'Perfect for quick video edits with friends.'),
(8, 'Negative', 0.25, 0.6, 'App feels buggy on my phone.'),
(9, 'Positive', 0.9, 0.8, 'Best editor for a mobile device!'),
(9, 'Neutral', 0.5, 0.6, 'Great features but can be overwhelming.'),
(10, 'Positive', 0.95, 0.85, 'Love the animation features, very easy to use.'),
(10, 'Negative', 0.3, 0.7, 'Limited tools in the free version.'),
(11, 'Positive', 0.88, 0.78, 'Perfect for quick edits on the go.'),
(11, 'Negative', 0.35, 0.6, 'Image quality drops after saving.'),
(12, 'Positive', 0.8, 0.7, 'Awesome glitch effects!'),
(12, 'Neutral', 0.6, 0.5, 'Good but doesn’t have enough free effects.'),
(13, 'Positive', 0.9, 0.85, 'Very user-friendly video editor.'),
(13, 'Negative', 0.4, 0.6, 'Watermark on the free version is annoying.');
