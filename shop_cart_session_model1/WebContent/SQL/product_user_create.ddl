DROP TABLE user1 CASCADE CONSTRAINTS;
DROP TABLE product1 CASCADE CONSTRAINTS;
/**********************************/
/* Table Name: product1 */
/**********************************/
CREATE TABLE product1(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NOT NULL,
		p_price                       		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		p_image                       		VARCHAR2(100)		 DEFAULT 'images/no_image.jpg'		 NOT NULL,
		p_desc                        		VARCHAR2(200)		 NULL ,
		p_click_count                 		VARCHAR2(10)		 DEFAULT 0		 NOT NULL
);

DROP SEQUENCE product1_p_no_SEQ;
CREATE SEQUENCE product1_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;
/**********************************/
/* Table Name: user1 */
/**********************************/
CREATE TABLE user1(
		userId                        		VARCHAR2(100)		 NULL ,
		password                      		VARCHAR2(100)		 NULL ,
		name                          		VARCHAR2(100)		 NULL ,
		email                         		VARCHAR2(100)		 NULL ,
);
ALTER TABLE product1 ADD CONSTRAINT IDX_product1_PK PRIMARY KEY (p_no);
ALTER TABLE user1 ADD CONSTRAINT IDX_user1_PK PRIMARY KEY (userId);

