INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(1,'Mateo', 'Apellido1', 'mateo@gmail.com', '2019-11-25','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(2,'Nicolas', 'Apellido2', 'nicolas@gmail.com', '2019-11-26','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(3,'Joaquin', 'Apellido3', 'joaquin@gmail.com', '2019-11-17','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(4,'Sebastian', 'Apellido4', 'sebastian@gmail.com', '2019-11-07','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(5,'Lorena', 'Apellido5', 'lorena@gmail.com', '2019-11-17','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(6,'Silvia', 'Apellido6', 'silvia@gmail.com', '2019-11-12','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(7,'Ivan', 'Apellido7', 'ivan@gmail.com', '2019-11-13','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(8,'Rosdaly', 'Apellido8', 'rosda@gmail.com', '2019-11-14','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(9,'Ximena', 'Apellido9', 'xime@gmail.com', '2019-11-16','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(10,'Rocio', 'Apellido10', 'rocio@gmail.com', '2019-11-11','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(11,'Teresa', 'Apellido11', 'tere@gmail.com', '2019-11-17','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(12,'Edwin', 'Apellido12', 'edwin@gmail.com', '2019-11-12','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(13,'Ramiro', 'Apellido13', 'ramiro@gmail.com', '2019-11-25','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(14,'Carlos', 'Apellido14', 'carlos@gmail.com', '2019-11-26','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(15,'Roberto', 'Apellido15', 'roberto@gmail.com', '2019-11-28','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(16,'Andres', 'Apellido16', 'andres@gmail.com', '2019-11-29','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(17,'Matias', 'Apellido17', 'matias@gmail.com', '2019-11-21','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(18,'Soledad', 'Apellido18', 'soledad@gmail.com', '2019-11-22','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(19,'Cristina', 'Apellido19', 'cris@gmail.com', '2019-11-23','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(20,'Patricia', 'Apellido20', 'paty@gmail.com', '2019-11-24','');
INSERT INTO clientes (id, nombre,apellido, mail, fecha_creacion, foto) values(21,'Belen', 'Apellido21', 'belen@gmail.com', '2019-11-25','');

INSERT INTO productos (id, nombre,precio, fecha) values(1,'Panasonic pantalla LCD', 150, '2019-11-25');
INSERT INTO productos (id, nombre,precio, fecha) values(2,'Sony camara digital', 250, '2019-11-25');
INSERT INTO productos (id, nombre,precio, fecha) values(3,'Apple ipod shuffle', 100, '2019-11-25');
INSERT INTO productos (id, nombre,precio, fecha) values(4,'Sony notebook z110', 1150, '2019-11-25');
INSERT INTO productos (id, nombre,precio, fecha) values(5,'Hewlet packard 1520M', 450, '2019-11-25');
INSERT INTO productos (id, nombre,precio, fecha) values(6,'Biachi bicicleta aro 26', 300, '2019-11-25');
INSERT INTO productos (id, nombre,precio, fecha) values(7,'Mica comoda 5 cajones', 50, '2019-11-25');

INSERT INTO facturas (id, descripcion, fecha, observacion, cliente_id) values(1,'compra temporal 1', '2019-11-25', 'observacion 1', 1);
INSERT INTO factura_items (id, cantidad, producto_id, factura_id) values(1,1, 1, 1);
INSERT INTO factura_items (id, cantidad, producto_id, factura_id) values(2,3, 2, 1);
INSERT INTO factura_items (id, cantidad, producto_id, factura_id) values(3,2, 3, 1);

INSERT INTO facturas (id, descripcion, fecha, observacion, cliente_id) values(2,'compra dos', '2019-11-25', null, 1);
INSERT INTO factura_items (id, cantidad, producto_id, factura_id) values(4,3, 7, 2);
INSERT INTO factura_items (id, cantidad, producto_id, factura_id) values(5,2, 5, 2);
INSERT INTO factura_items (id, cantidad, producto_id, factura_id) values(6,1, 3, 2);