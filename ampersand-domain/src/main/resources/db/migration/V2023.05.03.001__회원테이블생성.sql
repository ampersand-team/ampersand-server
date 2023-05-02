create table member
(
    id                bigint       not null auto_increment,
    email             varchar(255) not null unique,
    name              varchar(255) not null,
    profile_image_url varchar(255),
    deleted           bit          not null,
    primary key (id)
);
