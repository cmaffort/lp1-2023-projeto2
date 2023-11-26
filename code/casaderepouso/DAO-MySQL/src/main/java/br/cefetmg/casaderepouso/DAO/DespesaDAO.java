package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.dto.Despesas;
import br.cefetmg.casaderepouso.idao.IDespesaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Júlia
 */
public class DespesaDAO implements IDespesaDAO {

    @Override
    public boolean cadastrar(Despesas pagamento) {
        String sqlDespesa = "INSERT INTO despesas(destinatario, pagante, telefone, identidade, data, hora, descricao) VALUES(?,?,?,?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdlardeidosos", "root", "admin");
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
}
