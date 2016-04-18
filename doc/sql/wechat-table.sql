-- 微信用户表
CREATE TABLE `wechat_user` (
  `user_id`                int              NOT NULL    AUTO_INCREMENT	 COMMENT '主键ID',
  `user_wechatid`          varchar(255)     NOT NULL		             COMMENT '用户微信id',
  `user_nickname`          varchar(255)                 	             COMMENT '用户昵称',
  `user_mobile`            varchar(255)                 	             COMMENT '用户手机',
  `user_email`             varchar(255)                 	             COMMENT '用户邮箱',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 微信用户地址表
CREATE TABLE `wechat_user_address` (
  `address_id`			        int             NOT NULL    AUTO_INCREMENT	   COMMENT '主键ID',
  `address_provincename`		varchar(255)    NOT NULL    	               COMMENT '省份名称',
  `address_provincecode`		varchar(255)    NOT NULL    	               COMMENT '省份代码',
  `address_cityname`    		varchar(255)    NOT NULL    	               COMMENT '城市名称',
  `address_citycode`    		varchar(255)    NOT NULL    	               COMMENT '城市代码',
  `address_countyname`      	varchar(255)    NOT NULL    	               COMMENT '区县名称',
  `address_countycode`      	varchar(255)    NOT NULL    	               COMMENT '区县代码',
  `address_street`          	varchar(255)    NOT NULL    	               COMMENT '街道地址',
  `address_name`            	varchar(255)    NOT NULL    	               COMMENT '街道地址',
  `address_mobile`          	varchar(255)    NOT NULL    	               COMMENT '收货人电话',
  `address_default`         	int             NOT NULL    	               COMMENT '是否默认地址,1)是 0)否',
  `address_userid`          	int             NOT NULL    	               COMMENT '微信用户表主键',
PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 用户商品评价表
CREATE TABLE `wechat_user_evaluate` (
  `evaluate_id`             int             NOT NULL    AUTO_INCREMENT	   COMMENT '主键ID',
  `evaluate_userid`         int             NOT NULL    	      	       COMMENT '微信用户表主键',
  `evaluate_content`        varchar(255)    NOT NULL    	               COMMENT '评价内容',
  `evaluate_star`           int             NOT NULL    	               COMMENT '评价星数',
  `evaluate_date`           varchar(255)    NOT NULL    	               COMMENT '评价日期',
  `evaluate_productid`      int             NOT NULL    	               COMMENT '商品表主键',
PRIMARY KEY (`evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 订单状态
CREATE TABLE `wechat_order_status` (
  `status_id`               int             NOT NULL    AUTO_INCREMENT	   COMMENT '主键ID',
  `status_name`             varchar(255)    NOT NULL    	               COMMENT '状态名称',
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- 订单物流信息
CREATE TABLE `wechat_order_express` (
  `express_id`              int             NOT NULL    AUTO_INCREMENT	   COMMENT '主键ID',
  `express_no`              varchar(255)    NOT NULL    	               COMMENT '快递单号',
  `express_companyname`     varchar(255)    NOT NULL    	               COMMENT '快递公司名称',
  `express_amount`          double          NOT NULL    	               COMMENT '快递成本',
PRIMARY KEY (`express_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 新订单表
CREATE TABLE `wechat_order` (
  `order_id`                int             NOT NULL    AUTO_INCREMENT	   COMMENT '主键ID',
  `order_userid`            int             NOT NULL    	      	       COMMENT '用户表主键',
  `order_productid`         int             NOT NULL    	      	       COMMENT '商品表主键',
  `order_product_qty`       int             NOT NULL    	      	       COMMENT '商品数量',
  `order_product_amt`       double          NOT NULL    	      	       COMMENT '商品金额',
  `order_date`              varchar(255)    NOT NULL    	               COMMENT '订单日期',
  `order_addressid`         varchar(255)    NOT NULL    	               COMMENT '地址表主键',
  `order_statusid`          int             NOT NULL    	      	       COMMENT '订单状态',
  `order_payid`             int             NOT NULL    	      	       COMMENT '支付存根表主键',
  `order_expressid`         int             NOT NULL    	      	       COMMENT '物流信息表主键',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 支付平台
CREATE TABLE `wechat_pay_platform` (
  `platform_id`             int             NOT NULL    AUTO_INCREMENT	   COMMENT '主键ID',
  `platform_name`           varchar(255)    NOT NULL    	               COMMENT '平台名称',
PRIMARY KEY (`platform_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 支付存根
CREATE TABLE `wechat_pay` (
  `pay_id`                  int             NOT NULL    AUTO_INCREMENT	   COMMENT '主键ID',
  `pay_orderid`             int             NOT NULL    	               COMMENT '订单表主键',
  `pay_orderno`             varchar(255)    NOT NULL    	               COMMENT '订单编号',
  `pay_platform`            int             NOT NULL    	               COMMENT '支付平台表主键',
  `pay_amount`              double          NOT NULL    	               COMMENT '支付金额',
  `pay_date`                varchar(255)    NOT NULL    	               COMMENT '支付日期',
  `pay_platform_tradeno`    varchar(255)    NOT NULL    	               COMMENT '支付平台交易号',
PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- 商品规格表
CREATE TABLE `wechat_product_spec` (
  `spec_id`                 int             NOT NULL    AUTO_INCREMENT	   COMMENT '主键ID',
  `spec_name`               varchar(255)    NOT NULL    	               COMMENT '规格描述',
  `spec_productid`          int             NOT NULL    	               COMMENT '商品表主键',
 PRIMARY KEY (`spec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- 新商品表
CREATE TABLE `wechat_product` (
  `product_id`              int             NOT NULL    AUTO_INCREMENT	   COMMENT '主键ID',
  `product_name`            varchar(255)    NOT NULL    	               COMMENT '商品名称',
  `product_describe`        varchar(255)    NOT NULL    	               COMMENT '商品描述',
  `product_price`           double          NOT NULL    	               COMMENT '商品单价',
  `product_purchase_price`  double          NOT NULL    	               COMMENT '商品成本价',
  `product_imageurl`        varchar(255)    NOT NULL    	               COMMENT '商品封面图路径',
  `product_detailurl`       varchar(255)    NOT NULL    	      	       COMMENT '商品展示地址',
 PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;



-- 插入订单状态
insert into wechat_order_status (status_name) values('已提交');
insert into wechat_order_status (status_name) values('已取消');
insert into wechat_order_status (status_name) values('已付款');
insert into wechat_order_status (status_name) values('已发货');
insert into wechat_order_status (status_name) values('已收货');
insert into wechat_order_status (status_name) values('待评价');
insert into wechat_order_status (status_name) values('已评价');

-- 插入支付平台
insert into wechat_pay_platform (platform_name) values('微信支付');
insert into wechat_pay_platform (platform_name) values('支付宝支付');

-- 插入商品
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('测试商品01','测试测试测试测试测试测试测试测试测试测试',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('测试商品02','测试测试测试测试测试测试测试测试测试测试',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('测试商品03','测试测试测试测试测试测试测试测试测试测试',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('测试商品04','测试测试测试测试测试测试测试测试测试测试',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('测试商品05','测试测试测试测试测试测试测试测试测试测试',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('测试商品06','测试测试测试测试测试测试测试测试测试测试',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');









