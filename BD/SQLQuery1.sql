CREATE TABLE Categoria(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(100) NOT NULL,
);
INSERT INTO Categoria (nombre) VALUES
('Camisas'),
('Pantalones'),
('Zapatos'),
('Accesorios');

EXEC sp_help Usuarios
CREATE TABLE Producto(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(255) NOT NULL,
	descripcion NVARCHAR(MAX) NOT NULL,
	categoria_id BIGINT FOREIGN KEY REFERENCES Categoria(id)
	ON DELETE CASCADE,
	precio_compra DECIMAL(10,2) NOT NULL,
	precio_venta DECIMAL(10,2) NOT NULL
);

ALTER PROCEDURE SP_ImagenesPrueba
@id BIGINT,
@foto VARBINARY(MAX)
AS
BEGIN
	UPDATE Producto
	SET Foto_Principal = @foto
	WHERE id = @id;
END;
SELECT * FROM Producto
CREATE PROCEDURE SP_ObtenerTodosLosProductos
AS
BEGIN
	SELECT P.id,P.nombre,P.descripcion,P.precio_compra,precio_venta
	FROM Producto P
END;
INSERT INTO Producto (nombre, descripcion, categoria_id, precio_compra, precio_venta) VALUES
('Camisa Formal Blanca', 'Camisa blanca de manga larga, ideal para eventos formales.', 1, 20.00, 35.00),
('Pantalón Jeans Azul', 'Pantalón de mezclilla azul con corte clásico.', 2, 25.00, 50.00),
('Zapatos de Cuero Negro', 'Zapatos de cuero negro con suela antideslizante.', 3, 40.00, 80.00),
('Reloj Deportivo', 'Reloj resistente al agua con funciones deportivas.', 4, 15.00, 30.00);

CREATE TABLE Talla(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL
);
INSERT INTO Talla (nombre) VALUES
('S'),
('M'),
('L'),
('XL');

CREATE TABLE Color(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	nombre NVARCHAR(50) NOT NULL,
	valor_hex NVARCHAR(100) NOT NULL
);
INSERT INTO Color (nombre, valor_hex) VALUES
('Blanco', '#FFFFFF'),
('Negro', '#000000'),
('Rojo', '#FF0000'),
('Azul', '#0000FF'),
('Verde Esmeralda', '#39E079'),
('Gris', '#808080');

CREATE TABLE Inventario(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	producto_id BIGINT FOREIGN KEY REFERENCES Producto(id)
	ON DELETE CASCADE,
	talla_id BIGINT FOREIGN KEY REFERENCES Talla(id)
	ON DELETE CASCADE,
	color_id BIGINT FOREIGN KEY REFERENCES Color(id)
	ON DELETE CASCADE,
	cantidad INT NOT NULL,
);
INSERT INTO Inventario (producto_id, talla_id, color_id, cantidad) VALUES
(1, 1, 1, 50),  -- Camisa Formal Blanca, Talla S, Color Blanco
(1, 2, 1, 30),  -- Camisa Formal Blanca, Talla M, Color Blanco
(2, 3, 4, 40),  -- Pantalón Jeans Azul, Talla L, Color Azul
(3, 4, 2, 20),  -- Zapatos de Cuero Negro, Talla XL, Color Negro
(4, 1, 3, 15),  -- Reloj Deportivo, Talla S, Color Rojo
(4, 1, 5, 10);  -- Reloj Deportivo, Talla S, Color Verde Esmeralda

CREATE PROCEDURE SP_ObtenerColoresPorIdProducto
@id BIGINT
AS
BEGIN
	SELECT DISTINCT c.id,c.nombre,c.valor_hex
	FROM Producto P
	INNER JOIN Inventario I ON P.id=I.producto_id
	INNER JOIN Color C ON I.color_id=C.id
	WHERE P.id = 1
		AND I.cantidad > 0; 
END;
ALTER PROCEDURE SP_ObtenerColoresPorIdProducto
@id BIGINT
AS
BEGIN
	SELECT c.id, c.nombre, c.valor_hex
	FROM Color C
	WHERE C.id IN (
		SELECT I.color_id
		FROM Inventario I
		WHERE I.producto_id = @id
		AND I.cantidad > 0
	);
END;
EXEC SP_ObtenerColoresPorIdProducto 1
CREATE PROCEDURE SP_ObtenerTallasPorIdProducto
@id BIGINT
AS
BEGIN
	SELECT t.id, t.nombre
	FROM Talla T
	WHERE T.id IN (
		SELECT I.talla_id
		FROM Inventario I
		WHERE I.producto_id = @id
		AND I.cantidad > 0
	);
END;

CREATE TABLE Carrito_Compra(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	usuario_id BIGINT FOREIGN KEY REFERENCES Usuarios(id),
	producto_id BIGINT FOREIGN KEY REFERENCES Producto(id),
	talla_id BIGINT FOREIGN KEY REFERENCES Talla(id),
	color_id BIGINT FOREIGN KEY REFERENCES Color(id),
	cantidad INT,
	precio DECIMAL(10,2),
);

CREATE PROCEDURE SP_TallasParaEsteColor
    @idColo BIGINT,
    @idProducto BIGINT
AS
BEGIN
    SELECT DISTINCT T.id, T.nombre
    FROM Talla T
    INNER JOIN Inventario I ON T.id = I.talla_id
    WHERE I.color_id = @idColo
      AND I.producto_id = @idProducto
      AND I.cantidad > 0;  -- Aseguramos que haya cantidad disponible
END;

