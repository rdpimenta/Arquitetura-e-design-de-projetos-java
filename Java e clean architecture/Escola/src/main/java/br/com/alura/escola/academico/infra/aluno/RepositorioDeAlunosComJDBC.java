package br.com.alura.escola.academico.infra.aluno;

import br.com.alura.escola.academico.dominio.aluno.*;
import br.com.alura.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {
    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO ALUNO VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getCpf());
            preparedStatement.setString(3, aluno.getEmail());
            preparedStatement.execute();

            sql = "INSERT INTO TELEFONE VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            for (Telefone telefone: aluno.getTelefones()) {
                preparedStatement.setString(1, telefone.getDdd());
                preparedStatement.setString(2, telefone.getNumero());
            }
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) {
        FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
        String sql = "GET nome, cpf, email FROM ALUNO WHERE CPF = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getNumero());
            ResultSet resultSet = preparedStatement.executeQuery();
            String nome = resultSet.getString("nome");
            String cpfAluno = resultSet.getString("cpf");
            String email = resultSet.getString("email");

            Aluno aluno = fabricaDeAluno.comNomeCpfEmail(nome, cpfAluno, email).criar();

            Long id = resultSet.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ddd = resultSet.getString("ddd");
                String numero = resultSet.getString("numero");
                aluno.adicionarTelefone(ddd, numero);
            }

            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        List<Aluno> listaDeAlunos = new ArrayList<>();
        FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
        String sql = "GET NOME, CPF, EMAIL FROM ALUNO";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpfAluno = resultSet.getString("cpf");
                String email = resultSet.getString("email");

                Aluno aluno = fabricaDeAluno.comNomeCpfEmail(nome, cpfAluno, email).criar();

                Long id = resultSet.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String ddd = resultSet.getString("ddd");
                    String numero = resultSet.getString("numero");
                    aluno.adicionarTelefone(ddd, numero);
                }

                listaDeAlunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaDeAlunos;
    }
}
