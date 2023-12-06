package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Despesas;
import br.cefetmg.casaderepouso.idao.IDespesaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Júlia
 */
public class DespesaDAO implements IDespesaDAO {

    @Override
    public boolean cadastrar(Despesas pagamento) {
        String sqlDespesa = "INSERT INTO despesas(destinatario, pagante, telefone, identidade, dia, hora, descricao, valor) VALUES(?,?,?,?,?,?,?,?)";

        try {


            Connection con = DAO.conectar();

            PreparedStatement pstm = con.prepareStatement(sqlDespesa);

            System.out.println("teste");

            //Transforma os ? nas variaveis
            pstm.setString(1, pagamento.getDestinatario());
            pstm.setString(2, pagamento.getPagante());
            pstm.setString(3, pagamento.getTelefone());
            pstm.setString(4, pagamento.getIdentidade());
            pstm.setString(5, pagamento.getData());
            pstm.setString(6, pagamento.getHora());
            pstm.setString(7, pagamento.getDescricao());
            pstm.setString(8, pagamento.getValor());

            //Executar
            pstm.executeUpdate();
            //encerrar conexao
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return true;
    }

    @Override
    public List<Despesas> listarTodos() {
        String query = "SELECT * FROM despesas";
        List<Despesas> despesasList = new ArrayList<>();
        try {
            
            Connection connection = DAO.conectar();

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String destinatario = rs.getString(1);
                String pagante = rs.getString(2);
                String telefone = rs.getString(3);
                String identidade = rs.getString(4);
                String data = rs.getString(5);
                String hora = rs.getString(6);
                String descricao = rs.getString(7);
                String valor = rs.getString(8);

                Despesas despesa = new Despesas(destinatario, pagante, telefone, identidade, descricao, valor, data, hora);

                despesasList.add(despesa);

            }
            connection.close();
            rs.close();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return despesasList;
    }
}
