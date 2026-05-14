INSERT INTO ogrenci (ogrno, ad, soyad, cinsiyet, sinif, puan, dtarih) VALUES
(1, 'Hulya', 'Yigit', 'K', '10A', 0, '1990-04-08 00:00:00'),
(2, 'Niyazi', 'Sevinc', 'E', '9B', 0, '1990-11-11 00:00:00'),
(3, 'Ismail', 'Sevinc', 'E', '10C', 0, '1990-04-17 00:00:00'),
(4, 'Kenan', 'Emin', 'E', '9A', 0, '1988-02-23 00:00:00'),
(5, 'Sema', 'Bakir', 'K', '9B', 0, '1990-04-07 00:00:00'),
(6, 'Deniz', 'Kara', 'E', '9C', 0, '1989-07-21 00:00:00'),
(7, 'Betul', 'Coskun', 'K', '11A', 0, '1990-01-10 00:00:00'),
(8, 'Sema', 'Ruzgar', 'K', '9C', 0, '1989-11-14 00:00:00'),
(9, 'Fadime', 'Donmez', 'K', '9A', 0, '1989-09-11 00:00:00'),
(10, 'Riza', 'Koc', 'E', '10C', 0, '1990-01-26 00:00:00');

INSERT INTO tur (turno, ad) VALUES
(1, 'Dram'),
(2, 'Komedi'),
(3, 'Roman'),
(4, 'Hikaye'),
(5, 'Arastirma'),
(6, 'Biyografi'),
(7, 'Kiþisel Geliþim');

INSERT INTO yazar (yazarno, ad, soyad) VALUES
(1, 'Leyla', 'Celik'),
(2, 'Zeynep', 'Emin'),
(3, 'Ali', 'Yazar'),
(4, 'Deniz', 'Akpinar'),
(6, 'Nurettin', 'Belek');

INSERT INTO kitap (kitapno, ad, puan, yazarno, turno) VALUES
(1, 'Abdulhamidin Kurtlarla Dansi', 27, 1, 1),
(2, 'Ablami Nereye Kacirdilar', 32, 1, 2),
(3, 'Anayurttan Anadoluya', 24, 2, 3),
(4, 'Anneannem Gelin Oldu', 20, 2, 4),
(5, 'Antik Acilar', 33, 3, 3),
(6, 'Ask Ve Obur Cinler', 23, 3, 4),
(7, 'Asksiz Insanlar', 23, 4, 5),
(8, 'Atuan Mezarlari', 21, 4, 2),
(9, 'Bahar Isyancidir', 30, 6, 3),
(10, 'Benim Universitelerim', 20, 6, 7),
(11, 'Bir Gemide', 21, 1, 3),
(12, 'Bir Ses Boler Geceyi', 19, 3, 2);

ALTER TABLE ogrenci ALTER COLUMN ogrno RESTART WITH 11;
ALTER TABLE tur ALTER COLUMN turno RESTART WITH 8;
ALTER TABLE yazar ALTER COLUMN yazarno RESTART WITH 7;
ALTER TABLE kitap ALTER COLUMN kitapno RESTART WITH 13;
