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

Create Table Producto (
	codigo int Identity(1,1),
	titulo nvarchar(100) NOT NULL,
	descripcion nvarchar(100),
	precio int NOT NULL,
	PRIMARY KEY (codigo)
)

Create Table Factura (
	numero int Identity(1,1),
	fecah datetime NOT NULL,
	PRIMARY KEY (numero)
)

Create Table Cliente (
	Id int Identity(1,1),
	nombre nvarchar(100),
	domicilio nvarchar(100),
	telefono nvarchar(100),
	mail nvarchar(100),
	PRIMARY KEY (Id)
)

Create Table Combo(
	Id int Identity(1,1),
	PRIMARY KEY(Id)
)

Create Table Reclamo(
	Id int Identity(1,1),
	combo_id int NULL,
	tipoReclamo nvarchar(50) NOT NULL,
	fechaCreacion datetime NOT NULL,
	fechaCierre datetime NOT NULL,
	descripcion nvarchar(100),
	cliente_id int NOT NULL,
	estado int NOT NULL,
	zona nvarchar(100) NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (cliente_id) REFERENCES Cliente(Id),
	FOREIGN KEY (combo_id) REFERENCES Combo(Id)
)

Create Table Reclamo_Producto(
	Id int Identity(1,1),
	reclamo_id int NOT NULL,
	producto_id int NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (reclamo_id) REFERENCES Reclamo(Id), 
	FOREIGN KEY (producto_id) REFERENCES Producto(codigo) 
)

Create Table Reclamo_Factura(
	Id int Identity(1,1),
	reclamo_id int NOT NULL,
	factura_id int NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (reclamo_id) REFERENCES Reclamo(Id), 
	FOREIGN KEY (factura_id) REFERENCES Factura(numero) 
)


---post deployment script

create user [A_Interactivas_] for login [A_Interactivas_];
if not exists(select * from sys.sql_logins where name = 'A_Interactivas_')
create login A_Interactivas_ with password = '1234', default_database = Api, check_policy = OFF;
           exec sp_addrolemember N'db_datareader', N'A_Interactivas_';
           exec sp_addrolemember N'db_datawriter', N'A_Interactivas_';
go


Insert Into Usuarios (legajo,clave) Values ('Administrador','Administrador'),
('UsuarioFacturacion','UsuarioFacturacion'),
('UsuarioDistribucion','UsuarioDistribucion'),
('UsuarioEntrega','UsuarioEntrega'),
('UsuarioConsulta','UsuarioConsulta'),
('UsuarioCallCenter','UsuarioCallCenter')

Insert Into Roles Values ('Administrador'),
('Facturtacion'),
('Distrubucion'),
('Entrega'),
('Consulta'),
('CallCenter')

Insert Into Usuarios_Roles (usuario_id,role_id) Values 
((select Id from Usuarios where legajo = 'Administrador'),(select Id from Roles where nombreRole = 'Administrador')),
((select Id from Usuarios where legajo = 'UsuarioFacturacion'),(select Id from Roles where nombreRole = 'Facturtacion')),
((select Id from Usuarios where legajo = 'UsuarioDistribucion'),(select Id from Roles where nombreRole = 'Distrubucion')),
((select Id from Usuarios where legajo = 'UsuarioEntrega'),(select Id from Roles where nombreRole = 'Entrega')),
((select Id from Usuarios where legajo = 'UsuarioConsulta'),(select Id from Roles where nombreRole = 'Consulta')),	
((select Id from Usuarios where legajo = 'UsuarioCallCenter'),(select Id from Roles where nombreRole = 'CallCenter'))
