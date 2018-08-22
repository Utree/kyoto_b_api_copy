USE kyotob;

-- Table 1: ルーム情報を格納するテーブルを作成
CREATE TABLE `rooms` (
  `room_id` int NOT NULL AUTO_INCREMENT,
  `room_name` varchar(20) NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Table 3: ユーザー情報を格納するテーブルを作成
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL UNIQUE,
  `user_screen_name` varchar(20) NOT NULL,
  `password` char(64) NOT NULL,
  -- `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  -- `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- サンプルレコードの挿入
INSERT INTO `users` (`user_name`, `user_screen_name`, `password`) VALUES ('kodai', 'Matsumoto Kodai', 'E47089C9E704B549DD596AFD4345349A07533A0DD5021FB56D666DDB728B84C2');

-- Table 4: 1対1ルームの情報を格納するテーブルを作成
CREATE TABLE `pairs` (
  `room_id` int NOT NULL AUTO_INCREMENT,
  `user_id_1` int NOT NULL,
  `user_id_2` int NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Table 5: メッセージの情報を格納するテーブルを作成
CREATE TABLE `messages` (
  `message_id` int NOT NULL AUTO_INCREMENT,
  `sender_id` int NOT NULL,
  `room_id` int NOT NULL,
  `content` varchar(140) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Table 6:アクセストークン
CREATE TABLE `tokens` (
  `user_id` int NOT NULL,
  `token` varchar(200) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
