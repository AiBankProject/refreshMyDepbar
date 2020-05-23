-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Май 23 2020 г., 01:34
-- Версия сервера: 10.4.11-MariaDB
-- Версия PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `ozgertu`
--

-- --------------------------------------------------------

--
-- Структура таблицы `credit`
--

CREATE TABLE `credit` (
  `who` int(11) NOT NULL,
  `sum` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `deposit`
--

CREATE TABLE `deposit` (
  `who` varchar(120) NOT NULL,
  `sum` int(11) NOT NULL,
  `percent` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `deposit`
--

INSERT INTO `deposit` (`who`, `sum`, `percent`, `month`, `date`) VALUES
('q', 1000000, 12, 12, '2020-05-22 20:57:01'),
('q', 999999, 12, 6, '2020-05-22 21:12:28'),
('az', 10000000, 12, 12, '2020-05-22 21:22:40'),
('az', 100, 12, 55, '2020-05-22 21:27:41');

-- --------------------------------------------------------

--
-- Структура таблицы `transfer`
--

CREATE TABLE `transfer` (
  `who` int(11) NOT NULL,
  `towhom` int(11) NOT NULL,
  `howmany` int(11) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `transfer`
--

INSERT INTO `transfer` (`who`, `towhom`, `howmany`, `date`) VALUES
(0, 12345, 1000, '2012-01-19 00:00:00'),
(123, 444, 444, '2020-05-22 02:27:26'),
(12345, 1111, 111, '2020-05-22 02:28:58'),
(12345, 1111, 111, '2020-05-22 02:29:04'),
(123, 555, 555, '2020-05-22 02:33:26'),
(12345, 77, 77, '2020-05-22 02:34:38'),
(111, 88, 88, '2020-05-22 02:40:57'),
(111, 0, 0, '2020-05-22 02:43:05'),
(123, 4, 4, '2020-05-22 02:43:35'),
(123, 1, 1, '2020-05-22 03:13:15'),
(123, 777, 777, '2020-05-22 04:06:51'),
(0, 88, 88, '2020-05-22 04:17:23'),
(88888, 637, 3837, '2020-05-22 04:27:53'),
(99999, 1, 1, '2020-05-22 04:30:24'),
(888, 99, 99, '2020-05-22 11:56:00'),
(123, 123, 888, '2020-05-22 16:53:11'),
(12345, 12345, 1, '2020-05-22 16:55:03'),
(59060, 123, 500, '2020-05-22 17:16:28'),
(12345, 55, 33, '2020-05-22 17:37:16'),
(123, 111, 500, '2020-05-22 18:05:00'),
(59060, 123, 500, '2020-05-22 18:07:55'),
(123, 59060, 1000, '2020-05-22 18:15:54'),
(59060, 59060, 500, '2020-05-22 18:22:02'),
(123, 88888, 500, '2020-05-22 18:23:25'),
(123, 88888, 200, '2020-05-22 18:26:05'),
(123, 59060, 300, '2020-05-22 18:52:28'),
(88888, 123, 400, '2020-05-23 03:16:52'),
(88888, 123, 200, '2020-05-23 03:17:41'),
(59060, 99999, 300, '2020-05-23 03:20:53'),
(59060, 888, 500, '2020-05-23 05:26:00'),
(59060, 888, 200, '2020-05-23 05:27:16'),
(888, 123, 300, '2020-05-23 05:31:24');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `login` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `role` varchar(200) NOT NULL,
  `numberCard` int(11) NOT NULL,
  `cvc` int(11) NOT NULL,
  `balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `name`, `role`, `numberCard`, `cvc`, `balance`) VALUES
(1, 'aibo012', '1234', 'aibo', 'USER', 0, 0, 0),
(2, 'ai', 'ai', 'ai', 'USER', 0, 0, 0),
(3, 'az', 'az', 'az', 'USER', 12345, 123, 1179),
(4, 'aidar01', 'aidar', 'aidar', 'USER', 23456, 123, 0),
(5, 'm', 'm', 'muxa', 'USER', 88888, 888, 100),
(6, 'q', 'q', 'q', '', 123, 123, 900),
(7, 'aibo12', '12345', 'Aibolat', 'USER', 12345, 123, -33),
(8, 'aaa', 'aaa', 'aaa', 'USER', 111, 111, 0),
(9, 's', 's', 's', 'USER', 99999, 999, 300),
(10, 'aw', 'aw', 'aw', 'USER', 888, 123, 400),
(11, 'qaz', 'qaz', 'Qazbek', 'USER', 59060, 123, 300);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
