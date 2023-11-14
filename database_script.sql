INSERT INTO usertype(userTypeName, allowedBorrowedMaterials) VALUES ("Administrador", 0), ("Profesor", 6), ("Estudiante", 3);

SELECT identificationCode, email, ut.userTypeName, phone FROM user u INNER JOIN userType ut ON u.userTypeId = ut.userTypeId;