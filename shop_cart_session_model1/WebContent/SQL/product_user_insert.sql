insert into user1(userid,password,name,email) values('guard1','1111','김경호1','guard1@korea.com');
insert into user1(userid,password,name,email) values('guard2','2222','김경호2','guard2@korea.com');
insert into user1(userid,password,name,email) values('guard3','3333','김경호3','guard3@korea.com');
insert into product1 values(product1_p_no_SEQ.nextval, '비글', 550000, 'bigle.gif','기타 상세 정보 등...', 0);
insert into product1 values(product1_p_no_SEQ.nextval, '달마시안', 500000, 'dalma.gif','기타 상세 정보 등...', 0);
insert into product1 values(product1_p_no_SEQ.nextval, '퍼그', 400000, 'pug.gif','기타 상세 정보 등...', 0);
insert into product1 values(product1_p_no_SEQ.nextval, '페키니즈', 450000, 'pekiniz.gif','기타 상세 정보 등...', 0);
select * from product1;
commit;
