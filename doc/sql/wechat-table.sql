-- ΢���û���
CREATE TABLE `wechat_user` (
  `user_id`                int              NOT NULL    AUTO_INCREMENT	 COMMENT '����ID',
  `user_wechatid`          varchar(255)     NOT NULL		             COMMENT '�û�΢��id',
  `user_nickname`          varchar(255)                 	             COMMENT '�û��ǳ�',
  `user_mobile`            varchar(255)                 	             COMMENT '�û��ֻ�',
  `user_email`             varchar(255)                 	             COMMENT '�û�����',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ΢���û���ַ��
CREATE TABLE `wechat_user_address` (
  `address_id`			        int             NOT NULL    AUTO_INCREMENT	   COMMENT '����ID',
  `address_provincename`		varchar(255)    NOT NULL    	               COMMENT 'ʡ������',
  `address_provincecode`		varchar(255)    NOT NULL    	               COMMENT 'ʡ�ݴ���',
  `address_cityname`    		varchar(255)    NOT NULL    	               COMMENT '��������',
  `address_citycode`    		varchar(255)    NOT NULL    	               COMMENT '���д���',
  `address_countyname`      	varchar(255)    NOT NULL    	               COMMENT '��������',
  `address_countycode`      	varchar(255)    NOT NULL    	               COMMENT '���ش���',
  `address_street`          	varchar(255)    NOT NULL    	               COMMENT '�ֵ���ַ',
  `address_name`            	varchar(255)    NOT NULL    	               COMMENT '�ֵ���ַ',
  `address_mobile`          	varchar(255)    NOT NULL    	               COMMENT '�ջ��˵绰',
  `address_default`         	int             NOT NULL    	               COMMENT '�Ƿ�Ĭ�ϵ�ַ,1)�� 0)��',
  `address_userid`          	int             NOT NULL    	               COMMENT '΢���û�������',
PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- �û���Ʒ���۱�
CREATE TABLE `wechat_user_evaluate` (
  `evaluate_id`             int             NOT NULL    AUTO_INCREMENT	   COMMENT '����ID',
  `evaluate_userid`         int             NOT NULL    	      	       COMMENT '΢���û�������',
  `evaluate_content`        varchar(255)    NOT NULL    	               COMMENT '��������',
  `evaluate_star`           int             NOT NULL    	               COMMENT '��������',
  `evaluate_date`           varchar(255)    NOT NULL    	               COMMENT '��������',
  `evaluate_productid`      int             NOT NULL    	               COMMENT '��Ʒ������',
PRIMARY KEY (`evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ����״̬
CREATE TABLE `wechat_order_status` (
  `status_id`               int             NOT NULL    AUTO_INCREMENT	   COMMENT '����ID',
  `status_name`             varchar(255)    NOT NULL    	               COMMENT '״̬����',
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- ����������Ϣ
CREATE TABLE `wechat_order_express` (
  `express_id`              int             NOT NULL    AUTO_INCREMENT	   COMMENT '����ID',
  `express_no`              varchar(255)    NOT NULL    	               COMMENT '��ݵ���',
  `express_companyname`     varchar(255)    NOT NULL    	               COMMENT '��ݹ�˾����',
  `express_amount`          double          NOT NULL    	               COMMENT '��ݳɱ�',
PRIMARY KEY (`express_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- �¶�����
CREATE TABLE `wechat_order` (
  `order_id`                int             NOT NULL    AUTO_INCREMENT	   COMMENT '����ID',
  `order_userid`            int             NOT NULL    	      	       COMMENT '�û�������',
  `order_productid`         int             NOT NULL    	      	       COMMENT '��Ʒ������',
  `order_product_qty`       int             NOT NULL    	      	       COMMENT '��Ʒ����',
  `order_product_amt`       double          NOT NULL    	      	       COMMENT '��Ʒ���',
  `order_date`              varchar(255)    NOT NULL    	               COMMENT '��������',
  `order_addressid`         varchar(255)    NOT NULL    	               COMMENT '��ַ������',
  `order_statusid`          int             NOT NULL    	      	       COMMENT '����״̬',
  `order_payid`             int             NOT NULL    	      	       COMMENT '֧�����������',
  `order_expressid`         int             NOT NULL    	      	       COMMENT '������Ϣ������',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ֧��ƽ̨
CREATE TABLE `wechat_pay_platform` (
  `platform_id`             int             NOT NULL    AUTO_INCREMENT	   COMMENT '����ID',
  `platform_name`           varchar(255)    NOT NULL    	               COMMENT 'ƽ̨����',
PRIMARY KEY (`platform_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ֧�����
CREATE TABLE `wechat_pay` (
  `pay_id`                  int             NOT NULL    AUTO_INCREMENT	   COMMENT '����ID',
  `pay_orderid`             int             NOT NULL    	               COMMENT '����������',
  `pay_orderno`             varchar(255)    NOT NULL    	               COMMENT '�������',
  `pay_platform`            int             NOT NULL    	               COMMENT '֧��ƽ̨������',
  `pay_amount`              double          NOT NULL    	               COMMENT '֧�����',
  `pay_date`                varchar(255)    NOT NULL    	               COMMENT '֧������',
  `pay_platform_tradeno`    varchar(255)    NOT NULL    	               COMMENT '֧��ƽ̨���׺�',
PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ��Ʒ����
CREATE TABLE `wechat_product_spec` (
  `spec_id`                 int             NOT NULL    AUTO_INCREMENT	   COMMENT '����ID',
  `spec_name`               varchar(255)    NOT NULL    	               COMMENT '�������',
  `spec_productid`          int             NOT NULL    	               COMMENT '��Ʒ������',
 PRIMARY KEY (`spec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- ����Ʒ��
CREATE TABLE `wechat_product` (
  `product_id`              int             NOT NULL    AUTO_INCREMENT	   COMMENT '����ID',
  `product_name`            varchar(255)    NOT NULL    	               COMMENT '��Ʒ����',
  `product_describe`        varchar(255)    NOT NULL    	               COMMENT '��Ʒ����',
  `product_price`           double          NOT NULL    	               COMMENT '��Ʒ����',
  `product_purchase_price`  double          NOT NULL    	               COMMENT '��Ʒ�ɱ���',
  `product_imageurl`        varchar(255)    NOT NULL    	               COMMENT '��Ʒ����ͼ·��',
  `product_detailurl`       varchar(255)    NOT NULL    	      	       COMMENT '��Ʒչʾ��ַ',
 PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;



-- ���붩��״̬
insert into wechat_order_status (status_name) values('���ύ');
insert into wechat_order_status (status_name) values('��ȡ��');
insert into wechat_order_status (status_name) values('�Ѹ���');
insert into wechat_order_status (status_name) values('�ѷ���');
insert into wechat_order_status (status_name) values('���ջ�');
insert into wechat_order_status (status_name) values('������');
insert into wechat_order_status (status_name) values('������');

-- ����֧��ƽ̨
insert into wechat_pay_platform (platform_name) values('΢��֧��');
insert into wechat_pay_platform (platform_name) values('֧����֧��');

-- ������Ʒ
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('������Ʒ01','���Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ���',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('������Ʒ02','���Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ���',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('������Ʒ03','���Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ���',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('������Ʒ04','���Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ���',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('������Ʒ05','���Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ���',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');
insert into wechat_product (product_name,product_describe,product_price,product_purchase_price,product_imageurl,product_detailurl) 
values('������Ʒ06','���Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ��Բ���',5.01,3.01,'http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg','www.baidu.com');









