create database FinalJava;
use FinalJava;

create table Usuarios(
Id int primary key auto_increment,
Nombre varchar(70),
Apellido varchar(70),
Usuario nvarchar(65),
Contraseña nvarchar(76),
Telefono nvarchar(22),
Correo nvarchar(80)
);

create table Productos(
IdProductos int primary key auto_increment,
NombreProductos varchar(140),
MarcaProductos varchar(140),
CategoriaProductos varchar(140),
PrecioProducto int,
StockProducto int
);

insert into productos values(0,'Galletas','Danesa','Panaderia',100,8);