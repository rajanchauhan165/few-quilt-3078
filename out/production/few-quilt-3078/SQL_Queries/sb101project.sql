mysql> create table Course(id int primary key, name varchar(12) not null, fees int not null);
Query OK, 0 rows affected (0.05 sec)

mysql> select * from course;
+------+------+------+
| id   | name | fees |
+------+------+------+
| 1000 | Java | 5000 |
+------+------+------+
1 row in set (0.00 sec)

mysql> select * from course;
+------+------+------+
| id   | name | fees |
+------+------+------+
| 1000 | Java | 6000 |
+------+------+------+
1 row in set (0.00 sec)

mysql> select * from course;
+------+--------+------+
| id   | name   | fees |
+------+--------+------+
| 1000 | Java   | 6000 |
| 1200 | Python | 3000 |
+------+--------+------+
2 rows in set (0.00 sec)

mysql> select * from course;
+------+------+------+
| id   | name | fees |
+------+------+------+
| 1000 | Java | 6000 |
+------+------+------+
1 row in set (0.00 sec)