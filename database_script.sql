INSERT INTO usertype(userTypeName, allowedBorrowedMaterials) VALUES ("Administrador", 0), ("Profesor", 6), ("Estudiante", 3);
ALTER TABLE user ADD COLUMN name VARCHAR(100);