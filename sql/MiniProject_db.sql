CREATE SEQUENCE customer_seq;
CREATE SEQUENCE product_seq;
CREATE SEQUENCE order_seq;
CREATE TABLE customer (
    customer_id             VARCHAR2(20)      CONSTRAINT customer_id_pk         PRIMARY KEY,
    customer_name           VARCHAR2(20)    CONSTRAINT customer_name_nn         NOT NULL,
    customer_birthdate      DATE            CONSTRAINT customer_dirthdate_nn    NOT NULL,
    customer_address        VARCHAR2(50)    CONSTRAINT customer_address_nn      NOT NULL,
    customer_phonenumber    VARCHAR2(15)    CONSTRAINT customer_phone_nn        NOT NULL,
    is_admin                NUMBER(1)       DEFAULT 0   CONSTRAINT customer_is_admin_nn NOT NULL,
    customer_point          NUMBER          DEFAULT 0   CONSTRAINT customer_point_nn    NOT NULL,
    password                VARCHAR2(20)    CONSTRAINT password                 NOT NULL
);
INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point)
values (customer_seq.nextval,'���ؽ�', '1996-05-15', 'asdasdasdad', '010-2376-7945',0,0);

CREATE TABLE product (
    product_id      NUMBER(5)       CONSTRAINT product_id_pk    PRIMARY KEY,
    product_name    VARCHAR2(20)    CONSTRAINT product_name_nn  NOT NULL,
    product_price   NUMBER            CONSTRAINT product_price_nn NOT NULL,
    product_stock   VARCHAR2(20)    CONSTRAINT product_stock_nn NOT NULL
);

CREATE TABLE order_list (
    order_id        NUMBER(5)       CONSTRAINT order_list_order_id_pk      PRIMARY KEY,
    customer_id     NUMBER(5)       CONSTRAINT order_list_customer_id_fk   REFERENCES customer (customer_id),
    order_date      DATE            CONSTRAINT order_date_nn    NOT NULL,
    total_price     NUMBER          CONSTRAINT order_price_nn   NOT NULL,
    delivery_status  VARCHAR2(20)    CONSTRAINT order_delivery_nn    NOT NULL
);

--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point, password)
--values ('qtqt99','���ؽ�', '1996-05-15', '���� ��õ��', '010-2376-7945',0,0,'qocn0430');
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point, password)
--values ('hotguy123','������', '1994-01-15', '���� ���౸', '010-4526-1998',0,0,'guyontop');
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point, password)
--values ('hypeboy5q','������', '2020-06-26', 'õ�� ������', '010-1880-5288',0,550,'06261qq');
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point, password)
--values ('bebe11your','������', '1988-11-25', '���� ���α�', '010-9535-8589',0,300,'123456');
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point, password)
--values ('ffjdgsl','������', '1979-05-01', '�뱸 �޼���', '010-5658-5515',0,30,'wgwg11rr');
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point, password)
--values ('admin','admin', '1999-12-31', 'admin', 'admin',1,0,'admin123');
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point, password)
--values ('jiguem2ya','����ȣ', '1964-08-10', '���� ����', '010-4798-2118',0,0,'tqtqtq5');
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point, password)
--values ('yyyaaah123','�̿���', '1990-04-03', '������ ������', '010-5521-6398',0,2,'lee1');

--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'����ݸ�', 1500, 15);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'���(3)', 2100, 9);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'�����̹���', 2000, 20);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'����(��)', 3500, 11);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'����(��)', 1900, 9);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'����(��)', 8700, 5);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'����(��)', 5000, 20);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'��纣��(��)', 4000, 18);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'�ٳ���', 5600, 16);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'����(3)', 2500, 14);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'��õ ��', 54000, 22);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'����', 1200, 11);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'�ᳪ��', 1700, 10);

CREATE TABLE cart (
    customer_id     NUMBER(5)       CONSTRAINT customer_id_fk  REFERENCES customer (customer_id),
    product_id      NUMBER(5)       CONSTRAINT product_id_fk   REFERENCES product (product_id),
    product_count   NUMBER          CONSTRAINT cart_count_nn   NOT NULL
);
CREATE TABLE order_detail (
    customer_id     NUMBER(5)       REFERENCES customer (customer_id),
    order_id        NUMBER(5)       REFERENCES order_list (order_id),
    product_id      NUMBER(5)       REFERENCES product (product_id),
    product_count   NUMBER          NOT NULL
);
--�����ϱ� ������
--��ٱ��Ͽ� ��� ���� ��������
--select * from cart where customer_id = ?
--��ü��ǰ ��� - ��ٱ��Ͽ� ��� �� ��ǰ�� ���� update
--update product set product_stock = product_stock - ? where product_id = ?
--��ٱ��Ͽ� ��� ��ǰ ���� * ������ �� �� �ݾ� ���ϱ�
--select sum(price) as sprice from (select p.product_price * c.product_count as price from cart c join product p on c.product_id = p.product_id) where customer_id = ?
--order_list�� �ֹ� ����
--insert into order_list (order_id, customer_id, order_date, total_price, delivery_status) values(order_seq.nextval,?,?,?,?)
--�ֱٿ� ���Ե� order_id ��������
--select order_id from (select * from order_list order by order_id desc) where rownum = 1
--order_detail�� �� ����
--insert into order_detail (order_id, customer_id, product_id, product_count values(?,?,?,?)
--customer ���̺� ������ update
--update customer set customer_point=? * 0.95 where customer_id=?