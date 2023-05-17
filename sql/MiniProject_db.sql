CREATE SEQUENCE customer_seq;
CREATE SEQUENCE product_seq;
CREATE SEQUENCE order_seq;
CREATE TABLE customer (
    customer_id             NUMBER(5)       CONSTRAINT customer_id_pk           PRIMARY KEY,
    customer_name           VARCHAR2(20)    CONSTRAINT customer_name_nn         NOT NULL,
    customer_birthdate      DATE            CONSTRAINT customer_dirthdate_nn    NOT NULL,
    customer_address        VARCHAR2(50)    CONSTRAINT customer_address_nn      NOT NULL,
    customer_phonenumber    VARCHAR2(15)    CONSTRAINT customer_phone_nn        NOT NULL,
    is_admin                NUMBER(1)       DEFAULT 0   CONSTRAINT customer_is_admin_nn NOT NULL,
    customer_point          NUMBER          DEFAULT 0   CONSTRAINT customer_point_nn    NOT NULL
);
INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point)
values (customer_seq.nextval,'엄준식', '1996-05-15', 'asdasdasdad', '010-2376-7945',0,0);

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

--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point)
--values (customer_seq.nextval,'고지원', '1994-01-15', '대전 은행구', '010-4526-1998',0,0);
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point)
--values (customer_seq.nextval,'배종식', '2020-06-26', '천안 두정동', '010-1880-5288',0,550);
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point)
--values (customer_seq.nextval,'신은비', '1988-11-25', '서울 종로구', '010-9535-8589',0,300);
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point)
--values (customer_seq.nextval,'김진우', '1979-05-01', '대구 달성구', '010-5658-5515',0,30);
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point)
--values (customer_seq.nextval,'admin', '1999-12-31', 'admin', 'admin',1,0);
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point)
--values (customer_seq.nextval,'조성호', '1964-08-10', '대전 서구', '010-4798-2118',0,0);
--INSERT INTO customer (customer_id,customer_name,customer_birthdate,customer_address, customer_phonenumber, is_admin, customer_point)
--values (customer_seq.nextval,'이연아', '1990-04-03', '수원시 망포동', '010-5521-6398',0,2);

--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'브로콜리', 1500, 15);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'당근(3)', 2100, 9);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'새송이버섯', 2000, 20);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'양파(중)', 3500, 11);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'양파(소)', 1900, 9);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'양파(대)', 8700, 5);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'딸기(팩)', 5000, 20);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'블루베리(팩)', 4000, 18);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'바나나', 5600, 16);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'오이(3)', 2500, 14);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'이천 쌀', 54000, 22);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'숙주', 1200, 11);
--INSERT INTO product (product_id,product_name,product_price,product_stock)
--values (product_seq.nextval,'콩나물', 1700, 10);

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
commit;