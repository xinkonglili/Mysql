## 一、DML
### 一、数据插入--insert into
- 1、字段一一对应
```aidl   
INSERT INTO student(`id`,`name`) VALUES ('3','lpvh');

-- 在已有的表中插入字段
ALTER TABLE student ADD `scores` INT(100) DEFAULT 0;

-- 插入一个student
INSERT INTO student(`id`,`name`,`scores`) VALUES('4','JILI','100');

INSERT INTO `student`(`scores`)  VALUES('99') WHERE id = 1;


-- 字段一一对应
INSERT INTO `student`(`id`,`scores`) VALUES ('7','92');

-- 插入多个student，使用逗号分割
INSERT INTO `student`(`id`,`name`,`scores`) VALUES('5','po','97'),('6','ppo','96');
```



### 二、修改数据--update  table set----
- 1、修改单个或者多个属性
```aidl
//1、 修改某个表字段的值，使用关键字update和set，使用where删选条件
UPDATE `student` SET `scores`='100' WHERE id = 1;

//2、不指定条件的情况下，字段scores都会修改为100
UPDATE `student` SET `scores`='100'

//3、修改了多个属性
UPDATE `student` SET `name`='jj',`scores`= '120' WHERE id = 1;

//4、datetime(整数)
ALTER TABLE student ADD `time` datetime(6) DEFAULT NULL;

//5、获取当前时间
UPDATE `student` SET `time`= CURRENT_TIME WHERE id = 1;

```
- 2、modify 和 change 的区别
```aidl
//6、修改某个字段的约束（就是什么类型的）--使用关键字modify
ALTER TABLE `student` MODIFY `time` datetime(5);
//7、change 修改的是字段名称----使用关键字change（必须要写字段类型）
ALTER TABLE `student` CHANGE `time` `timechange` datetime(1);
```

- 运算符（where删选条件--多属性）
    - =
    - ！= （<>）
    - between...and....(都是闭区间) 
    - or
    - and

### 3、删除----delete
- delete：```delete from 表名 where 条件```(不建议delete from 表名)
- truncate ：完全清空一个数据库表，表的结构和索引约束不会变 ``` truncate 表名```
    - 二者区别
        - delete不会影响自增，比如使用delete删除前三条数据，再次添加数据的时候会从id=4开始，这不是我们想要的
        - truncate会影响自增，清空为0，然后开始自增1，2，3；不会影响事务
    - 二者相同点
        - 都不会改变变表的结构，都能删除数据
## 二、DQL（查询数据）***
### （1）、查询
1、查询全部的学生:
``` select * from 表名 ```

2、查询指定的字段--筛选出只有指定字段的全部数据:
``` select '字段名1','字段名2' * from 表名```

3、给表和字段起别名:
``` select '字段名1' as '新名字1','字段名2' as '新名字2' * from 表名1  as '新表名';```

4、函数concat--做连接:
```select councat('列出字段起个名字，用于展示',字段1（注：这里不需要加tab上面的符号）） AS '新名字' from 表名;```


### （2）、数据去重--很多学生参加了很多考试，我们所要的结果只有一个就可以了
- distinct：去重关键字
- ``` select distinct '字段1' from '表名';```

### （3）、数据库的列（表达式）:
```select 表达式 from 表   //文本，列，函数、计算表达式、系统变量```
```aidl
//1、所有学生的考试成绩+1分
select 'studentname', 'studentgrades'+1 as '提分后成绩' from  '表名';

//2、科学计算
select 100-1+5 as '计算结果'; //计算表达式

//3、查询系统版本
select version(); //函数

//4、查询自增步长
select @@auto_increment_increment; //变量
```