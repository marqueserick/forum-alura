package br.com.marqueserick.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marqueserick.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
