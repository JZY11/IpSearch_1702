DROP DATABASE IF EXISTS db_ip;
CREATE DATABASE db_ip;

DROP TABLE IF EXISTS db_ip.search;
CREATE TABLE db_ip.search(
  id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID PK',
  min VARCHAR(255) COMMENT '起始ip',
  max VARCHAR(255) COMMENT '终止ip',
  geo VARCHAR(255) COMMENT '地理位置'
)COMMENT 'ip查询表';

INSERT db_ip.search VALUE (NULL ,'1.0.1.0','1.0.3.255','福建省 电信');
INSERT db_ip.search VALUE (NULL ,'1.1.8.0','1.1.63.255','广东省 电信');
INSERT db_ip.search VALUE (NULL ,'1.26.32.0','1.26.95.255','内蒙古 联通');
INSERT db_ip.search VALUE (NULL ,'1.51.64.0','1.51.111.255','安徽省合肥市 教育网');

SELECT *
FROM db_ip.search;