package br.usp.ime.mac321.ep2;
import java.util.List;

public interface LeitorBibliotecaDAO {
	public List<Livro>      getAllLivros(String      nomeArquivoLivros);
	public List<Exemplar>   getAllExemplares(String  nomeArquivoExemplares);
	public List<Usuario>    getAllUsuarios(String    nomeArquivoUsuarios);
	public List<Emprestimo> getAllEmprestimos(String nomeArquivoEmprestimos);
}
