CREATE SEQUENCE  item_seq nocache; 
CREATE SEQUENCE  member_seq nocache; 
CREATE SEQUENCE  grade_seq nocache; 
CREATE SEQUENCE  order_seq nocache; 
CREATE SEQUENCE  order_detail_seq nocache; 

--상품
CREATE TABLE item (
  item_no number PRIMARY KEY, --상품id
  item_name varchar2(100) NOT NULL, --상품명
  price number NOT NULL, --가격
  stock number DEFAULT 0, --재고
  info varchar2(250) --설명
);

--등급
CREATE TABLE grade (
  grade_no number PRIMARY KEY, --등급id
  grade_name varchar2(20) NOT NULL, --등급
  rate NUMBER NOT NULL, --적립율
  standard number NOT NULL --기준금액
);

--회원
CREATE TABLE member (
  member_no number PRIMARY KEY, --회원id
  phone varchar2(14) UNIQUE NOT NULL, --전화번호
  point number DEFAULT 0, --포인트
  grade NUMBER REFERENCES grade(grade_no) --등급
);

--주문
CREATE TABLE orders (
  order_no number PRIMARY KEY, --주문id
  member_no number NOT NULL REFERENCES MEMBER(member_no), --회원id
  order_date date DEFAULT sysdate, --주문일자
  payment number --결제금액
);

--주문상세
CREATE TABLE order_detail (
  detail_no number PRIMARY KEY, --주문상세id
  order_no number NOT NULL REFERENCES orders(order_no), --주문id
  item_no number NOT NULL REFERENCES item(item_no), --상품id
  qty number --주문개수
);