drop table if exists books;
create table books(
    id int primary key auto_increment,
    title varchar(100) not null,
    genre varchar(100),
    yearNum int,
    serialNum varchar(100),
    inStockNum int
)