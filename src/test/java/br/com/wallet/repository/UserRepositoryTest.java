package br.com.wallet.repository;

import br.com.wallet.entity.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class UserRepositoryTest {

    private static final String EMAIL = "joedessouza@gmail.com";

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        var user = new User();
        user.setEmail(EMAIL);
        user.setName("Joedes Souza de Freitas Junior");
        user.setPassword("teste123");
        userRepository.save(user);
    }

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("Teste responsável por validar se o usuário está sendo salvo no banco e retornando o ID corretamento!")
    void deveSalvarUsuarioNoBancoDeDados() {
        var user = new User();
        user.setEmail("joedessouza@gmail.com");
        user.setName("Joedes Souza de Freitas Junior");
        user.setPassword("teste123");

        var response = userRepository.save(user);
        Assertions.assertNotNull(response.getId());
    }

    @Test
    @DisplayName("Teste responsável por buscar o usuário no banco de dados através do email.")
    void deveBuscarUsuarioNoBancoDeDadosPorEmail() {
        Optional<User> responseUser = userRepository.findByEmailEquals(EMAIL);
        Assertions.assertTrue(responseUser.isPresent());
        Assertions.assertEquals(EMAIL, responseUser.get().getEmail());
    }
}
