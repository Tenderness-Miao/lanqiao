use shiyanlou;
drop table if exists tb_user;
create table tb_user(
    user_id int(11) not null,
    user_name varchar(20) default null,
    user_age int(11) default null,
    primary key (user_id)
) engine = InnoDB;