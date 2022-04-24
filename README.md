# Homework 12
1) Установить ActiveMQ. Написать два приложения: одно отправляет текст в очередь, другое читает его и выводит в консоль.
2) То же самое для Kafka.

## Решение
Приложение с ActiveMQ - `training-project`.
Приложение с Kafka - `kafka`.



### ActiveMQ
Запускаем ActiveMQ. Отправляем сообщение через `JmsTemplate`:

![alt](screenshots/activemq_send.png)

Проверяем, что указанный топик `messageQueue` создался:

![alt](screenshots/message_queue.png)

Вывод в лог:

![alt](screenshots/activemq_get.png)



### Kafka
Запускаем ZooKeeper. Запускаем Kafka. Отправляем сообщение с `id="1"` и `message="message1"` через `KafkaTemplate`:

![alt](screenshots/kafka_send.png)

Вывод в лог:

![alt](screenshots/kafka_get.png)
