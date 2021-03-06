Create Table Usuarios (
	Id int Identity(1,1),
	legajo nvarchar(30) NOT NULL,
	clave nvarchar(30) NOT NULL,
	PRIMARY KEY (Id)
)

Create Table Roles (
	Id int Identity(1,1),
	nombreRole nvarchar(30),
	PRIMARY KEY(Id)
)

Create Table Usuarios_Roles (
	Id int Identity(1,1),
	usuario_id int NOT NULL,
	role_id int NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (usuario_id) REFERENCES Usuarios(Id),
	FOREIGN KEY (role_id) REFERENCES Roles(Id)
)

Create Table Productos (
	codigo int Identity(1,1),
	titulo nvarchar(100) NOT NULL,
	descripcion nvarchar(100),
	precio float NOT NULL,
	PRIMARY KEY (codigo)
)

Create Table Facturas (
	numero int Identity(1,1),
	fecha datetime NOT NULL,
	PRIMARY KEY (numero)
)

Create Table Zonas (
	Id int Identity(1,1),
	zona nvarchar(100),
	PRIMARY KEY (Id)
)

Create Table Clientes (
	Id int Identity(1,1),
	nombre nvarchar(100),
	domicilio nvarchar(100),
	telefono nvarchar(100),
	mail nvarchar(100),
	PRIMARY KEY (Id)
)

Create Table Reclamos (
	Id int Identity(1,1),
	combo_id int NULL,
	tipoReclamo nvarchar(50) NOT NULL,
	descripcion nvarchar(100),
	cliente_id int NOT NULL,
	zona int NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (cliente_id) REFERENCES Clientes(Id),
	FOREIGN KEY (zona) REFERENCES Zonas(Id)
)

Create Table DetalleReclamos (
	Id int Identity(1,1),
	reclamo_id int Not NULL,
	estado int NOT NULL,
	fechaInicio datetime NOT NULL,
	fechaFin datetime NULL,
	comentario nvarchar(100) NULL,
	responsable_id int NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (reclamo_id) REFERENCES Reclamos(Id),
	FOREIGN KEY (responsable_id) REFERENCES Usuarios(Id),
)

Create Table Reclamos_Productos (
	Id int Identity(1,1),
	cantidad int NOT NULL,
	reclamo_id int NOT NULL,
	producto_id int NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (reclamo_id) REFERENCES Reclamos(Id),
	FOREIGN KEY (producto_id) REFERENCES Productos(codigo)
)

Create Table Reclamos_Facturas (
	Id int Identity(1,1),
	reclamo_id int NOT NULL,
	factura_id int NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (reclamo_id) REFERENCES Reclamos(Id),
	FOREIGN KEY (factura_id) REFERENCES Facturas(numero)
)

Create Table Reclamos_Faltantes (
	Id int Identity(1,1),
	cantidad_pedida int NOT NULL,
	cantidad_recibida int NOT NULL,
	reclamo_id int NOT NULL,
	producto_id int NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (reclamo_id) REFERENCES Reclamos(Id),
	FOREIGN KEY (producto_id) REFERENCES Productos(codigo)
)


---post deployment script

create user [A_Interactivas_] for login [A_Interactivas_];
if not exists(select * from sys.sql_logins where name = 'A_Interactivas_')
create login A_Interactivas_ with password = '1234', default_database = Api, check_policy = OFF;
           exec sp_addrolemember N'db_datareader', N'A_Interactivas_';
           exec sp_addrolemember N'db_datawriter', N'A_Interactivas_';
go


Insert Into Usuarios (legajo,clave) Values ('Administrador','uade'),
('UsuarioFacturacion','uade'),
('UsuarioDistribucion','uade'),
('UsuarioEntrega','uade'),
('UsuarioConsulta','uade'),
('UsuarioCallCenter','uade')

Insert Into Roles Values ('Administrador'),
('Facturacion'),
('Distribucion'),
('Entrega'),
('Consulta'),
('CallCenter')

Insert Into Usuarios_Roles (usuario_id,role_id) Values
((select Id from Usuarios where legajo = 'Administrador'),(select Id from Roles where nombreRole = 'Administrador')),
((select Id from Usuarios where legajo = 'UsuarioFacturacion'),(select Id from Roles where nombreRole = 'Facturacion')),
((select Id from Usuarios where legajo = 'UsuarioDistribucion'),(select Id from Roles where nombreRole = 'Distribucion')),
((select Id from Usuarios where legajo = 'UsuarioEntrega'),(select Id from Roles where nombreRole = 'Entrega')),
((select Id from Usuarios where legajo = 'UsuarioConsulta'),(select Id from Roles where nombreRole = 'Consulta')),
((select Id from Usuarios where legajo = 'UsuarioCallCenter'),(select Id from Roles where nombreRole = 'CallCenter'))


Insert Into Productos Values ('Remera','Remera Blanca',10),
('Pantalon','Pantalon Blanco',20)

Insert Into Facturas Values (GETDATE()),(GETDATE())

Insert Into Zonas Values ('Capital Federal'), ('Lomas de Zamora'), ('Baradero')

Insert Into Clientes Values ('elad','av. sadfas','43315081','eladhaim22@gmail.com')
INSERT Clientes VALUES ('Diego', 'Calle Falsa 123', '12344321', 'diegop@blos.com.ar')

