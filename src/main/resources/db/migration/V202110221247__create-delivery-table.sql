create table Delivery
(
	id bigint not null auto_increment,
    delivery_client_id bigint not null,
    tax decimal(10,2) not null,
    status varchar(20) not null,
    date_solicitation datetime not null,
    date_completion datetime,
    
    remittee_name varchar(30) not null,
    remittee_public_palce varchar(255) not null,
    remittee_number varchar(30) not null,
    remittee_complement varchar(60) not null,
    remittee_district varchar(30) not null,
    
    primary key(id)
);

alter table delivery add constraint fk_delivery_client
foreign key(delivery_client_id) references logclient (clientId);