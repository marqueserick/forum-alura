package br.com.marqueserick.forum.repository;

import br.com.marqueserick.forum.modelo.Curso;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void deveRetornarCursoPorNome(){
        String nomeCurso = "HTML 5";

        Curso html5 = new Curso();
        html5.setNome(nomeCurso);
        html5.setCategoria("Programação");
        entityManager.persist(html5);

        Curso curso = cursoRepository.findByNome(nomeCurso);
        assertEquals(nomeCurso, curso.getNome());
        assertNotNull(curso);
    }

    @Test
    public void deveRetornarVazioSeNaoExiste(){
        String nomeCurso = "HTML";
        Curso curso = cursoRepository.findByNome(nomeCurso);
        assertNull(curso);
    }
}
