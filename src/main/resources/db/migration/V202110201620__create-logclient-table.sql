create table LogClient
(
	clientId bigint not null auto_increment,
    clientName varchar(60) not null,
    clientEmail varchar(225) not null,
    clientPhone varchar(20) not null,
    
    primary key(clientId)
);