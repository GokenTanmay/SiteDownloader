SELECT * FROM new_schema_test1.table1;

use new_schema_test1;

SELECT * FROM table1 where (worker = "") LIMIT 1;

UPDATE `new_schema_test1`.`table1` SET `worker`='wrk2' WHERE (worker = "") LIMIT 10;
UPDATE LOW_PRIORITY `new_schema_test1`.`table1` SET `worker`='' WHERE `worker` = "wrk2" LIMIT 1000;

-- Если указывается ключевое слово LOW_PRIORITY, то выполнение данной команды UPDATE задерживается до тех пор, пока другие клиенты не завершат чтение этой таблицы. 


SELECT * FROM new_schema_test1.table1;