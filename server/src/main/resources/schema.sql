-- create schema club;

create table member
(
    member_id int auto_increment,
    name varchar(200) not null,
    email varchar(200) not null,
    constraint member_pk
        primary key (member_id)
);

create unique index member_email_uindex
    on member (email);



create table event
(
    event_id int auto_increment,
    title varchar(200) not null,
    event_date timestamp not null,
    host_id int not null,
    location varchar(200) not null,
    description varchar(1000) not null,
    constraint event_pk
        primary key (event_id),
    constraint event_member_member_id_fk
        foreign key (host_id) references member (member_id)
);

create table registration
(
    registration_id int auto_increment,
    member_id int not null,
    event_id int not null,
    constraint registration_pk
        primary key (registration_id),
    constraint registration_pk_2
        unique (event_id, member_id),
    constraint registration_event_id_event_id_fk
        foreign key (event_id) references event (event_id),
    constraint registration_member_member_id_fk
        foreign key (member_id) references member (member_id)
);
