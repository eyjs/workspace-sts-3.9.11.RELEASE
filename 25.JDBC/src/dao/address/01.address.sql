drop table address;
create table address (
		no number(4) primary key,
		id varchar2(20),
		name varchar2(20),
		phone varchar2(15),
		address varchar2(60)
);
drop sequence address_no_seq;
create sequence address_no_seq
start with 1;

DESC address;

--insert into address values(1,'xxx','±è°æÈ£','010-123-4567','°æ±âµµ¹Î');
insert into address values(address_no_seq.nextval,'xxx'||address_no_seq.currval,'±è°æÈ£','010-123-4567','°æ±âµµ¹Î');

update address set address='¼­¿ï½Ã¹Î' where no = 5;
update address set name='°í¼Ò¹Ì',phone='888-8888',address='Ãæ³² ÅÂ¾È' where no=5;

delete from address where no=3;


select no,id,name,phone,address from address;
select no,id,name,phone,address from address where no=1;


desc address;

commit;




