select * from employees order by EMPLOYEE_ID; --Ctrl+Enter
insert into employees values (300, 'JinKyeong', 'Heo','HEOJK' ,'010-111-2222', sysdate, 'IT_PROG', 10000, null, 103, 60);
commit;


create table users(
    userid varchar2 (50) primary key,
    username varchar2 (50) not null,
    userpassword varchar2 (50) not null,
    userage number(3) not null,
    useremail varchar2 (50) not null
);

create table boards (
    bno     number      primary key,
    btitle  varchar2(100) not null,
    bcontent clob       not null,
    bwriter varchar2(50) not null,
    bdate   date        default sysdate,
    bfilename varchar2(50) null,
    bfiledata blob  null
);
create sequence SEQ_BNO NOCACHE;

create table accounts (
    ano varchar(20) primary key,
    owner varchar(20) not null,
    balance number not null
);

insert into accounts (ano, owner, balance) values('111-1111-1111', '하여름', 100000);

insert into accounts (ano, owner, balance) values('222-222-2222', '한겨울', 0);

commit;

create or replace procedure user_create(
    a_userid IN users.userid%TYPE,
    a_username IN users.username%TYPE,
    a_userpassword IN users.userpassword%TYPE,
    a_userage IN users.userage%TYPE,
    a_useremail IN users.useremail%TYPE,
    a_rows OUT PLS_INTEGER
)
is
begin
    insert into users(userid, username, userpassword, userage,useremail)
    values (a_userid, a_username, a_userpassword, a_userage, a_useremail);
    commit;
end;

create or replace function user_login(
    a_userid    users.userid%TYPE,
    a_userpassword users.userpassword%TYPE
) RETURN PLS_INTEGER
IS
    v_userpassword users.userpassword%type;
    v_result PLS_INTEGER;
BEGIN
    SELECT userpassword INTO v_userpassword
    FROM users
    WHERE userid = a_userid;
    
    if v_userpassword = a_userpassword then
        return 0;
    else
        return 1;
    end if;
exception
    when no_data_found then
        return 2;
end;

drop table users;

select * from users;