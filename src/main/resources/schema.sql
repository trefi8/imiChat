create schema if not exists CHAT;

create table CHATMESSAGE
(
	ID BIGINT auto_increment,
	MESSAGETYPE VARCHAR2,
	CONTENT VARCHAR,
	SENDER VARCHAR,
	constraint CHATMESSAGE_PK
		primary key (ID)
);