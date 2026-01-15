import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(1L, "Central", "Rua A, 123", "1111-1111");
        Exemplar exemplar = new Exemplar(10L, "EX-001", "DISPONIVEL", true);
        biblioteca.cadastrarExemplar(exemplar);

        Livro livro = new Livro(100L, "Java Basico", "9780000000000", 2024, "Tecnologia");
        Autor autor = new Autor(200L, "Ana Silva", "Brasileira", new Date(), "Autora de tecnologia.");
        Editora editora = new Editora(300L, "TechBooks", "00.000.000/0001-00", "Rua B, 456", "2222-2222");
        livro.adicionarAutor(autor);
        livro.setEditora(editora);

        Usuario usuario = new Usuario(400L, "Carlos", "MAT123", "carlos@email.com", "9999-9999", "ALUNO");
        Reserva reserva = new Reserva(500L, new Date(), new Date(System.currentTimeMillis() + 86400000L), "ABERTA", livro);
        usuario.fazerReserva(reserva);

        Emprestimo emprestimo = new Emprestimo(600L, new Date(), new Date(System.currentTimeMillis() + 604800000L),
                "EM_ANDAMENTO", livro, exemplar);
        usuario.adicionarEmprestimo(emprestimo);

        System.out.println("Reservas do usuario: " + usuario.consultarReservas().size());
        System.out.println("Emprestimos do usuario: " + usuario.consultarEmprestimos().size());
        System.out.println("Info do livro: " + livro.consultarInformacoes());
        System.out.println("Exemplar disponivel: " + exemplar.verificarDisponibilidade());
    }
}
