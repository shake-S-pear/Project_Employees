drop database if exists demo;

create database demo;

use demo;

create table employees(
                          id int auto_increment,
                          name varchar(20),
                          surname varchar(20),
                          title varchar(20),
                          salary int,
                          zipcode varchar(20),
                          city varchar(20),
                          street varchar(20),
                          building varchar(20),
                          email varchar(30),
                          telephone varchar(20),
                          birthdate date,
                          primary key (id)
);

insert employees (name, surname, title, salary, zipcode, city, street, building, email, telephone, birthdate) values
                                                                                                                  ('Mykola', 'Shevchenko', 'director', 10000, '01547', 'Kyiv', 'Franka', '33', 'Mykola.Shevchenko@gmail.com', '096-568-78-20', '1987-02-23'),
                                                                                                                  ('Olena', 'Ilchenko', 'driver', 4000, '12057', 'Zaporizhzhya', 'Shevchenka', '154', 'Olena.Ilchenko@ukr.net', '063-806-20-01', '1999-12-15'),
                                                                                                                  ('Veronika', 'Kum', 'baker', 5000, '12154', 'Mykolaiv', 'Ukrainky', '8', 'Veronika.Kum@yahoo.com', '078-058-01-36', '1968-05-11'),
                                                                                                                  ('Olha', 'Svavenko', 'waitress', 6000, '03658', 'Poltava', 'Peromohy', '30', 'Olha.Svavenko@gmail.com', '089-200-14-78', '2001-06-19'),
                                                                                                                  ('Roman', 'Okuta', 'chef', 8000, '01125', 'Rivne', 'Svyatoshynska', '78', 'Roman.Okuta@ukr.net', '050-785-01-03', '2003-07-25'),
                                                                                                                  ('Stepan', 'Zhytovoz', 'policeman', 6000, '05893', 'Lviv', 'Sahaydachnoho', '44', 'Stepan.Zhytovoz@yahoo.com', '063-002-45-96', '1980-09-22'),
                                                                                                                  ('Oleh', 'Demchuk', 'hairdresser', 3000, '04578', 'Uzhgorod', 'Khreschatyk', '66', 'Oleh.Demchuk@gmail.com', '089-045-60-63', '1970-11-02'),
                                                                                                                  ('Viktor', 'Brovar', 'scientist', 4500, '54123', 'Kyiv', 'Lobanovskoho', '3', 'Viktor.Brovar@ukr.net', '045-100-63-55', '1857-04-16'),
                                                                                                                  ('Viktoria', 'Illushyn', 'clown', 4500, '21587', 'Luhansk', 'Umanska', '36', 'Viktoria.Illushyn@yahoo.com', '055-401-22-22', '1996-12-06'),
                                                                                                                  ('Serhii', 'Borovchenko', 'football player', 11000, '28523', 'Odesa', 'Garna', '7 A', 'Serhii.Borovchenko@gmail.com', '096-003-99-54', '1970-03-18'),
                                                                                                                  ('Mark', 'Borodavka', 'conductor', 2500, '00154', 'Saky', 'Kvitucha', '50', 'Mark.Borodavka@ukr.net', '073-231-12-12', '1988-08-20'),
                                                                                                                  ('Maxym', 'Hryb', 'cleaner', 2600, '12576', 'Kherson', 'Solomyanska', '99', 'Maxym.Hryb@yahoo.com', '036-252-21-24', '1975-09-09'),
                                                                                                                  ('Maryna', 'Kalyna', 'musician', 3500, '84225', 'Kramatorsk', 'Boryspilska', '104', 'Maryna.Kalyna@gmail.com', '041-405-63-00', '2002-01-20'),
                                                                                                                  ('Galyna', 'Kulyk', 'policewoman', 5500, '25824', 'Uman', 'Evreyska', '65', 'Galyna.Kulyk@ukr.net', '025-789-12-65', '2003-08-17'),
                                                                                                                  ('Yevhen', 'Pokrova', 'engineer', 7000, '30256', 'Dnipro', 'Futbolna', '10', 'Yevhen.Pokrova@yahoo.com', '011-968-33-00', '1991-08-18'),
                                                                                                                  ('Vasyl', 'Prokopchuk', 'worker', 5500, '77804', 'Kharkiv', 'Kyivska', '3', 'Vasyl.Prokopchuk@gmail.com', '088-561-02-70', '1996-11-19'),
                                                                                                                  ('Petro', 'Voloshyn', 'butcher', 3500, '05268', 'Vinnytsa', 'Garna', '7-B', 'petro.voloshyn@ukr.net', '077-589-20-11', '2012-02-21');
