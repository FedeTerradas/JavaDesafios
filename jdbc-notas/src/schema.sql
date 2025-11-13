USE escuela;
CREATE TABLE IF NOT EXISTS estudiantes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL
);
CREATE TABLE IF NOT EXISTS calificaciones (
  id INT AUTO_INCREMENT PRIMARY KEY,
  estudiante_id INT NOT NULL,
  materia VARCHAR(120) NOT NULL,
  nota DECIMAL(4,2) NOT NULL,
  fecha DATE NOT NULL,
  FOREIGN KEY(estudiante_id) REFERENCES estudiantes(id)
);



ALTER TABLE calificaciones
DROP FOREIGN KEY calificaciones_ibfk_1;

ALTER TABLE calificaciones
ADD CONSTRAINT calificaciones_ibfk_1
FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id)
ON DELETE CASCADE;