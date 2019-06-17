# Сервис лайков
## Описание

Микросервис, реализующий функционал работы с базой данных лайков и предоставляющий API для использования другими веб-сервисами 

### Создание базы данных для сервиса лайков

    CREATE TABLE likes (
      id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
      post_id INT NOT NULL,
      user_id INT NOT NULL,
    
      UNIQUE (post_id,user_id)
    )ENGINE = InnoDB;
    
    INSERT INTO likes VALUES (1,1,1);
    INSERT INTO likes VALUES (2,1,2);
    INSERT INTO likes VALUES (3,2,1);
    INSERT INTO likes VALUES (4,2,3);
    INSERT INTO likes VALUES (5,1,3);
    INSERT INTO likes VALUES (6,1,4);

### API

#### Запрос - поставить лайк

    POST localhost:6000/likes
Добавляет указанный пост в список Мне нравится указанного пользователя и возвращает в качестве ответа количество лайков для заданного поста

#### Параметры запроса:
1. post_id - id поста
2. user_id - id пользователя
#### Запрос
	{
		post_id: int
		user_id: int
	}
#### Ответ
	{
		like_count: int
	}
#### Пример запроса
#### Запрос
	POST /likes HTTP/1,1
	HOST: localhost:6000
	Content-Type application/json

	    {
	      "post_id": 654321,
	      "user_id": 123456
	    }
#### Ответ
	{
		"likes_count": 43
	}

#### Запрос - количество лайков
	GET /likes/{post_id}
Возвращает количество лайков и список идентификаторов пользователей, которые отметили заданный пост "Мне нравится"
#### Параметра запроса
1. {post_id} - id поста, для которого запрашивается информация о лайках

#### Запрос  
	GET /likes/{post_id}
#### Ответ
	{
		likes_count: int,
		user_id: array of int
	}
#### Пример запроса
#### Запрос
	GET /likes/12 HTTP/1.1
	HOST: localhost:6000
#### Ответ
	{
		"likes_count":5
		"user_id" [426345003, 60604684, 109235761, 138476014, 189743251]
	}
 #### Запрос - удаление лайка
	DELETE /likes/{post_id}/user/{user_id}
Удаляет указанный пост {post_id} из списка Мне нравится пользователя {user_id}. Возвращает в качестве ответа количество лайков для указанного поста
#### Параметра запроса
1. {post_id} - id поста
2. {user_id} - id пользователя

#### Запрос  
	DELETE /likes/{post_id}/user/{user_id} HTTP/1.1
	HOST: localhost:6000
#### Ответ
	{
		likes_count: int,
	}
#### Пример запроса
#### Запрос
	DELETE /likes/126489/user/348624 HTTP/1.1
	HOST: localhost:6000
#### Ответ
	{
		"likes_count":42
	}
  #### Запрос - проверка ставил ли пользователь лайк
	GET /likes/isLikes/{post_id}/user/{user_id}
Проверяет, находится ли пост {post_id} в списке Мне нравится пользователя {user_id} и возвращает 1, если пост содержится в списке Мне нравится и 0, если не содержится. 
#### Параметра запроса
1. {post_id} - id поста
2. {user_id} - id пользователя

#### Запрос  
	GET /likes/isLiked/{post_id}/user/{user_id} HTTP/1.1
	HOST: localhost:6000
#### Ответ
	{
		liked: boolean [0,1]
	}
	
#### Пример запроса
#### Запрос
	GET /likes/isLiked/126489/user/348624 HTTP/1.1
	HOST: localhost:6000
#### Ответ
	{
		"liked":1
	}
