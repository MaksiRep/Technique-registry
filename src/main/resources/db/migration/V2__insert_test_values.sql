INSERT INTO product (name, country, manufacturer, is_online, is_installment)
VALUES ('PowerVac 3000', 'Germany', 'VacTech', true, true),
       ('PowerVac 4000', 'Germany', 'VacTech', true, false),
       ('DustBuster Pro', 'USA', 'CleanMaster', false, true),

       ('UltraPC X', 'USA', 'TechPro', true, true),
       ('UltraPC Z', 'USA', 'TechPro', true, false),
       ('GamingBeast', 'Japan', 'GameOn', false, true),

       ('Cooler Max 500', 'Korea', 'FridgeTech', true, true),
       ('Cooler Max 700', 'Korea', 'FridgeTech', true, false),
       ('ChillMaster Pro', 'China', 'IceCool', false, true),

       ('SmartPhone XL', 'USA', 'PhoneMakers', true, true),
       ('SmartPhone Mini', 'USA', 'PhoneMakers', true, false),
       ('UltraPhone 5G', 'Korea', 'SmartTech', false, true),

       ('Vision HD', 'Japan', 'ScreenPro', true, true),
       ('Vision 4K', 'Japan', 'ScreenPro', true, false),
       ('TrueView Ultra', 'China', 'ViewMaster', false, true);

INSERT INTO model (name, serial_number, color, size, price, is_on_stock, product_id)
VALUES ('PowerVac 3000 Model A', 'SN10001', 'Red', '20x15x10', 200, true, 1),
       ('PowerVac 3000 Model B', 'SN10002', 'Blue', '25x20x15', 250, false, 1),

       ('PowerVac 4000 Model A', 'SN10003', 'Green', '22x17x12', 300, true, 2),
       ('PowerVac 4000 Model B', 'SN10004', 'Yellow', '28x20x18', 350, true, 2),

       ('DustBuster Pro Model A', 'SN10005', 'Black', '18x12x10', 150, true, 3),
       ('DustBuster Pro Model B', 'SN10006', 'White', '19x13x11', 160, false, 3),

       ('UltraPC X Model A', 'SN10007', 'Silver', '45x20x40', 1200, true, 4),
       ('UltraPC X Model B', 'SN10008', 'Black', '48x22x42', 1300, false, 4),

       ('UltraPC Z Model A', 'SN10009', 'White', '40x18x38', 1000, true, 5),
       ('UltraPC Z Model B', 'SN10010', 'Blue', '42x20x40', 1050, true, 5),

       ('GamingBeast Model A', 'SN10011', 'Black', '50x25x45', 1500, true, 6),
       ('GamingBeast Model B', 'SN10012', 'Red', '52x27x47', 1600, false, 6),

       ('Cooler Max 500 Model A', 'SN10013', 'White', '60x60x180', 500, true, 7),
       ('Cooler Max 500 Model B', 'SN10014', 'Silver', '65x65x185', 550, false, 7),

       ('Cooler Max 700 Model A', 'SN10015', 'Gray', '70x70x190', 700, true, 8),
       ('Cooler Max 700 Model B', 'SN10016', 'Black', '75x75x195', 750, true, 8),

       ('ChillMaster Pro Model A', 'SN10017', 'White', '68x68x185', 600, true, 9),
       ('ChillMaster Pro Model B', 'SN10018', 'Silver', '72x72x190', 650, false, 9),

       ('SmartPhone XL Model A', 'SN10019', 'Black', '8x1x16', 800, true, 10),
       ('SmartPhone XL Model B', 'SN10020', 'Blue', '8x1x16', 850, false, 10),

       ('SmartPhone Mini Model A', 'SN10021', 'Red', '7x1x14', 700, true, 11),
       ('SmartPhone Mini Model B', 'SN10022', 'Yellow', '7x1x14', 750, true, 11),

       ('UltraPhone 5G Model A', 'SN10023', 'Black', '9x1x17', 900, true, 12),
       ('UltraPhone 5G Model B', 'SN10024', 'White', '9x1x17', 950, false, 12),

       ('Vision HD Model A', 'SN10025', 'Black', '120x10x70', 1000, true, 13),
       ('Vision HD Model B', 'SN10026', 'Silver', '125x12x75', 1050, false, 13),

       ('Vision 4K Model A', 'SN10027', 'Gray', '130x15x80', 1200, true, 14),
       ('Vision 4K Model B', 'SN10028', 'Black', '135x18x85', 1250, true, 14),

       ('TrueView Ultra Model A', 'SN10029', 'White', '140x20x90', 1300, true, 15),
       ('TrueView Ultra Model B', 'SN10030', 'Silver', '145x22x95', 1350, false, 15);

INSERT INTO computer_model (id, category, processor_type)
VALUES (7, 'Gaming', 'Intel i7'),
       (8, 'Gaming', 'AMD Ryzen 7'),

       (9, 'Office', 'Intel i5'),
       (10, 'Office', 'Intel i5'),

       (11, 'High Performance', 'Intel i9'),
       (12, 'High Performance', 'AMD Ryzen 9');

INSERT INTO refrigerator_model (id, number_of_doors, compressor_type)
VALUES (13, 2, 'Inverter'),
       (14, 2, 'Inverter'),

       (15, 3, 'Rotary'),
       (16, 3, 'Rotary'),

       (17, 4, 'Linear'),
       (18, 4, 'Linear');

INSERT INTO smartphone_model (id, memory, number_of_cameras)
VALUES (19, 128, 3),
       (20, 128, 4),

       (21, 64, 2),
       (22, 64, 3),

       (23, 256, 5),
       (24, 256, 4);

INSERT INTO television_model (id, tv_category, technology)
VALUES (25, 'LED', 'HDR'),
       (26, 'LED', 'HDR'),

       (27, 'OLED', 'Dolby Vision'),
       (28, 'OLED', 'Dolby Vision'),

       (29, 'QLED', 'HDR10+'),
       (30, 'QLED', 'HDR10+');

INSERT INTO vacuum_cleaner_model (id, dust_bag_volume, number_of_modes)
VALUES (1, 3, 2),
       (2, 4, 3),

       (3, 5, 4),
       (4, 3, 2),

       (5, 6, 5),
       (6, 4, 3);