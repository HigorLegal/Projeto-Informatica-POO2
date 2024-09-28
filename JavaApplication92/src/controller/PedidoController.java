/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pedido;

public class PedidoController {
    
    public List<Pedido> listarpedidos(int id) {
        String sql = "select ped.pkpedido,pro.nome,pro.valor "
                + "from tbpedido ped "
                + "inner join tbproduto pro "
                + "on ped.fkproduto=pro.pkproduto "
                + "where ped.fkusuario=?;";

        List<Pedido> listaPedidos = new ArrayList<>();

//cria um gerenciador de conexão
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            
            comando = gerenciador.prepararComando(sql);
 comando.setInt(1, id);
            resultado = comando.executeQuery();
          
            while (resultado.next()) {

              
                Pedido ped = new Pedido();


ped.setPkpedido(resultado.getInt("pkpedido"));
ped.setNomeP(resultado.getString("nome"));
ped.setValorP(resultado.getDouble("valor"));
        

    
                

//adicionando o ped na lista
                listaPedidos.add(ped);

            }
    
//ele mostra o erro em um JOptinPane se algo der errado no sql
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

            //esse finally sempre  vai ser executado no final mesmo se der errado 
        } finally {
            // ele fecha a conexao com o sql
            gerenciador.fecharConexao(comando, resultado);
        }
        return listaPedidos;
    }
    
    
    
    
    
    
    
     public boolean deletarPedido(int id) {
        String sql = "DELETE FROM tbpedido WHERE pkpedido = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, id);

            comando.executeUpdate();

            return true;

        } catch (SQLException ex) {
            //mostra o erro
            JOptionPane.showMessageDialog(null, "erro ao excluir " + ex);
        } finally {
            //fecha conxao
            gerenciador.fecharConexao(comando);
        }
        return false;
    }
}

